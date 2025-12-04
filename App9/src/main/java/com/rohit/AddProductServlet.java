package com.rohit;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/aps")
public class AddProductServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession(false);
			
			if(session==null) {
				req.getRequestDispatcher("AdminLogin.html").forward(req, res);
			}
			else {
				ProductBean pb = new ProductBean();
				pb.setP_code(req.getParameter("pcode"));
				pb.setP_name(req.getParameter("pname"));
				pb.setP_company(req.getParameter("pcom"));
				pb.setP_price(req.getParameter("pprice"));
				pb.setP_qty(req.getParameter("pqty"));
				
				int rowCount = new AddProductDAO().insertProduct(pb);
				
				if(rowCount>0) {
					req.setAttribute("msg", "Products added to the Inventory");
					req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
				}
				else {
					throw new RuntimeException("Product inventory not Updated !!!");
				}
				
			}
		}
		catch(Exception e) {
			req.setAttribute("msg", "Double product Id's are Not allowed");
			req.getRequestDispatcher("Error.jsp").forward(req, res);
		}
	}

}
