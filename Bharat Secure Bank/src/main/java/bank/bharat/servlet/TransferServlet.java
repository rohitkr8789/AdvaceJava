package bank.bharat.servlet;

import java.io.IOException;

import bank.bharat.bean.RegisterBean;
import bank.bharat.dao.LoginDAO;
import bank.bharat.dao.TransferDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		TransferDAO tf = new TransferDAO();
		
		HttpSession session = req.getSession(false);
		String mobile=req.getParameter("phone");
		double amount=Double.parseDouble(req.getParameter("amt"));
		
		if(amount<0) {
			req.setAttribute("amtmsg", "Invalid amount");
			req.getRequestDispatcher("Transfer.jsp").forward(req, res);
			return ;
		}
		String message=req.getParameter("mass");
		
		if(session == null) {
			res.sendRedirect("Login.jsp?msg=Login Expire..");
			return;
		}
		
		RegisterBean rb =(RegisterBean) session.getAttribute("rb");
		String olderUserMob=rb.getPhone();
		double balance=rb.getBalance();
		
		if(amount>balance) {
			req.setAttribute("msg", "Insufficitation Balance!!!");
			req.getRequestDispatcher("Transfer.jsp").forward(req, res);
			return;
		}
		
		String userName=rb.getUserName();
		RegisterBean senderData = tf.viewData(mobile);
		
		if(olderUserMob.equals(mobile)) {
			req.setAttribute("Errormsg", "Try Another Account!!");
			req.getRequestDispatcher("Transfer.jsp").forward(req, res);
		
		}
		
		int success = tf.balanceUpdate(userName, mobile, amount);
		
		if(success>0) {
			session.setAttribute("senderData", senderData);
			req.setAttribute("amt", amount);
			req.setAttribute("mess", message);
			req.setAttribute("msg", "Money send Sucessfully to ");
			req.getRequestDispatcher("Transfer.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Money not sended!!");
			req.getRequestDispatcher("Transfer.jsp").forward(req, res);
		
		}
		
		
		

		
		
	}
}
