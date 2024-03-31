package com.example.List.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Passport_Id;
	String Passport_name;
	 @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
	private Person person;
	
	
	public int getPassport_Id() {
		return Passport_Id;
	}
	public void setPassport_Id(int passport_Id) {
		Passport_Id = passport_Id;
	}

	
	
	public Passport(int Passport_id, String passport_name, Person person) {
		super();
		this.Passport_name = passport_name;
		this.Passport_Id=Passport_id;
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getPassport_name() {
		return Passport_name;
	}
	public void setPassport_name(String passport_name) {
		Passport_name = passport_name;
	}

	
	
}
