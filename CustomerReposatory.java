package com.example.demo.Reposatory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Customer;


public interface CustomerReposatory  extends CrudRepository<Customer,Integer> {
	@Query("select u from Customer u where u.Email =:Email")
	public Customer getUserByUserName(@Param("Email")String some);
}
