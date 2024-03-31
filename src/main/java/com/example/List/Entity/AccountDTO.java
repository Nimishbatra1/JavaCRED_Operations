package com.example.List.Entity;

import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
	private int id;
	private long mobileNo;
	private String name;
	private String address;
	private  String email;
	private List<Account>account=new ArrayList<>();
	
	
	public AccountDTO() {
		super();
	}
	
	
	

	public AccountDTO(int id, long mobileNo, String name, String address, String email, List<Account> account) {
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
