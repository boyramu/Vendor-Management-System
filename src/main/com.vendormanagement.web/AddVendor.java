package com.vendormanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.vendor.management.DAO.VendorDAO;
import com.vendormanagement.model.Vendor;

@WebServlet("/new")
public class AddVendor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve details from the form
        String vendor_name = request.getParameter("vendorName");
        int bank_accno = Integer.parseInt(request.getParameter("bankAccNo"));
        String bank_name = request.getParameter("bankName");
        String addressline = request.getParameter("addressLine2");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        int zipcode = Integer.parseInt(request.getParameter("zipCode"));
        Vendor v=new Vendor(vendor_name,bank_accno,bank_name,addressline,city,country,zipcode);
        try {
			VendorDAO vendordao=new VendorDAO();
			vendordao.insertVendor(v);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("vendorlist.jsp");

        // You can use these values as needed, such as saving them to a database
        // or performing other business logic.

        // For now, let's print them to the console for demonstration purposes.
        

        // You can redirect to a confirmation page or perform further actions here.
    }
}
