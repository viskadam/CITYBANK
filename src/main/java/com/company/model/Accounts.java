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
@NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
public class Accounts implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	@Column(length = 25)
	private String accountnumber;
	@Column(name = "balance", precision = (2))
	private double balance;

	@Column(length = 25,name="KYC_FLAG")
	private String kycFlag = "PEND";

	public Accounts() {

	}

	
	public String getKycFlag() {
		return kycFlag;
	}

	public void setKycFlag(String kycFlag) {
		this.kycFlag = kycFlag;
	}

	

	public String getAccountnumber() {
		return this.accountnumber;
	}

	@Column(length = 25)
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber + (long) (Math.round(Math.random() * 25000));
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

	@Column(length = 25)
	public void setBalance(double balance) {
		this.balance = balance;
	}

}