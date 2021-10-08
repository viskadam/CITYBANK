package com.company.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kyc")
public class Kyc implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String ekyc;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aid", referencedColumnName="aid")
	private Accounts acct;
	
	@Column(name="doc", length = 64)
	private String doc;

}
