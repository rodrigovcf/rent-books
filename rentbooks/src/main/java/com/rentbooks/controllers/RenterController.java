package com.rentbooks.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentbooks.model.Renter;
import com.rentbooks.services.RenterService;

@Controller
public class RenterController {

	private static final String PAGE_REGISTER = "register";
	private static final String PARAM_ERROR_MSG = "errorMessage";
	
	@Autowired
	private RenterService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		Renter user = new Renter();
		model.addAttribute("renter", user);
		return PAGE_REGISTER;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addRenter(@ModelAttribute("renter") Renter renter, ModelMap model) {

		switch (validateFields(renter.getName(), renter.getPassword(), renter.getCpassword())) {
		case 1:
			model.put(PARAM_ERROR_MSG, "Invalid format:\n "
					+ "- fields cannot be empty\n" 
					+ "- password do not match with confirm password");
			return PAGE_REGISTER;
		case 2:
			model.put(PARAM_ERROR_MSG, "Invalid format - fields cannot be empty");
			return PAGE_REGISTER;
		case 3:
			model.put(PARAM_ERROR_MSG, "Invalid format - password do not match with confirm password");
			return PAGE_REGISTER;
		case 0:
			model.put(PARAM_ERROR_MSG, "Successfully added!");
			service.addRenter(renter.getName(), renter.getPassword());
			return "redirect:/login";
		default:
			return PAGE_REGISTER;
		}
	}

	private int validateFields(String name, String pass, String cpass) {

		if (((name.isEmpty()) || pass.isEmpty() || cpass.isEmpty()) && 
				(!pass.equals(cpass)))
			return 1;
		else if ((name.isEmpty()) || pass.isEmpty() || cpass.isEmpty())
			return 2;
		else if (!pass.equals(cpass)) 
			return 3;
		else return 0;
	}

}
