package com.company.services;

import java.util.List;

import com.company.constants.Roles;
import com.company.model.Accounts;

import com.company.model.Customer;

public interface CustService {
	void save(Customer cust,Roles role,Accounts acct);

	Customer findByUsername(String username);
	
	//Accounts findAccountNum(String acct); 
	
	void deleteCust(long id);

	List<Customer> getCust();
	

	
}