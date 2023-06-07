package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Reposatory.CustomerReposatory;
import com.example.demo.configure.customerdeatails;
import com.example.demo.helper.JwtUtil;
import com.example.demo.model.Customer;
import com.example.demo.model.jwtresponse;

@RestController
public class JwtController {
	
	@Autowired
	private CustomerReposatory customerReposatory;

	@Autowired
	private UserDetailsService customerdeatails;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping( value = "/token",method =  RequestMethod.POST)
	public ResponseEntity<?>generateToken(@RequestBody Customer customer){
		
		System.out.println(customer.getEmail()+" "+customer.getPassword());
		
		try {
			this.customerReposatory.getUserByUserName(customer.getEmail());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		UserDetails details =this.customerdeatails.loadUserByUsername(customer.getEmail());
		System.out.println("userdeyaos"+ details);
	String tokan=this.jwtUtil.generateToken(details);
	
	System.out.println(tokan);
		return ResponseEntity.ok(new jwtresponse(tokan));
	}
}
