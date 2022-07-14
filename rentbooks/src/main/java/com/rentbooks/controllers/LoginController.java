package com.rentbooks.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentbooks.model.Renter;
import com.rentbooks.services.RenterService;


@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		Renter user = new Renter();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("user") Renter user, ModelMap model) {

		if((user.getName().equals("admin")) && (user.getPassword().equals("admin123"))) {
			return "redirect:admin/home";

		}else if (RenterService.retrieveRenter(user.getName(), user.getPassword())) {
			return "redirect:Renter/home";

		}else {
			model.put("errorMessage", "Invalid Details - Check Username and Password ");
			return "login";
		}
	}

}
