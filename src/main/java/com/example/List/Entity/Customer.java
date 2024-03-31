package com.example.List.Entity;

import java.util.ArrayList;
import java.util.List;

import com.example.List.Entity.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long mobileNo;
	private String name;
	private String address;
	private  String email;
	
	@OneToMany(mappedBy ="customer" ,cascade = CascadeType.ALL)
	private List<Account>account=new ArrayList<>();
	
	
	
	public Customer() {
		super();
	}

	public Customer(int id, long mobileNo, String name, String address, String email, List<Account> account) {
		super();
		this.id = id;
		this.mobileNo = mobileNo;
		this.name = name;
		this.address = address;
		this.email = email;
		this.account = account;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	
	
	
	
	
}
