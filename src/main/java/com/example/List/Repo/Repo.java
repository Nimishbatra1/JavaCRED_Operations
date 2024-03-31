package com.example.List.Repo;
import com.example.List.Entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Response,Integer> {

	Boolean existsByEmail(String email);

	Boolean existsByPassword(String password);

	Response getByUsername(String username);

}
