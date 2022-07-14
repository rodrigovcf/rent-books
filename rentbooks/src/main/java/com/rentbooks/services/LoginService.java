package com.rentbooks.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rentbooks.model.Renter;


@Service
public class LoginService implements UserDetailsService{

	@Autowired
	private RenterService service;
	
//	public Renter retrieveRenter(String userName) {
//		
//		return service.retrieveRenter(userName);
//	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Renter renter = service.retrieveRenter(username);
		return new User(
			renter.getName(),
			renter.getPassword(),
			AuthorityUtils.createAuthorityList(getAuthorities())
		);
	}
	
	private String[] getAuthorities() {
			String[] authorities = new String[2];
			authorities[0] = "ADMIN";
			authorities[1] = "USER";
		return authorities;
	}
	
//	public boolean validateUser(String user, String password) {
//		return user.equalsIgnoreCase("admin") && password.equals("admin123");
//	}
	
	
	
//	public Renter renterSearch() {
//		return 
//	}

}
