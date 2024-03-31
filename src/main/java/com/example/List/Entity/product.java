package com.example.List.Entity;

import java.util.ArrayList;
import java.util.List;

import com.example.List.Entity.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class product {

	@Id
	private int P_id;
	private String P_name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Category>categorylist=new ArrayList<>();

	public product() {
		super();
	}

	public product(int p_id, String p_name, List<Category> categorylist) {
		super();
		P_id = p_id;
		P_name = p_name;
		this.categorylist = categorylist;
	}

	
	
	public int getP_id() {
		return P_id;
	}

	public void setP_id(int p_id) {
		P_id = p_id;
	}

	public String getP_name() {
		return P_name;
	}

	public void setP_name(String p_name) {
		P_name = p_name;
	}

	public List<Category> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List<Category> categorylist) {
		this.categorylist = categorylist;
	}
	
	
	
	
	
}
