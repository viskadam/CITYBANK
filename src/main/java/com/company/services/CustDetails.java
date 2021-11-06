package com.company.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.Accounts;
import com.company.model.BankRole;
import com.company.model.Customer;
import com.company.repository.CustRepository;
import com.company.repository.acctRepository;
//import com.company.repository.acctRepository;


@Service
public class CustDetails implements UserDetailsService {
	@Autowired
	private CustRepository custRepository;
	
	@Autowired
	private acctRepository acctRepo;
	
	@Override 
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		Customer user = custRepository.findByUsername(username);
		
		//Accounts acc = acctRepo.findAccountNum(accountnumber);
		if (user == null)
			throw new UsernameNotFoundException(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (BankRole bankRole : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(bankRole.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

	public UserDetails loadUserByEmail(String email) {
		 try {
<<<<<<< HEAD
		        Customer user = custRepository.findByEmail(email).get(0);
=======
<<<<<<< HEAD
		        Customer user = custRepository.findByEmail(email).get(0);
=======
		        Customer user = custRepository.findByEmail(email);
>>>>>>> cf52a57e93549a2e140afce91d59cb9506a98ad5
>>>>>>> bf5f6ebd60eb9d505fc319bede77963f8ec568f6
		        if (user == null) {
		            throw new UsernameNotFoundException(
		              "No user found with username: " + email);
		        }
		        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
				for (BankRole bankRole : user.getRoles()) {
					grantedAuthorities.add(new SimpleGrantedAuthority(bankRole.getName()));
				}
		        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
		        		grantedAuthorities);
		         
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
	}
	
	
//	public UserDetails loadUserByEmailIdIgnoreCase(String email) {
//		
//		Customer user = custRepository.findByUsername(email);
//		if (user == null)
//			throw new UsernameNotFoundException(email);
//
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		for (BankRole bankRole : user.getRoles()) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(bankRole.getName()));
//		}
//
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getEmail(),
//				grantedAuthorities);
//		
//		
//	}

	
}