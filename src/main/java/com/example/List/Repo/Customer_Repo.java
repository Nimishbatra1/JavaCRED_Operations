package com.example.List.Repo;

import com.example.List.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_Repo extends JpaRepository<Customer, Integer>{

	
}
