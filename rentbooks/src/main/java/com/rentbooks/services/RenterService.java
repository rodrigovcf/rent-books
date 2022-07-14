package com.rentbooks.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rentbooks.model.Renter;

@Service
public class RenterService {

	private static List<Renter> renters = new ArrayList<>();
	private static int renterCount = 9999;

	private static Renter userRent;

	public static Renter getUserRent() {
		return userRent;
	}

	public static int getRenterCount() {
		++renterCount;
		return renterCount;
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

	public boolean existName(String userName) {
		for (Renter renter: renters) {
			if(renter.getName().equals(userName)) {
				return true;
			}
		}
		return false;
	}

	public void updateRenter(Renter renter) {
		for(Renter eachRenter:renters) {
			if(eachRenter.getId() == renter.getId()) {
				eachRenter.setName(renter.getName());
				eachRenter.setPassword(renter.getPassword());
			}
		}
	}

	public static List<Renter> getRenters() {
		return renters;
	}

	public Renter retrieverUser() {
		return getUserRent();
	}


	public static boolean retrieveRenter(String userName, String pass) {
		for (Renter renter: renters) {
			if((renter.getName().equals(userName)) && 
					(renter.getPassword().equals(pass))) {
				userRent = renter;
				return true;
			}
		}
		return false;
	}

}
