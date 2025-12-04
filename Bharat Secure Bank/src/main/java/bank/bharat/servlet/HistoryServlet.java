package bank.bharat.servlet;

import java.io.IOException;

import bank.bharat.bean.RegisterBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//WebServlet("/history")
public class HistoryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if(session==null) {
			
		}
		else {
			 RegisterBean txn_data =(RegisterBean) session.getAttribute("senderData");
			 
			 System.out.println(txn_data);
			 
		}
	}

}
