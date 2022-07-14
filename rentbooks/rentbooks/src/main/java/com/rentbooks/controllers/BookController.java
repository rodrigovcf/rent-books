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

	private static final String VIEW_ALL_BOOK = "/admin/viewallbook";
	private static final String PARAM_BOOK = "books";
	private static final String  PARAM_REDIRECT = "redirect:";
	
	@Autowired
	private BookService service;

	@Autowired
	private RenterService renterService;

	@RequestMapping(value = "/admin/viewallbook", method = RequestMethod.GET)
	public String showViewAllBook(ModelMap model) {
		model.addAttribute(PARAM_BOOK,service.retrieveBooks());
		return VIEW_ALL_BOOK;
	}

	@RequestMapping(value = "/admin/addbook", method = RequestMethod.GET)
	public String showAddBook(ModelMap model) {
		model.addAttribute("book", new Book());
		return "admin/addbook";
	}

	@RequestMapping(value = "/admin/addbook", method = RequestMethod.POST)
	public String addBook(ModelMap model, Book book) {
		BookService.addBook(book.getName(), book.getPrice(), 'Y');
		model.clear();
		return PARAM_REDIRECT + VIEW_ALL_BOOK;
	}


	@RequestMapping(value = "/admin/delete-book", method = RequestMethod.GET)
	public String deleteBook(ModelMap model, @RequestParam int id) {
		service.deleteBook(id);
		model.clear();
		return PARAM_REDIRECT + VIEW_ALL_BOOK;
	}

	@RequestMapping(value = "/admin/update-book", method = RequestMethod.GET)
	public String showUpdateBook(ModelMap model, @RequestParam int id) {
		model.addAttribute("book", service.retrieveBook(id));
		return "update";
	}

	@RequestMapping(value = "/admin/update-book", method = RequestMethod.POST)
	public String updateBook(ModelMap model, Book book) {
		service.updateBook(book);
		model.clear();
		return PARAM_REDIRECT + VIEW_ALL_BOOK;
	}

	@RequestMapping(value = "/Renter/status", method = RequestMethod.GET)
	public String renterBook(ModelMap model) {
		model.addAttribute(PARAM_BOOK, service.retrieveStatusBooks());
		model.addAttribute("renter", renterService.retrieverUser());
		return "status";
	}

	@RequestMapping(value = "/Renter/renter-book", method = RequestMethod.GET)
	public String showStatusBook(ModelMap model, @RequestParam int id) {
		model.addAttribute(PARAM_BOOK, service.requestBook(id));
		model.addAttribute("renter", renterService.retrieverUser());
		return "status";
	}

	@RequestMapping(value = "/Renter/renter-delete", method = RequestMethod.GET)
	public String deleteRent(ModelMap model, @RequestParam int id) {
		service.deleteRent(id);
		model.clear();
		return PARAM_REDIRECT + VIEW_ALL_BOOK;
	}
	
	@RequestMapping(value = "/Renter/viewallbook", method = RequestMethod.GET)
	public String showViewAllBookRenter(ModelMap model) {
		model.addAttribute(PARAM_BOOK,service.retrieveBooks());
		return VIEW_ALL_BOOK;
	}

}
