package bank.bharat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.bharat.bean.RegisterBean;
import bank.bharat.connection.ConnectionProvider;

public class LoginDAO {

	public RegisterBean fatchData(String uname) {
		RegisterBean rb = null;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from bank_users where USERNAME=?");
			pstm.setString(1, uname);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				rb = new RegisterBean();
				rb.setFullName(rs.getString(2));
				rb.setEmail(rs.getString(3));
				rb.setUserName(rs.getString(4));
				rb.setPassword(rs.getString(5));
				rb.setPhone(rs.getString(6));
				rb.setAccno(rs.getString(7));
				rb.setBalance(rs.getDouble(8));
				rb.setAddress(rs.getString(9));
				rb.setAccountType(rs.getString(10));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return rb;
	}
}
