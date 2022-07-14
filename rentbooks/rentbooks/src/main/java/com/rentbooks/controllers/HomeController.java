package com.rentbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(ModelMap model) {
		return "home";
	}

}


