package bank.bharat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bank.bharat.bean.RegisterBean;
import bank.bharat.connection.ConnectionProvider;

public class RegisterDAO {

	public int registerData(RegisterBean rb) {
		int rowCount=0;
String sql="insert into bank_users(FULL_NAME,EMAIL,USERNAME,PASSWORD,"
		+ "PHONE_NUMBER,ACCOUNT_NUMBER,BALANCE,ADDRESS,ACCOUNT_TYPE,"
		+ "CREATED_AT ) values(?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, rb.getFullName());
			pstm.setString(2, rb.getEmail());
			pstm.setString(3, rb.getUserName());
			pstm.setString(4, rb.getPassword());
			pstm.setString(5, rb.getPhone());
			pstm.setString(6, rb.getAccno());
			pstm.setDouble(7, rb.getBalance());
			pstm.setString(8, rb.getAddress());
			pstm.setString(9, rb.getAccountType());
			
			 rowCount = pstm.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return rowCount;
	}
}

