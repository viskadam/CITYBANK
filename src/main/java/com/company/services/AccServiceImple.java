package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Accounts;
import com.company.repository.acctRepository;

@Service
public class AccServiceImple implements AccService {

	@Autowired
	private acctRepository acctrepo;
	
	@Override
	public List<Accounts> getAcc() {
		// TODO Auto-generated method stub
		return acctrepo.findAll();
	}

}
