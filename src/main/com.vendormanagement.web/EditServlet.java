package com.vendormanagement.web;

import com.vendor.management.DAO.VendorDAO;
import com.vendormanagement.model.Vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the vendor ID from the request parameters
        String vendorIdParam = request.getParameter("vendorId");

        if (vendorIdParam != null && !vendorIdParam.isEmpty()) {
            try {
                // Parse the vendor ID to an integer
                int vendorId = Integer.parseInt(vendorIdParam);

                // Retrieve the vendor details using the vendor ID
                VendorDAO vendordao = new VendorDAO();
                Vendor vendor = vendordao.selectVendor(vendorId);

                // You can now use the 'vendor' object to load the details for editing
                // For example, you might want to set attributes in the request and forward to an edit JSP page:
                request.setAttribute("vendor", vendor);
                request.getRequestDispatcher("/edit.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Handle the exception as appropriate
                response.sendRedirect(request.getContextPath() + "/list"); // Redirect to the list page if parsing fails
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception as appropriate
                response.sendRedirect(request.getContextPath() + "/list"); // Redirect to the list page in case of other exceptions
            }
        } else {
            // Handle the case when the vendorId parameter is not provided
            response.sendRedirect(request.getContextPath() + "/list"); // Redirect to the list page
        }
    }
}
