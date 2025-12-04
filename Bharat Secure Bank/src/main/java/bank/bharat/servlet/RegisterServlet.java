package bank.bharat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import bank.bharat.bean.RegisterBean;
import bank.bharat.dao.RegisterDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	String fullName=req.getParameter("flname");
	String email=req.getParameter("email");
	String phone=req.getParameter("phone");
	String uname=req.getParameter("uname");
	String pass=req.getParameter("pass");
	String cpass=req.getParameter("cpass");
	String addr=req.getParameter("addr");
	String acctype=req.getParameter("acctype");
	
	Long random=(long)(Math.random()*1000000000);
	String accno=String.valueOf(random);
	
	double balance=15000.0;
	
	RegisterBean rb = new RegisterBean();
	rb.setFullName(fullName);
	rb.setEmail(email);
	rb.setPhone(phone);
	rb.setUserName(uname);
	rb.setPassword(pass);
	rb.setCpassword(cpass);
	rb.setAddress(addr);
	rb.setAccountType(acctype);
	
	rb.setAccno(accno);
	rb.setBalance(balance);
	
	int rowCount = new RegisterDAO().registerData(rb);
	
	if(rowCount>=1) {
		HttpSession session = req.getSession();
		session.setAttribute("rb", rb);
		req.setAttribute("msg", "Register successfully");
		req.getRequestDispatcher("Login.jsp").forward(req, res);
	}
	else {
		req.setAttribute("msg", "Register Failed");
		req.getRequestDispatcher("Register.jsp").forward(req, res);

	}
}
}

