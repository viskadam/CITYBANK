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


@Service
public class CustDetails implements UserDetailsService {
	@Autowired
	private CustRepository custRepository;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		Customer user = custRepository.findByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (BankRole bankRole : user.getBankRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(bankRole.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}
}