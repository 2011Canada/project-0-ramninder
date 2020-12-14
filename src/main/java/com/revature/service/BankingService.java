package com.revature.service;

import java.util.List;

import com.revature.models.BankAccounts;
import com.revature.repositories.BankAccountDAO;
import com.revature.repositories.BankAccountsDAOImpl;

public class BankingService {
	
	
	static BankAccountDAO bankAcc = new BankAccountsDAOImpl();
	
	
	public List<BankAccounts> findAllBankAcc() {
		
		return bankAcc.findAll();
		
	}
	

	
public BankAccounts saveBankAcc(BankAccounts obj) {
		
		return bankAcc.save(obj);
		
	}
	public BankAccounts findBankAcc(String id) {
		return bankAcc.findById(id);
	}
	
	public BankAccounts updateBankAcc(BankAccounts obj) {

		return bankAcc.update(obj);
		
	}

}
