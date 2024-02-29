package com.example.demo.controller;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmpModel;
import com.example.demo.model.LoginModel;
import com.example.demo.model.reset;
import com.example.demo.service.EmailService;
import com.example.demo.service.EmailServiceImpl;
import com.example.demo.service.EmpService;
import com.example.demo.service.EmpServiceImpl;

@RestController
@CrossOrigin
public class MainController {
	@Autowired
	EmpService empservice;
	@Autowired
	EmailService emailservice; 
	
	
	
	public EmailService getEmailservice() {
		return emailservice;
	}

	public void setEmailservice(EmailService emailservice) {
		this.emailservice = emailservice;
	}

	@GetMapping("hi")
	public String getHello() {
		return "Hello";
	}
	
	@PostMapping("saveemp")
	public String saveEmp(@RequestBody EmpModel emp)
	{
		empservice.addEmp(emp);
		return("success");
	}
	@GetMapping("getemps")
	public List<EmpModel> getAllEmps()
	{
		List<EmpModel> emp=empservice.getEmps();
		return emp;
	}
	@PutMapping("update")
	public void updateEmployee(@RequestBody EmpModel updatedEmployee) {
    empservice.updateEmp(updatedEmployee);
    
}
	@GetMapping("/edit/{id}")
	public EmpModel getempById(@PathVariable("id") int id) {
		EmpModel list =empservice.getEmpById(id);
		System.out.println(list);
		System.out.println(id);
		 return list;
	    }
			

	
	@GetMapping("delete/{id}")
	public String deleteEmpoyee(@PathVariable int id)
	{
		System.out.println(id);
		 empservice.deleteEmpById(id);
		return ("Deleted Successfully");
	}
	
	@PostMapping("login")
	public ResponseEntity<String> Login(@RequestBody LoginModel lm) {
		List<EmpModel> l=empservice.doLogin(lm);
		System.out.println(lm);
		System.out.println(lm.getEmail());
		System.out.println(lm.getPassword());
		
		if (l != null && !l.isEmpty()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid");
        }
		

	}
	
	@PostMapping("/forgotpass")
	public String forgotpass(@RequestParam String to) {
		
		Random rd = new Random();
		int otpp = rd.nextInt(999999) + 100000;
		String otp = String.valueOf(otpp);
		
		
		emailservice.sendOtpEmail(to, otp);
		
		return "Succesfully send otp gmail";
	}
	
	/*
	 * @PostMapping("/reset-password") public String resetPassword(@RequestBody
	 * reset rs ) { // Retrieve user by email and verify OTP // If OTP is valid,
	 * reset the password // Update the user's password (in-memory, database, etc.)
	 * 
	 * 
	 * 
	 * return "Password reset successfully."; }
	 */
}






