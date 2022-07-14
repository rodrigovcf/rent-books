package com.rentbooks.model;

import java.util.List;

public class RentedBooks {
	
	private int rentID;
	
	private List<Book> renteds;

	public int getRentID() {
		return rentID;
	}

	public void setRentID(int rentID) {
		this.rentID = rentID;
	}

	public List<Book> getRentedBooks() {
		return renteds;
	}

	public void setRentedBooks(List<Book> rentedBooks) {
		this.renteds = rentedBooks;
	}
	
}
