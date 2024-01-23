package com.vendor.management.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegister {
    private String jdbcURL = "jdbc:mysql://localhost:3306/vendordb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";
    private static final String INSERT = "INSERT INTO vendorlogin" + "(username,password)" + "values(?,?);";
    private static final String GetUser = "SELECT * FROM vendorlogin WHERE password=?";
    Connection connection = null;

    public UserRegister() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveUser(String username, int password) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT);
        stmt.setString(1, username);
        stmt.setInt(2, password);
        int i = stmt.executeUpdate();
        return i == 1;
    }

    public boolean getUser(String username, String password) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(GetUser);
        stmt.setString(1, password);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            String usernamedb = res.getString("username");
            String passworddb = res.getString("password");
            if (username.equals(usernamedb) && password.equals(passworddb)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
