package com.example.List.Service;
import java.util.List;
import java.util.Optional;

import com.example.List.Entity.*;

import jakarta.transaction.Transactional;
public interface FormService {

	public void save(Response r);
	
//	public ModelAndView checkDetails(String email,String Password);
	public Boolean checkDetails(String email,String Password);
	

	public List<Response> showRecord();

	public void addItem(Response r);

	public void update(Response r);

	public Optional<Response> getDataById(int id);

	public void delete(int id);
	
	public Response loadUserByUsername(String username);

	public Person addPerson(Person p);

	public Passport addPassport(Passport pass);

	@Transactional
	public Account saveAccount(Account account);

	@Transactional
	public Customer saveCustomer(Customer customer);

	public void saveProduct(product p);

	public void saveCategory(Category c);
}
