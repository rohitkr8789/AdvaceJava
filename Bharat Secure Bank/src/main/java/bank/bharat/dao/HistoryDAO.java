package bank.bharat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bank.bharat.connection.ConnectionProvider;

public class HistoryDAO {

	public void inserTransaction() {
		String sql="insert into bank_transaction (SENDER_ACCOUNT,RECEIVER_ACCOUNT,AMOUNT,TXN_TYPE,DESCRIPTION,STATUS,TXN_DATE) values(?,?,?,?,?,?,SYSDATE)";
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
