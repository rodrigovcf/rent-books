package com.rentbooks.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.rentbooks.services.RenterService;

public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	private String roleName;
	
	private RenterService service;
	
	public Role() {}
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getNomeRole() {
		return roleName;
	}

	public void setNomeRole(String roleName) {
		this.roleName = roleName;
	}
	
	public List<Renter> getUsuarios() {
		return service.retrieveRenters();
	}

	@Override
	public String getAuthority() {
		return this.roleName;
	}

}
