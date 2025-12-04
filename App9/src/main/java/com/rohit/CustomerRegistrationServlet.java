package com.rohit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/custLogin")
public class CustomerRegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CustomerBean cb = new CustomerBean();
		
		cb.setCuname(req.getParameter("uname"));
		cb.setCpass(req.getParameter("upass"));
		cb.setCfname(req.getParameter("fname"));
		cb.setClname(req.getParameter("lname"));
		cb.setCadds(req.getParameter("adds"));
		cb.setCmail(req.getParameter("mail"));
		cb.setCphone(req.getParameter("mobile"));
		
		int rowCount = new CustomerRegisterDAO().customerDetails(cb);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(rowCount>0) {
			pw.println("Customer details accepted !!!");
			req.getRequestDispatcher("CustomerLogin.html").include(req, res);
		}
		else {
			pw.println("Customer details Not accepted !!!");
			req.getRequestDispatcher("Register.html").include(req, res);
		
		}
		
	}
}
