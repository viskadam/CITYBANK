package com.company.services;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import com.company.constants.Roles;

=======

import com.company.constants.Roles;
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
import com.company.model.Accounts;

import com.company.model.Customer;
import com.company.model.Kyc;

public interface CustService {
<<<<<<< HEAD
	void save(Customer cust,Roles role, Accounts acc,Kyc kyc);
=======
	void save(Customer cust,Roles role, Accounts acc);
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5

	public Customer findByUsername(String username);

	void deleteCust(long id);
<<<<<<< HEAD
	
	

	public List<Customer> getCust();
	
	public Iterable<Kyc> getKyc();
	
	void deleterec(Long ekyc);
	
	
=======

	public List<Customer> getCust();
	
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
	  public Customer findByEmail(String email);
	
	
	
}