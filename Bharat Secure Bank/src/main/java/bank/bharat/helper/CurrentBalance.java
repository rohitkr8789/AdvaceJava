package bank.bharat.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.bharat.connection.ConnectionProvider;

public class CurrentBalance {

	public static double currentBal(String accno) {
		double bal=0;
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstm = con.prepareStatement("select BALANCE from bank_users where ACCOUNT_NUMBER=?");
			pstm.setString(1, accno);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				bal=rs.getDouble(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bal;
	}
}
