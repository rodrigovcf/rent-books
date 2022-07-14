package com.rentbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LoginController {

	
	
	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}
//	
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(ModelMap model, Renter renter) {
//		RenterService.retrieveRenter(renter.getName());
//		return "login";
//	}
	
	
	
	
	
//	@RequestMapping(value = "login")
//	public String login(@RequestParam String userName) {
//		service.loadUserByUsername(userName);
//		return "login";
//	}
	
//	@RequestMapping(value = "welcome")
//	public String welcome() {
//		return "welcome";
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginRequest(@RequestParam String name,
//							   @RequestParam String password, ModelMap model) {
//		service.user(name, password);
//		return "home";
//	}
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String showLogin(ModelMap model) {
//		model.put("name", "admin");
//		return "home";
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String showLogin() {
//		return "login";
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String loginRequest(@RequestParam String name,
//							   @RequestParam String password, ModelMap model) {
//		if(!service.validateUser(name, password))
//		{
//			model.put("errorMessage", "Invalid Details");
//			return "login";
//		}
//		//Condicionar se Admin -> AdminHome se Renter -> RenterHome
//		model.put("name", name);
//		return "home";
//	}

}
