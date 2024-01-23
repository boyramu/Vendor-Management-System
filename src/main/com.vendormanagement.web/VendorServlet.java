package com.vendormanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;

import com.vendor.management.DAO.VendorDAO;
import com.vendormanagement.model.Vendor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class VendorServlet
 */
@WebServlet("/vendors/*")
public class VendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorDAO vendordao;
       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public VendorServlet() throws SQLException {
        super();
        vendordao=new VendorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		// TODO Auto-generated method stub
		try {
			vendordao = new VendorDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	      protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doGet(request, response);
		    }

		 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException 
		 {
             // TODO Auto-generated method stub
		String action = request.getPathInfo();
		try {
            switch (action) 
            {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertVendor(request, response);
                    break;
                case "/delete":
                    deleteVendor(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateVendor(request, response);
                    break;
                default:
                    listVendor(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listVendor(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Vendor > listUser = vendordao.selectAllVendors();
        request.setAttribute("listUser", listUser);
        RequestDispatcher rd=request.getRequestDispatcher("vendorlist.jsp");
        rd.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	RequestDispatcher rd=request.getRequestDispatcher("vendorform.jsp");
        rd.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int vendor_id = Integer.parseInt(request.getParameter("id"));
        Vendor existingUser = vendordao.selectVendor(vendor_id);
        RequestDispatcher rd=request.getRequestDispatcher("vendorform.jsp");
        request.setAttribute("user", existingUser);
        rd.forward(request, response);

    }

    private void insertVendor(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String vendor_name=request.getParameter("vendorName");
        int bank_accno=Integer.parseInt(request.getParameter("bankAccountNo"));
        String bank_name=request.getParameter("bankName");
        String addressline=request.getParameter("addressLine2");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        int zipcode=Integer.parseInt(request.getParameter("zipCode"));
        Vendor v = new Vendor(vendor_name,bank_accno,bank_name,addressline,city,country,zipcode);
        vendordao.insertVendor(v);
        response.sendRedirect("list");
       
        
    }

    private void updateVendor(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	int vendor_id=Integer.parseInt(request.getParameter("vendor_id"));
    	String vendor_name=request.getParameter("vendorName");
        int bank_accno=Integer.parseInt(request.getParameter("bankAccountNo"));
        String bank_name=request.getParameter("bankName");
        String address=request.getParameter("addressLine2");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        int zipcode=Integer.parseInt(request.getParameter("zipCode"));
        Vendor v = new Vendor(vendor_id,vendor_name,bank_accno,bank_name,address,city,country,zipcode);
        vendordao.updateVendor(v);
        response.sendRedirect("list");
    }

    private void deleteVendor(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int vendor_id = Integer.parseInt(request.getParameter("vendor_id"));
        Vendor v=new Vendor(vendor_id);
        vendordao.deleteVendor(v);
        response.sendRedirect("list");

    }
    
}

