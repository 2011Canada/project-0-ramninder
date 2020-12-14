package com.revature.models;

public class BankAccounts {

	private String id;
	 private double balance;
	 private int accountTypeId;
	 private String accountOwner;
	 
	 public BankAccounts() {
		 
	 }
	 
	 
	 public BankAccounts(int accountTypesId, String accountOwner, double balance ) {
		 
		 super();
		 this.accountTypeId = accountTypesId;
		 this.balance = balance;
		 this.accountOwner = accountOwner;
	 }
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	 
	
}
