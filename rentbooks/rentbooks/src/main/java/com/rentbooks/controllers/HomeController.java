package com.rentbooks.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rentbooks.services.RenterService;

@Controller
public class HomeController {
	
	
	
//	@RequestMapping(value = "/default")
//	public String showHomeDefaul(HttpServletRequest request) {
//		ModelAndView page = new ModelAndView();
//		if (request.isUserInRole("ROLE_ADMIN")) {
//			page.setViewName("./admin/home");
//			return page.getViewName();
//		}else {
//			page.setViewName("./Renter/home");
//			return page.getViewName();
//		}
//
//	}
	

	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String showHomeAdmin(ModelMap model) {
		return "/admin/home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomeAdmin2(ModelMap model) {
		return "/admin/home";
	}
	
//	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
//	public String showHome(ModelMap model) {
//		return "admin/home";
//	}
	
//	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
//	public String showHomeAdmin(ModelMap model) {
//		return "home";
//	}
	
	@RequestMapping(value = "/Renter/home", method = RequestMethod.GET)
	public String showHomeRenter(ModelMap model) {
		return "home";
	}
}
