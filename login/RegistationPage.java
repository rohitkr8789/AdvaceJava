package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RegistationPage {
		static void reg() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Id :");
			int id = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Name :");
			String name=sc.nextLine();
			
			System.out.println("Enter age :");
			int age = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Gender :");
			String gender=sc.nextLine();
			
			System.out.println("Enter Phone No :");
			long phoneNo =Long.parseLong(sc.nextLine());
			
			System.out.println("Enter User Name :");
			String uName=sc.nextLine();
			
			System.out.println("Enter Password :");
			String pass=sc.nextLine();
			
			try {
				ConnectClass.connect();
				Connection con =ConnectClass.conn;
				PreparedStatement pstmt= con.prepareStatement("insert into hostel values(?,?,?,?,?,?,?)");
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, gender);
				pstmt.setLong(5, phoneNo);
				pstmt.setString(6, uName);
				pstmt.setString(7, pass);
				
				int rowCount = pstmt.executeUpdate();
				
				if(rowCount>0) {
				System.out.println("Set Successfully");
				}
				else {
					System.err.println("Data Not set");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
}
