package com.example.List.Repo;

import com.example.List.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface category_Repo extends JpaRepository<Category, Integer>{

}
