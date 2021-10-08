package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.BankRole;

public interface RoleRepository extends JpaRepository<BankRole, Long>{
	public BankRole findByName(String name);
}
