package com.example.demo.model;

public class jwtresponse {
	String token;
	
	public jwtresponse() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public jwtresponse(String token) {
		super();
		this.token = token;
	}

	@Override
	public String toString() {
		return "jwtresponse [token=" + token + "]";
	}
	

}
