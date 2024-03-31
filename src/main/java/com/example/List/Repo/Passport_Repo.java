package com.example.List.Repo;

import com.example.List.Entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Passport_Repo extends JpaRepository<Passport, Integer> {

}
