package com.rohit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO {

	public AdminBean checkAdminLogin(String uname, String pwd) {
		
		AdminBean abean=null;
		
		try {
			Connection con = DBConnect.connect();
			PreparedStatement pstm = con.prepareStatement("select * from admin where uname=? and PWORD=?");
			pstm.setString(1, uname);
			pstm.setString(2, pwd);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				abean= new AdminBean();
				abean.setU_name(rs.getString(1));
				abean.setU_pwd(rs.getString(2));
				abean.setU_fname(rs.getString(3));
				abean.setU_lname(rs.getString(4));
				abean.setU_addr(rs.getString(5));
				abean.setU_mid(rs.getString(6));
				abean.setU_phno(rs.getString(7));
				
				System.out.println(rs.getString(1)+" "+rs.getString(2));
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return abean;

	}
}
