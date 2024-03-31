package com.example.List.Entity;

public class PersonDTO {

	int id;
	String name;
	String age;
	String address;
	String passport_name;
	public PersonDTO(int id, String name, String age, String address, String passport_name) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.passport_name = passport_name;
	}
	public PersonDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassport_name() {
		return passport_name;
	}
	public void setPassport_name(String passport_name) {
		this.passport_name = passport_name;
	}
	
	
}
