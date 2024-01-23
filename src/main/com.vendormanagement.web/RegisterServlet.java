package com.vendormanagement.web;
import com.vendor.management.DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String confirmPassword = request.getParameter("confirmPassword");

	        // Check if passwords match
	        if (!password.equals(confirmPassword)) {
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            out.println("<html><body><h2>Passwords do not match. Please go back and try again.</h2></body></html>");
	            return;
	        }

	        // Print the retrieved data to the console (in a real application, you would save it to a database)
	        UserRegister ur=new UserRegister();
	        try {
				boolean res=ur.saveUser(username,Integer.parseInt(confirmPassword));
				if(res==true)
				{
					response.setContentType("text/html");
			        PrintWriter out = response.getWriter();
			        out.println("<html><body><h2>Registered successfully!</h2>");
			        out.println("<p>Click <a href=\"login.jsp\">here</a> to login.</p></body></html>");
				}
				else
				{
					response.setContentType("text/html");
			        PrintWriter out = response.getWriter();
			        out.println("<html><body><h2>Not Registered successfully!</h2>");
			        out.println("<p>Click <a href=\"register.jsp\">here</a> to register.</p></body></html>");
				}
				
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // Send a response to the client
	        
		
	}

}
