package com.rohit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductDAO {

	ArrayList<ProductBean> al= new ArrayList<>();
	
	public ArrayList<ProductBean> viewProduct(){
		
		try {
			Connection con = DBConnect.connect();
			PreparedStatement pstm = con.prepareStatement("select * from product");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				ProductBean pb= new ProductBean();
				
				pb.setP_code(rs.getString(1));
				pb.setP_name(rs.getString(2));
				pb.setP_company(rs.getString(3));
				pb.setP_price(rs.getString(4));
				pb.setP_qty(rs.getString(5));
				
				al.add(pb);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return al;
	}
}
