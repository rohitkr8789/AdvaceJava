package bank.bharat.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bank.bharat.connection.ConnectionProvider;

public class MobileNoVerification {

	public void getMobile(String mobileno) {

		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstm = con.prepareStatement("select PHONE_NUMBER  from bank_users ");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
