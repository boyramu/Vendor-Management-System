package com.vendormanagement.web;

import java.io.IOException;

import com.vendor.management.DAO.VendorDAO;
import com.vendormanagement.model.Vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the vendorId parameter from the URL
        int vendorId = Integer.parseInt(request.getParameter("vendorId"));
    
        // Perform deletion using VendorDAO
        try {
            VendorDAO vendorDAO = new VendorDAO();
            Vendor v=new Vendor(vendorId);
            boolean deleted = vendorDAO.deleteVendor(v);

            if (deleted) {
                // Vendor deleted successfully
                response.sendRedirect("vendorlist.jsp");
            } else {
                // Handle the case where deletion fails
                response.getWriter().println("Failed to delete the vendor with ID: " + vendorId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
