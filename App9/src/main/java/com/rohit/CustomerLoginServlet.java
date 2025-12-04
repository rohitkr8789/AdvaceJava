package com.rohit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer")
public class CustomerLoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String fname = new CustomerLoginDAO().LoginData(req.getParameter("uname"), req.getParameter("pass"));
		
		if(fname==null) {
			pw.println("<h2><center>Login Failed</h2>");
			req.getRequestDispatcher("CustomerLogin.html").include(req, res);
		}
		else {
			
			req.setAttribute("fname", fname);
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
	}
}
