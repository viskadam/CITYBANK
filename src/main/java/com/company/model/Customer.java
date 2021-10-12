package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@NamedQuery(name="Customer.findAll", query="SELECT m FROM Customer m")
public class Customer implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name="id")
private Long id;
@Column(name = "name",length=25)
private String name;
@Column(name = "mobile",length=25)
private String mobile;
@Column(name = "email",length=25)
private String email;
@Column(name = "address",length=25)
private String address;
@Column(name = "username",length=25)
private String username;

@Column(name = "password",length=25)
private String password;

@OneToMany
private Set<BankRole> bankRoles;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
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

public Set<BankRole> getBankRoles() {
	return bankRoles;
}

public void setBankRoles(Set<BankRole> bankRoles) {
	this.bankRoles = bankRoles;
}



}
