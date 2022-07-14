package com.rentbooks.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedUser {
	
	public String retriveLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();
		
		return principal.toString();
	}
}
