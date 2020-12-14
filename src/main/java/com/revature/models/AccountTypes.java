package com.revature.models;

public class AccountTypes {
	private String id;
	private String accountType;
	
	
	public AccountTypes () {}

	public AccountTypes (String accountType) {
		
		super();
		this.accountType = accountType;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	

}
