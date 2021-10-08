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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "accounts")
public class Accounts implements Serializable {
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aid;
	@Column(length=25)
	private String accountnumber;
	@Column(name="balance",precision=(2))
	private double balance;
	
	@ManyToOne
	private Customer cust;

	public Accounts() {
		 
	}
	
	
	
	
	
	
	public Customer getCust() {
		return cust;
	}






	public void setCust(Customer cust) {
		this.cust = cust;
	}






	public String getAccountnumber() {
		return this.accountnumber ;
	}
	@Column(length=25)
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Long getAid() {
		return this.aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public double getBalance() {
		return this.balance;
	}
	@Column(length=25)
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	
}