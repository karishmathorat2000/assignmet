package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	private String Email;
	private  String password;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(int id, String email, String password) {
		super();
		this.id = id;
		this.Email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", Email=" + Email + ", password=" + password + "]";
	}
	




	
}
