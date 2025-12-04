package com.rohit;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO {

	public int insertProduct(ProductBean pb) throws Exception {
		int rowCount=0;
		
		try {
			Connection con = DBConnect.connect();
			PreparedStatement pstm = con.prepareStatement("insert into product values(?,?,?,?,?)");
			pstm.setString(1, pb.getP_code());
			pstm.setString(2, pb.getP_name());
			pstm.setString(3, pb.getP_company());
			pstm.setString(4, pb.getP_price());
			pstm.setString(5, pb.getP_qty());
			
			 rowCount = pstm.executeUpdate();
			
		}
		catch(Exception e) {
			throw e;
		}
		
		
		
		return rowCount;
	}
}
