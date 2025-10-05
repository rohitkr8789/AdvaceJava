package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectClass {
	public static Connection conn =null;
	static void connect() {
		final String driver="oracle.jdbc.OracleDriver";
		final String URL ="jdbc:oracle:thin:@localhost:1521:ORCL";
		final String userName="db9am";
		final String password ="db9am";
		
		try {
			Class.forName(driver);
			if(conn==null) {
			conn=DriverManager.getConnection(URL, userName, password);
			}
		//	System.out.println("Connect to DataBase");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
