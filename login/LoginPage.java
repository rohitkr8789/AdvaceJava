package com.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginPage {
	void logIn() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter User id :");
		String id= sc.nextLine();
		
		System.out.print("Enter User password :");
		String password= sc.nextLine();
		
		try {
			ConnectClass.connect();
			Connection con=ConnectClass.conn;
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery("select * from hostel where username='"+id+"' or password='"+password+"'");
			if(set.next()) {
				if(id.equals(set.getNString(6))) {
					if(password.equals(set.getNString(7))) {
						System.out.println("Welcome Back "+set.getNString(2));
						System.out.println(set.getNString(1)+" "+set.getNString(2)+" "+set.getNString(3)+" "+set.getNString(4)+" "+set.getNString(5));	
					}
					else {
						System.err.println("Invalid Password");
					}
				}else {
					System.err.println("Invalid User Name");
				}
			}
			else System.err.println("Invalid username or password");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
