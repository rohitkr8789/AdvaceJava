package com.rohit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if(session==null) {
			req.getRequestDispatcher("AdminLogin.html").forward(req, resp);
		}
		else {
			String pcode = req.getParameter("pcode");
			ArrayList<ProductBean> al =(ArrayList<ProductBean>) session.getAttribute("ProductList");
			
			Iterator<ProductBean> i = al.iterator();
			ProductBean pb=null;
			while(i.hasNext()) {
				pb= i.next();
				
				if(pcode.equals(pb.getP_code())) {
					break;
				}
			}
			
			pb.setP_price(req.getParameter("pprice"));
			pb.setP_qty(req.getParameter("pqty"));
			
			int rowCount = new UpdateProductDAO().updateProduct(pb);
			
			if(rowCount>0) {
				req.setAttribute("msg", "Product inventory Updated !!!");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, resp);
			}
			else {
				throw new RuntimeException("Product inventory updation failed");
			}		
		}
	}
	
}
