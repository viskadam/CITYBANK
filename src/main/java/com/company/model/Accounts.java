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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")

public class Accounts implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long aid;
@Column(length=25)
private String accountnumber;
@Column(name="balance",precision=(2))
private double balance;

public Accounts() {
}

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="Acc_id",referencedColumnName="aid")
private Set<Customer> customer;

public Long getAid() {
	return aid;
}

public void setAid(Long aid) {
	this.aid = aid;
}

public String getAccountnumber() {
	return accountnumber;
}

public void setAccountnumber(String accountnumber) {
	this.accountnumber = accountnumber;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public Set<Customer> getCustomer() {
	return customer;
}

public void setCustomer(Set<Customer> customer) {
	this.customer = customer;
}




}