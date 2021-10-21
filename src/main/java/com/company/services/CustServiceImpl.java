package com.company.services;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.constants.Roles;
import com.company.model.Accounts;
import com.company.model.BankRole;
import com.company.model.Customer;
import com.company.model.Kyc;
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
		
		
		
	    
		
		public CustServiceImpl(CustRepository custRepository) {
			super();
			this.custRepository = custRepository;
		}

		

		@Override
		public void save(Customer cust,Roles role,Accounts acct) {
			cust.setPassword(bCryptPasswordEncoder.encode(cust.getPassword()));
			
			Set roles = new HashSet<BankRole>();

			roles.add(roleRepository.findByName("customer"));
			
			Kyc k = new Kyc();
			cust.setRoles(roles);
					
			acct.setAccountnumber("CITY2021"+ (long)Math.random());
			acct.setBalance(5000);
			
			acctrepo.save(acct);
			custRepository.save(cust);
		}

		@Override
		public List<Customer> getCust() {
			
			//List<Customer> customer = new ArrayList<Customer>();
			//customer.add((Customer) custRepository.findAll());
			
			
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



		@Override
		public Customer findByEmail(String email) {
		
			return custRepository.findByEmail(email);
		}

	



//		@Override
//		public Customer findByEmailIdIgnoreCase(String email) {
//			
//			return custRepository.findByEmailIdIgnoreCase(email);
//		}


	
	
		

	}

