package com.rentbooks.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/admin/home")
	public String showAdmin(ModelMap model) {
		return "admin/home";
	}
	
	@RequestMapping(value = "/Renter/home")
	public String showRenter(ModelMap model) {
		return "Renter/home";
	}
}
