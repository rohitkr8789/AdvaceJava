package bank.bharat.servlet;

import java.io.IOException;

import bank.bharat.bean.RegisterBean;
import bank.bharat.dao.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		RegisterBean rb = new LoginDAO().fatchData(uname);
		
		if(rb==null) {
			req.setAttribute("msg", "Invalid UserName..");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
		
		
			if(pass.equals(rb.getPassword())) {
				session.setAttribute("rb", rb);
				String fname=rb.getFullName();
				System.out.println(fname);
				session.setAttribute("fname", fname);
				req.getRequestDispatcher("Dashboard.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "Invalid Password..");
				req.getRequestDispatcher("Login.jsp").forward(req, res);
			}
		
		
		
	}
}
