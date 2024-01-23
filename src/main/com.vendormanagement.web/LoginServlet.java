package com.vendormanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.vendor.management.DAO.UserRegister;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        // In a real application, validate the credentials against a database
        // For simplicity, using hardcoded credentials in this example
        
        UserRegister ur=new UserRegister();
        
        // Check if the entered credentials are valid
        try {
			if (ur.getUser(username,password)) {
			    // Successful login
				jakarta.servlet.http.HttpSession session = request.getSession();
				session.setAttribute("username",username);
			    response.sendRedirect("vendorlist.jsp");
			} else {
			    // Failed login
			    response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println("<html><body><h2>Login Failed. Please check your username and password.</h2></body></html>");
			    response.sendRedirect("login.jsp");
			}
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
