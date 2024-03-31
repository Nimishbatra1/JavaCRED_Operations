package com.example.List.Repo;

import com.example.List.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person_Repo extends JpaRepository<Person, Integer> {

}
