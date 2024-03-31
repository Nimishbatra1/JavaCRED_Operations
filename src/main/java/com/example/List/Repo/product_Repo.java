package com.example.List.Repo;

import com.example.List.Entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface product_Repo extends JpaRepository<product, Integer>{

}
