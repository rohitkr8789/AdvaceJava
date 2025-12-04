package bank.bharat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

import bank.bharat.bean.RegisterBean;
import bank.bharat.connection.ConnectionProvider;

public class TransferDAO {

	String sql1="update bank_users set balance=balance-? where username=?";
	String sql2="update bank_users set balance=balance+? where PHONE_NUMBER=?";
	
	public int balanceUpdate(String uname,String mobile,double amount) {
		int result1=0;
		int result2=0;
		try {
			Connection con = ConnectionProvider.getConnection();
			//check mobile is correct or not 
			PreparedStatement psm = con.prepareStatement("select * from bank_users where PHONE_NUMBER=?");
			psm.setString(1, mobile);
			ResultSet rrs = psm.executeQuery();
			
			if(!rrs.next()) {
				return 0;
			}
			
			con.setAutoCommit(false);
			PreparedStatement pstm = con.prepareStatement(sql1);
			pstm.setDouble(1, amount);
			pstm.setString(2, uname);
			
			 result1 = pstm.executeUpdate();
			 if(result1==0) {
				 con.rollback();
				 return 0;
			 }
			Savepoint sp = con.setSavepoint();
			
			PreparedStatement pstm2 = con.prepareStatement(sql2);
			pstm2.setDouble(1, amount);
			pstm2.setString(2, mobile);
			 result2 = pstm2.executeUpdate();
			 if(result2==0) {
				 con.rollback(sp);
				 return 0;
			 }
			 
			 con.commit();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return (result1>0 && result2>0)?1:0;
	}
	
	public RegisterBean viewData(String mobile) {
		RegisterBean rb = null;
		
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from bank_users where PHONE_NUMBER=?");
			pstm.setString(1, mobile);
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
