package com.rentbooks.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rentbooks.model.Book;
import com.rentbooks.model.Renter;
import com.rentbooks.security.AuthenticatedUser;

@Service
public class RenterService {
	
	private static List<Renter> renters = new ArrayList<Renter>();
	private static int renterCount = 10000;
	private static AuthenticatedUser user = new AuthenticatedUser();
	
	private static Renter userRent = new Renter();
	
	private Renter userTemp; 
	
	public static Renter getUserRent() {
		return userRent;
	}

	static {
		renters.add(new Renter(++renterCount, "rodrigo", "123"));
	}
	
	public List<Renter> retrieveRenters(){
		List<Renter> filteredRenters = new ArrayList<Renter>();
		for (Renter renter: renters) {
			filteredRenters.add(renter);
		}
		return filteredRenters;
	}
	
	public void addRenter(String name, String password) {
		renters.add(new Renter(++renterCount,name, password));
	}
	
	public void deleteRenter(int id) {
		Iterator<Renter> iterator = renters.iterator();
		while(iterator.hasNext()) {
			Renter renter = iterator.next();
			if (renter.getId() == id)
				iterator.remove();
		}
	}

	
	public Renter retrieveRenter(String userName) {
		for (Renter renter: renters) {
			if(renter.getName().equals(userName)) {
				userRent = renter;
				return renter;
			}
		}
		return null;
	}
	
	public void updateRenter(Renter renter) {
		for(Renter eachRenter:renters) {
			if(eachRenter.getId() == renter.getId()) {
				eachRenter.setName(renter.getName());
				eachRenter.setPassword(renter.getPassword());
			}
		}
	}
	
	public Renter user(String name, String password) {
		for (Renter renter: renters) {
			if(renter.getName() == name) {
				userRent = renter;
				return userRent;
			}
		}
		return null;
	}
	
	public Renter retrieverUser() {
		return retrieveRenter(user.retriveLoggedinUserName());
	}

	//Lista do User logado
	public Renter renterListBook(List<Book> books) {
		userTemp = new Renter();
		userTemp = userRent;
		userTemp.setBooks(books);
		
		return userTemp;
	}

	public Renter getUserTemp() {
		return userTemp;
	}

}
