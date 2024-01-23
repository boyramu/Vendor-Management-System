package com.vendormanagement.web;

import com.vendor.management.DAO.VendorDAO;
import com.vendormanagement.model.Vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        int vendor_id = Integer.parseInt(request.getParameter("vendorId"));
        String vendor_name = request.getParameter("vendorName");
        int bank_accno= Integer.parseInt(request.getParameter("bankAccNo"));
        String bank_name = request.getParameter("bankName");
        String addressline = request.getParameter("addressLine");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        int zipcode = Integer.parseInt(request.getParameter("zipCode"));

        // Create a Vendor object with updated details
        Vendor updatedVendor = new Vendor(vendor_id, vendor_name, bank_accno, bank_name, addressline, city, country, zipcode);

        try {
            // Update the vendor details in the database
            VendorDAO vendordao = new VendorDAO();
            vendordao.updateVendor(updatedVendor);

            // Redirect to the list page after successful update
            response.sendRedirect("vendorlist.jsp");
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as appropriate
            // Redirect to an error page or handle errors as needed
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
        }
    }
}
