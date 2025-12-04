package com.rohit;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegisterDAO {

	public int customerDetails(CustomerBean cb) {
		int rowCount=0;
		
		try {
			Connection con = DBConnect.connect();
			PreparedStatement pstm = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			pstm.setString(1, cb.getCuname());
			pstm.setString(2, cb.getCpass());
			pstm.setString(3, cb.getCfname());
			pstm.setString(4, cb.getClname());
			pstm.setString(5, cb.getCadds());
			pstm.setString(6, cb.getCmail());
			pstm.setString(7, cb.getCphone());
			
			 rowCount = pstm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return rowCount;
	}
}
