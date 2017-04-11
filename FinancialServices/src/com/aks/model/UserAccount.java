package com.aks.model;

public class UserAccount {
	private String userName;
	private String password;
	private String companyName;
	private long phone;

	public UserAccount(String userName, String password, String companyName,
			long phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.companyName = companyName;
		this.phone = phone;
	}

	public UserAccount() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}