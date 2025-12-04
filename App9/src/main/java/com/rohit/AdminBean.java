package com.rohit;

import java.io.Serializable;

public class AdminBean implements Serializable{

	private String u_name, u_pwd, u_fname,u_lname,u_addr,u_mid,u_phno;
	
	public AdminBean() {}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_fname() {
		return u_fname;
	}

	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}

	public String getU_lname() {
		return u_lname;
	}

	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}

	public String getU_addr() {
		return u_addr;
	}

	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}

	public String getU_mid() {
		return u_mid;
	}

	public void setU_mid(String u_mid) {
		this.u_mid = u_mid;
	}

	public String getU_phno() {
		return u_phno;
	}

	public void setU_phno(String u_phno) {
		this.u_phno = u_phno;
	}
	
	
}
