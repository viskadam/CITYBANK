package com.company.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	 @Column(name = "mobile")
	private String mobile;
	 
	 @Column(name = "email")
	private String email;
	 
	 @Column(name = "address")
	private String address;
	
	
	 
	 @Column(name = "username")
	private String username;

	 @Column(name = "password")
	private String password;
	
	 @OneToMany
		private Set<BankRole> bankRoles;

	 @OneToMany(mappedBy = "aid" ,cascade = CascadeType.ALL)

		private Set<Accounts> acct;
	
	

//	@Column(name="document", length = 64)
//	    private String photos;
		
	

	public String getName() {
		return name;
	}

	public Set<Accounts> getAcct() {
		return acct;
	}

	public void setAcct(Set<Accounts> acct) {
		this.acct = acct;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Set<BankRole> getRoles() {
		return bankRoles;
	}

	public void setRoles(Set<BankRole> bankRoles) {
		this.bankRoles = bankRoles;
	}


}