package com.example.List.Repo;

import com.example.List.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Account_Repo extends JpaRepository<Account, Integer >{

}
