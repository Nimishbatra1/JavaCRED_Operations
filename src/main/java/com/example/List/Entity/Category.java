package com.example.List.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	private int C_id;
	private String C_name;
	
	@ManyToMany(mappedBy = "categorylist")
	private List<product>productlist=new ArrayList<>();

	
	
	public Category() {
		super();
	}

	public Category(int c_id, String c_name, List<product> productlist) {
		super();
		C_id = c_id;
		C_name = c_name;
		this.productlist = productlist;
	}

	
	
	public int getC_id() {
		return C_id;
	}

	public void setC_id(int c_id) {
		C_id = c_id;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public List<product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<product> productlist) {
		this.productlist = productlist;
	}	
	
	
	
}
