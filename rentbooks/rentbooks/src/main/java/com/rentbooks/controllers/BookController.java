package com.rentbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentbooks.model.Book;
import com.rentbooks.services.BookService;
import com.rentbooks.services.RenterService;

@Controller
public class BookController {

	private final String viewallbook = "viewallbook";
	
	@Autowired
	private BookService service;

	@Autowired
	private RenterService renterService;

	@RequestMapping(value = "/viewallbook", method = RequestMethod.GET)
	public String showViewAllBook(ModelMap model) {
		model.addAttribute("books",service.retrieveBooks());
		return viewallbook;
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String showAddBook(ModelMap model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addBook(ModelMap model, Book book) {
		service.addBook(book.getName(), book.getPrice(), 'Y');
		model.clear();
		return "redirect:" + viewallbook;
	}


	@RequestMapping(value = "/delete-book", method = RequestMethod.GET)
	public String deleteBook(ModelMap model, @RequestParam int id) {
		service.deleteBook(id);
		model.clear();
		return "redirect:" + viewallbook;
	}

	@RequestMapping(value = "/update-book", method = RequestMethod.GET)
	public String showUpdateBook(ModelMap model, @RequestParam int id) {
		model.addAttribute("book", service.retrieveBook(id));
		return "update";
	}

	@RequestMapping(value = "/update-book", method = RequestMethod.POST)
	public String updateBook(ModelMap model, Book book) {
		service.updateBook(book);
		model.clear();
		return "redirect:" + viewallbook;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String renterBook(ModelMap model) {
		model.addAttribute("books", service.retrieveStatusBooks());
		model.addAttribute("renter", renterService.retrieverUser());
		return "status";
	}

	@RequestMapping(value = "/renter-book", method = RequestMethod.GET)
	public String showStatusBook(ModelMap model, @RequestParam int id) {
		model.addAttribute("books", service.requestBook(id));
		model.addAttribute("renter", renterService.retrieverUser());
		return "status";
	}

	@RequestMapping(value = "/renter-delete", method = RequestMethod.GET)
	public String deleteRent(ModelMap model, @RequestParam int id) {
		service.deleteRent(id);
		model.clear();
		return "redirect:"+ viewallbook;
	}

}
