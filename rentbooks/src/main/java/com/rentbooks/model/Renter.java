package com.rentbooks.model;

import java.io.Serializable;
import java.util.Objects;

public class Renter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private String cpassword;
	
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
	
	public String getPassword() {
		return password;
	}
	
	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpassword, id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Renter other = (Renter) obj;
		return Objects.equals(cpassword, other.cpassword) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

}
