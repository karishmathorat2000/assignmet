package com.example.demo.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Reposatory.CustomerReposatory;
import com.example.demo.model.Customer;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private CustomerReposatory reposatory;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Customer user=reposatory.getUserByUserName(username);
		System.out.println(user);
		if(user==null)
		{
			throw new UsernameNotFoundException("could not found user!!");
		}
		
		customerdeatails cus=new customerdeatails(user);
		return cus;
	}

}
