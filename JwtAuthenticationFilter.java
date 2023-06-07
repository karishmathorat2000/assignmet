package com.example.demo.configure;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.helper.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired	
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@Autowired
	private JwtUtil util;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

String requestTokenHAndler=request.getHeader("Authorization");
String username=null;
String jwtToken=null;
if(requestTokenHAndler!=null && requestTokenHAndler.startsWith("Bearer ")) {
	jwtToken=requestTokenHAndler.substring(7);
	
	try {
		username=this.util.extractUsername(jwtToken);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
	
	
	
	
	UserDetails details =this.detailsServiceImpl.loadUserByUsername(username);
	
	//security
	
	if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
	{
		UsernamePasswordAuthenticationToken authenticationToken	=new UsernamePasswordAuthenticationToken(details, null,details.getAuthorities());
	
	authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	
	SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	}else {
		System.out.println("Token is not validet");
	}
	
	
	
	
	
	
	
}
filterChain.doFilter(request, response);
	}

}
