package com.rentbooks.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {


	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String showHomeAdmin(ModelMap model) {
		return "/admin/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomeAdmin2(ModelMap model) {
		return "/admin/home";
	}

	@RequestMapping(value = "/Renter/home", method = RequestMethod.GET)
	public String showHomeRenter(ModelMap model) {
		return "/Renter/home";
	}
}
