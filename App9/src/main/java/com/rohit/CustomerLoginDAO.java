package com.rohit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO {

	public String LoginData(String uname,String pass) {
		String name=null;
		
		try {
			Connection con = DBConnect.connect();
			PreparedStatement pstm = con.prepareStatement("select fname from customer where uname=? and password=?");
			pstm.setString(1, uname);
			pstm.setString(2, pass);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				name=rs.getString(1);
				System.out.print(name);
			}
			else{
				System.err.println("Did not data found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
}
