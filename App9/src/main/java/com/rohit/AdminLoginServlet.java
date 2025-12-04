package com.rohit;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/alog")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminBean abean = new AdminLoginDAO().checkAdminLogin(req.getParameter("uname"), req.getParameter("pword"));
		
		if(abean==null) {
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("AdminBean", abean);
			System.out.println("abean :"+abean.getU_fname());
			req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
		}
	}
}
