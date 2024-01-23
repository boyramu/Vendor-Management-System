package com.vendor.management.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vendormanagement.model.Vendor;

public class VendorDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/vendordb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private static final String INSERT_VENDOR = "INSERT INTO vendordata"
            + "(vendor_name,bank_accno,bank_name,address,city,country,zipcode)"
            + "values(?,?,?,?,?,?,?);";

    private static final String SELECT_VENDOR_BY_ID = "SELECT * FROM vendordata WHERE vendor_id=?";
    private static final String SELECT_ALL_VENDORS = "SELECT * FROM vendordata;";
    private static final String DELETE_VENDOR = "DELETE FROM vendordata WHERE vendor_id = ?;";
    private static final String UPDATE_VENDOR = "UPDATE vendordata SET vendor_name=?, bank_accno=?, bank_name=?, address=?, city=?, country=?, zipcode=? WHERE vendor_id = ?;";

    Connection connection = null;

    public VendorDAO() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertVendor(Vendor v) throws SQLException {
        System.out.println(INSERT_VENDOR);
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VENDOR)) {
            preparedStatement.setString(1, v.getVendor_name());
            preparedStatement.setInt(2, v.getBank_accno());
            preparedStatement.setString(3, v.getBank_name());
            preparedStatement.setString(4, v.getAddressline());
            preparedStatement.setString(5, v.getCity());
            preparedStatement.setString(6, v.getCountry());
            preparedStatement.setInt(7, v.getZipcode());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Vendor selectVendor(int id) {
        Vendor v = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VENDOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int vendor_id = rs.getInt("vendor_id");
                String vendor_name = rs.getString("vendor_name");
                int bank_accno = rs.getInt("bank_accno");
                String bank_name = rs.getString("bank_name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String country = rs.getString("country");
                int zipcode = rs.getInt("zipcode");
                v = new Vendor(vendor_id, vendor_name, bank_accno, bank_name, address, city, country, zipcode);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return v;
    }

    public List<Vendor> selectAllVendors() {
        List<Vendor> vendors = new ArrayList<>();
        try {
            java.sql.Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_VENDORS);

            while (rs.next()) {
                int vendor_id = rs.getInt("vendor_id");
                String vendor_name = rs.getString("vendor_name");
                int bank_accno = rs.getInt("bank_accno");
                String bank_name = rs.getString("bank_name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String country = rs.getString("country");
                int zipcode = rs.getInt("zipcode");

                vendors.add(new Vendor(vendor_id, vendor_name, bank_accno, bank_name, address, city, country, zipcode));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return vendors;
    }

    public boolean deleteVendor(Vendor v) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_VENDOR)) {
            statement.setInt(1, v.getVendor_id());
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateVendor(Vendor v) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_VENDOR)) {
            statement.setString(1, v.getVendor_name());
            statement.setInt(2, v.getBank_accno());
            statement.setString(3, v.getBank_name());
            statement.setString(4, v.getAddressline());
            statement.setString(5, v.getCity());
            statement.setString(6, v.getCountry());
            statement.setInt(7, v.getZipcode());
            statement.setInt(8, v.getVendor_id());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
