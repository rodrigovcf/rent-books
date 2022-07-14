package com.rentbooks.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/default")
	public String showHomeDefaul(HttpServletRequest request) {
		
		if (request.isUserInRole("ROLE_ADMIN"))
			return "redirect:/admin/home";
		
		return "redirect:/Renter/home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome(ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String showHomeAdmin(ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value = "/Renter/home", method = RequestMethod.GET)
	public String showHomeRenter(ModelMap model) {
		return "home";
	}
}
