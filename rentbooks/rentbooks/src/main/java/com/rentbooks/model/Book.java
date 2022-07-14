package com.rentbooks.model;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Book() {
	}
	
	public Book(int id, String name, int price, char available) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.available = available;
	}

	private int id;
	private String name;
	private int price;
	private char available;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getAvailable() {
		return available;
	}
	public void setAvailable(char available) {
		this.available = available;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String
				.format("Book [id=%s, name=%s, price=%s, available=%s]", 
						id, name, price, available);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}
	
}
