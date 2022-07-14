package com.rentbooks.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Renter implements Serializable, UserDetails{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private List<Role> roles = new ArrayList<Role>();
	private List<Book> statusBooks = new ArrayList<Book>();
	
	public Renter() {}
	
	public Renter(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Book> getBooks() {
		return statusBooks;
	}

	public void setBooks(List<Book> books) {
		this.statusBooks = books;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Role userRole = new Role();
		userRole.setNomeRole("ROLE_USER");
		roles.add(userRole);
		
		return (Collection<?extends GrantedAuthority>) this.roles;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
