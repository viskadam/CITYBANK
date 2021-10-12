package com.company.services;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.constants.Roles;
import com.company.model.Accounts;

import com.company.model.BankRole;
import com.company.model.Customer;
import com.company.repository.CustRepository;
import com.company.repository.RoleRepository;
import com.company.repository.acctRepository;

@Service
	public class CustServiceImpl implements CustService {
		
	
	@Autowired
	private RoleRepository roleRepository;
	 
	@Autowired
	private acctRepository acctrepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
		@Autowired
		private CustRepository custRepository;
		
		@Autowired
	    private CustDetails custdetail;
		
		@Autowired
		private acctRepository acctRepo;

	    
		
		@Override
		public void save(Customer cust,Roles role,Accounts acct) {
			cust.setPassword(bCryptPasswordEncoder.encode(cust.getPassword()));

			Set roles = new HashSet<BankRole>();
			roles.add(roleRepository.findByName(role.toString()));

			cust.setBankRoles(roles);
			acct.setAccountnumber("12345"+ (long)Math.random()*2000000);
			acct.setBalance(5000);
			acctrepo.save(acct);
			custRepository.save(cust);
		}

		@Override
		public List<Customer> getCust() {
			return custRepository.findAll();
		}
		
		

		@Override
		public void deleteCust(long id) {
			Optional<Customer> cust = custRepository.findById(id);
			if (cust.isPresent()) {
				custRepository.delete(cust.get());
				
			}
		}
		
		

		@Override
		public Customer findByUsername(String username) {
			
			return custRepository.findByUsername(username);
		}

//		@Override
//		public Accounts findAccountNum(String acct) {
//			
//			return acctRepo.findAccountNum(acct);
//		}


		

		

	}

