package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Reposatory.CustomerReposatory;
import com.example.demo.model.Customer;

@RestController

public class HomeBeanController {
	
	@Autowired
	private CustomerReposatory reposatory;
	
	
	
	
	@RequestMapping ("/done")
	public String test()
	{
		return "done";
	}
	
	@RequestMapping(path = "/save",method = RequestMethod.POST)
	public String saveCustomer(@RequestBody Customer customer)
	{
		reposatory.save(customer);
		return "successfully Register";
		
	}

}
