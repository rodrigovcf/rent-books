package com.rentbooks.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rentbooks.model.Renter;
import com.rentbooks.security.AuthenticatedUser;

@Service
public class RenterService {

	private static List<Renter> renters = new ArrayList<>();
	private static int renterCount = 10000;
	private static AuthenticatedUser user = new AuthenticatedUser();

	private Renter userRent = new Renter();

	public Renter getUserRent() {
		return userRent;
	}
	
	public static int getRenterCount() {
		++renterCount;
		return renterCount;
	}

	static {
		renters.add(new Renter(getRenterCount(), "rodrigo", "123"));
	}

	public List<Renter> retrieveRenters(){
		List<Renter> filteredRenters = new ArrayList<>();
		for (Renter renter: renters) {
			filteredRenters.add(renter);
		}
		return filteredRenters;
	}

	public void addRenter(String name, String password) {
		renters.add(new Renter(getRenterCount(),name, password));
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

	public Renter retrieverUser() {
		return retrieveRenter(user.retriveLoggedinUserName());
	}

}
