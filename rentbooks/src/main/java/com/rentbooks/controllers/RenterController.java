package com.rentbooks.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentbooks.model.Renter;
import com.rentbooks.services.RenterService;

@Controller
public class RenterController {
	
	@Autowired
	private RenterService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(ModelMap model) {
		model.addAttribute("renter", new Renter());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addRenter(ModelMap model, Renter renter) {
		service.addRenter(renter.getName(), renter.getPassword());
		return "redirect:/login";
	}
	
}
