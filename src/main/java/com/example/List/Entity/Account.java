package com.example.List.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String AccountHolderName;
private String AccountNo;

@ManyToOne()
@JoinColumn(name="customer_id")
private Customer customer;





public Account() {
	super();
}

public Account(int id, String accountHolderName, String accountNo, Customer customer) {
	super();
	this.id = id;
	AccountHolderName = accountHolderName;
	AccountNo = accountNo;
	this.customer = customer;
}




public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAccountHolderName() {
	return AccountHolderName;
}

public void setAccountHolderName(String accountHolderName) {
	AccountHolderName = accountHolderName;
}

public String getAccountNo() {
	return AccountNo;
}

public void setAccountNo(String accountNo) {
	AccountNo = accountNo;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}













}


