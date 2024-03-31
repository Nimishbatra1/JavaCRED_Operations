package com.example.List.Entity;

import com.example.List.Entity.Passport;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String age;
	String address;

	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JoinColumn(name = "passport_id")
	private Passport passport;
	
	
	
	public Person(){
		super();
	}
	
	
	public Person(int id, String name, String age, String address, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.passport = passport;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	}
	
	

