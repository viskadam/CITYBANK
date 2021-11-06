package com.company.services;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

<<<<<<< HEAD
import javax.transaction.Transactional;

=======
<<<<<<< HEAD
import javax.transaction.Transactional;

=======
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.constants.Roles;
import com.company.model.Accounts;
import com.company.model.BankRole;
import com.company.model.Customer;
import com.company.model.Kyc;
import com.company.repository.CustRepository;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
import com.company.repository.KycRepository;
import com.company.repository.RoleRepository;
import com.company.repository.acctRepository;

@Service
public class CustServiceImpl implements CustService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private acctRepository acctrepo;

	@Autowired
	private KycRepository kycrepo;

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
	public void save(Customer cust, Roles role, Accounts acct, Kyc k) {
		cust.setPassword(bCryptPasswordEncoder.encode(cust.getPassword()));

		Set roles = new HashSet<BankRole>();

		roles.add(roleRepository.findByName("customer"));

		cust.setRoles(roles);

		acct.setAccountnumber("CITY2021" + (long) Math.random());
		acct.setBalance(5000);

		k.setEkyc((long) Math.random());
		k.setAccnum(acct.getAccountnumber());
		k.setDoc("Aadhar");

		acctrepo.save(acct);
		kycrepo.save(k);
		custRepository.save(cust);
	}

	@Override
	public List<Customer> getCust() {

		// List<Customer> customer = new ArrayList<Customer>();
		// customer.add((Customer) custRepository.findAll());

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

		return custRepository.findByEmail(email).get(0);
	}

	@Override
	public Iterable<Kyc> getKyc() {

		return kycrepo.getKyc();
	}

	@Override
	@Transactional
	public void deleterec(Long ekyc) {
		kycrepo.updateEkyc(ekyc);
	}
<<<<<<< HEAD
=======
=======
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

	


>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6

//		@Override
//		public Customer findByEmailIdIgnoreCase(String email) {
//			
//			return custRepository.findByEmailIdIgnoreCase(email);
//		}

<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======

	
	
		

	}

>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
