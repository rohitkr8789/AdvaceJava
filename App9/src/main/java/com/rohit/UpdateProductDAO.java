package com.rohit;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {

	public int updateProduct(ProductBean pb) {
		int rowCount=0;
		
		try {
			Connection con = DBConnect.connect();
			PreparedStatement pstm = con.prepareStatement("update product set pprice=?, pqty=? where pcode=?");
			pstm.setString(1, pb.getP_price());
			pstm.setString(2, pb.getP_qty());
			pstm.setString(3, pb.getP_code());
			
			 rowCount = pstm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return rowCount;
	}
}
