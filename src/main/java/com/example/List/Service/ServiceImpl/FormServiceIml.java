package com.example.List.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import com.example.List.Entity.*;
import com.example.List.Repo.*;
import com.example.List.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FormServiceIml implements FormService {

	@Autowired
	Repo repo;
	
	@Autowired
	Person_Repo personrepo;
	
	@Autowired
	Passport_Repo passrepo;
	
	@Autowired
	Customer_Repo crepo;
	
	@Autowired
	Account_Repo arepo;
	
	@Autowired
	category_Repo catrepo;
	
	@Autowired
	product_Repo prepo;

	@Override
	public void save(Response r) {
		// TODO Auto-generated method stub
		repo.save(r);
	}

//	@Override
//	public ModelAndView checkDetails(String email, String Password) {
//		String message;
//		if(repo.existsByEmail(email)&& repo.existsByPassword(Password)){
//			ModelAndView modelAndView = new ModelAndView("records");
//            modelAndView.addObject("message", "Login successful!");
//            message="true";
//            return modelAndView;
//			
//		}
//		else {
//			 ModelAndView modelAndView = new ModelAndView("LoginForm");
//	            modelAndView.addObject("message", "Invalid credentials. Please try again.");
//	            message="false";
//	            return modelAndView;
//		}
//	}
	
	
	
	@Override
	public Boolean checkDetails(String email, String Password) {
		Boolean b=repo.existsByEmail(email)&& repo.existsByPassword(Password);
		if(b==true){
			ModelAndView modelAndView = new ModelAndView("records");
            modelAndView.addObject("message", "Login successful!");
          
           return b;
			
		}
		else {
			 ModelAndView modelAndView = new ModelAndView("LoginForm");
	            modelAndView.addObject("message", "Invalid credentials. Please try again.");
	           b=false;
	            return b;
		}
	}

	@Override
	public List<Response> showRecord() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
		
		
	}

	@Override
	public void addItem(Response r) {
		// TODO Auto-generated method stub
		repo.save(r);
		
	}

	@Override
	public void update(Response r) {
	int id=r.getId();
	if(repo.existsById(id)) {
			repo.save(r);
		}
		
	}

	@Override
	public Optional<Response> getDataById(int id) {
		// TODO Auto-generated method stub
		
		return repo.findById(id);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Person addPerson(Person p) {
		// TODO Auto-generated method stub
		 return personrepo.save(p);
	}

	@Override
	public Passport addPassport(Passport pass) {
		// TODO Auto-generated method stub
		return passrepo.save(pass);
	}

	@Override
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		return arepo.save(account);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return crepo.save(customer);
	}

	@Override
	public void saveProduct(product p) {
		// TODO Auto-generated method stub
		prepo.save(p);
	}

	@Override
	public void saveCategory(Category c) {
		// TODO Auto-generated method stub
		catrepo.save(c);
	}

	@Override
	public Response loadUserByUsername(String username) {
		
		return repo.getByUsername(username);
		
	}
	
	
	
	
}
