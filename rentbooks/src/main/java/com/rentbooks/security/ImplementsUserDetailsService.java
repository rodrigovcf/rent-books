package com.rentbooks.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.rentbooks.model.Renter;
import com.rentbooks.services.RenterService;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private RenterService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Renter renter = service.retrieveRenter(username);
		
		if (renter == null) {
			throw new UsernameNotFoundException("Invalid Details - User does not exists.");
		}
		return new User(renter.getUsername(), renter.getPassword(), true, true, true, true, 
				renter.getAuthorities());
	}
	
}
