package com.login;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\tWelcome to our hostel");
		System.out.println("\t1. Registation\t3.Admin\n\t2. Login");
		System.out.println("What you want Registation or Login or Admin potal");
		int ch = Integer.parseInt(sc.nextLine());
		
		switch(ch) {
		case 1 ->{
			RegistationPage.reg();
		}
		case 2 ->{
			LoginPage lp = new LoginPage();
			lp.logIn();
		}
		case 3 ->{
			Admin.admin();
		}
		}
		
		

	}

}
