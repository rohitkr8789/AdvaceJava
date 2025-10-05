package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin {
	public static void admin() {
		Scanner sc = new Scanner(System.in);
			
			System.out.println("\tWelcome to Admin potal");
			System.out.println("1.Select all Student details\n2.Select specific Student details");
			System.out.println("3.Update Student details\n4.Delete specific Student details");
			System.out.print("Enter Choice (1/2/3/4) :");
			int choice= Integer.parseInt(sc.nextLine());
			try {
				ConnectClass.connect();
				Connection con=ConnectClass.conn;
				PreparedStatement ptst= null;
				ResultSet rs=null;
				switch(choice) {
				case 1 ->{
					System.out.println("\n\t All Student details...");
					ptst=con.prepareStatement("select * from hostel order by id");
				}
				case 2 ->{
					System.out.print("Enter Student id: ");
					int id= Integer.parseInt(sc.nextLine());
					ptst=con.prepareStatement("select * from hostel where id=?");
					ptst.setInt(1, id);
				}
				case 3 ->{
					System.out.print("Enter Update Columns Name: ");
					String columns=sc.nextLine();
					System.out.print("Enter Update Data: ");
					String data=sc.nextLine();
					System.out.println("Enter update Student id: ");
					int id= Integer.parseInt(sc.nextLine());
					
					ptst=con.prepareStatement("update hostel set "+columns+" = ? where id = ? ");
					ptst.setString(1, data);
					ptst.setInt(2, id);
				}
				case 4 ->{
					System.out.println("Enter delete Student id: ");
					int id= Integer.parseInt(sc.nextLine());
					ptst=con.prepareStatement("delete from hostel where id = ?");
					ptst.setInt(1, id);
				}
				}
				if(choice == 1 || choice == 2) {
			     rs=ptst.executeQuery();
			     while(rs.next()) {
						System.out.println(rs.getNString(1)+" "+rs.getNString(2)+" "+rs.getNString(3)+" "+rs.getNString(4)+" "+rs.getNString(5));
					}
				}
				else if(choice == 3 || choice == 4){
					int rowCount = ptst.executeUpdate();
					if(rowCount>0 && choice ==3) {
						System.out.println("Updated Successfully..");
					}
					else if(rowCount>0 && choice ==4) {
						System.out.println("Delete Successfully..");
					}
					else {
						System.err.println("Error");
					}
				}	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
