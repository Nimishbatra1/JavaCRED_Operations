package com.example.List.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.List.Entity.*;
import com.example.List.Service.ExcelExport;
import com.example.List.Service.FormService;
import com.example.List.Service.PdfExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SimpleController {

	@Autowired
	FormService formservice;

	@RequestMapping("/")
	public String listUser() {

		return "list1";

	}

	@GetMapping("/form")
	public String showForm() {

		return "LoginForm";

	}

	@RequestMapping("/saveDetails") // it only support post method
	public String saveDetails(HttpServletRequest request, ModelMap m) {
// write your code to save details
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		Response r = new Response();
		r.setUsername(username);
		r.setPassword(password);
		r.setEmail(email);
		formservice.save(r);


		m.addAttribute("showRecord", formservice.showRecord());

		return "records";
	}

	@PostMapping("/checkLogin")
	public String checkLogin(HttpServletRequest request, ModelMap m) {
		String Password = request.getParameter("pass");
		String email = request.getParameter("email");

		Boolean msg = formservice.checkDetails(email, Password);
		if (msg) {
			m.addAttribute("showRecord", formservice.showRecord());
			
			return "records";
			
		} else {

			return "LoginForm";
		}
	}

	@RequestMapping("/add")
	public String addItem() {

		return "addItem";
	}

	@RequestMapping("/update")
	public String showItem(@Param(value = "id") int id, ModelMap m) {
		Optional<Response> response= formservice.getDataById(id);
		m.addAttribute("username",response.get().getUsername());
		m.addAttribute("password",response.get().getPassword());
		m.addAttribute("email", response.get().getEmail());
		m.addAttribute("id", response.get().getId());
		return "updateItem";
	}

	@RequestMapping("/Update")
	public String update(HttpServletRequest request, ModelMap m) {
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));
		Response r = new Response();
		r.setUsername(username);
		r.setPassword(password);
		r.setEmail(email);
		r.setId(id);
		formservice.update(r);
		m.addAttribute("showRecord", formservice.showRecord());
		return "records";
	}

	@RequestMapping("/delete")
	public String delete(@Param(value = "id") int id, ModelMap m) {
		
		formservice.delete(id);
		m.addAttribute("showRecord", formservice.showRecord());
		return "records";
	}
	
	
	@GetMapping("/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=user_Responses.pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Response> listUsers = formservice.showRecord();
         
        PdfExport exporter = new PdfExport(listUsers);
        exporter.export(response);
         
    }
	 @GetMapping("/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_Response.xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Response> listUsers = formservice.showRecord();
	         
	        ExcelExport exporter = new ExcelExport(listUsers);
	         
	        exporter.export(response);    
	    }  
	  
	 
	//======||   ONE-TO-ONE  ||================== 
	 @PostMapping("/table")
	 public ResponseEntity<Person> addPerson(@RequestBody PersonDTO p) {
		 Passport passport = new Passport();
//		 passport.setPerson(p);
	        Person person = new Person();
	        person.setAddress(p.getAddress());
	        person.setAge(p.getAge());
	        person.setName(p.getName());
	        
	        passport.setPassport_name(p.getPassport_name());
	        person.setPassport(passport);
	        passport.setPerson(person);
	        formservice.addPassport(passport);
//	        p.setPassport(savedPassport);

	        Person savedPerson = formservice.addPerson(person);
	        return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);


	    }
		
	 
	//======||   ONE-TO-MANY  ||==================

	
	 @PostMapping("/onetomany")
		 public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		        Customer savedCustomer = formservice.saveCustomer(customer);

		        for (Account account : customer.getAccount()) {
		            account.setCustomer(savedCustomer);
		            account.setAccountNo(account.getAccountNo());
		            account.setAccountHolderName(account.getAccountHolderName());
		            account.setId(account.getId());
		            
		            formservice.saveAccount(account);
		        }

		        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
		    }
				



//		 public void save(){
//		 Account acc1=new Account();
//		 acc1.setAccountHolderName("NIMISH");
//		 acc1.setAccountNo("A121X");
//		 acc1.setId(1);
//
//
//
//		 Account acc2 = new Account();
//		 acc2.setAccountHolderName("NIMISH");
//		 acc2.setAccountNo("A221X");
//		 acc2.setId(2);
//
//
//		 List<Account>acclist=new ArrayList<>();
//		 acclist.add(acc2);
//		 acclist.add(acc1);
//
//		 Customer c = new Customer();
//		 c.setName("NIMISH");
//		 c.setAddress("SONIPAT");
//		 c.setEmail("abc@123");
//		 c.setId(1);
//		 c.setMobileNo(912343);
//		 c.setAccount(acclist);
//
//		 acc1.setCustomer(c);
//		 acc2.setCustomer(c);
//		 
//		 formservice.saveCustomer(c);
//		 formservice.saveAccount(acc1);
//		 formservice.saveAccount(acc2);

		 
		 	 
//	 }
	
	 
	//======||   MANY-TO-MANY ||==================
@PostMapping("/manytomany")
	 public void save(){
	
	product p1=new product();
	p1.setP_id(1);
	p1.setP_name("IPhone 15");
	
	
	product p2=new product();
	p2.setP_id(2);
	p2.setP_name("Samsung S22 ultra");
	
	
	product p3=new product();
	p3.setP_id(3);
	p3.setP_name("Samsung TV");
	
	
	Category c1= new Category();
	c1.setC_id(1);
	c1.setC_name("SmartPhones");
	
	Category c2= new Category();
	c2.setC_id(2);
	c2.setC_name("Electronics");
	
	List<Category>categoryList=p1.getCategorylist();
	categoryList.add(c2);
	categoryList.add(c1);
	p1.setCategorylist(categoryList);
	
	
	List<Category>categoryList2=p2.getCategorylist();
	categoryList2.add(c2);
	categoryList2.add(c1);
	p2.setCategorylist(categoryList2);
	
	
	List<Category>categoryList3=p3.getCategorylist();
	categoryList3.add(c2);
	p3.setCategorylist(categoryList3);
	
	formservice.saveCategory(c1);
	formservice.saveCategory(c2);
	
	
	formservice.saveProduct(p1);
	formservice.saveProduct(p3);
	formservice.saveProduct(p2);
	}
	 
	 
	 
@RequestMapping("/return")
public String Back() {

	return "records";
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
