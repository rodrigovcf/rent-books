package com.rentbooks.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rentbooks.model.Book;
import com.rentbooks.model.RentedBooks;

@Service
public class BookService {

	private static List<Book> books = new ArrayList<>();

	private static List<Book> statusBookList = new ArrayList<>();

	private static RentedBooks requestBooks = new RentedBooks();

	private static List<RentedBooks> rentedBooks = new ArrayList<>();

	private static int bookCount = 999;

	public List<Book> addAvailableBooks() {
		List<Book> availableBooks = new ArrayList<>();
		for(Book book: books) {
			if(book.getAvailable() == 'Y' || book.getAvailable() == 'y')
				availableBooks.add(book);
		}
		return availableBooks;
	}

	public static void addBook(String name, int price, char available) {
		books.add(new Book(++bookCount, name, price, available));
	}

	public List<Book> retrieveBooks(){
		List<Book> filteredBooks = new ArrayList<>();
		for (Book book: books) {
			filteredBooks.add(book);
		}
		return filteredBooks;
	}

	public Book retrieveBook(int id) {
		for (Book book: books) {
			if(book.getId() == id)
				return book;
		}
		return null;
	}

	public List<Book> requestBook(int id) {
		statusBookList.add(retrieveBook(id));

		requestBooks.setRentID(id);
		requestBooks.setRentedBooks(statusBookList);

		rentedBooks.add(requestBooks);

		retrieveBook(id).setAvailable('N');
		
		List<Book> requests = null;
		
		for(RentedBooks rented: rentedBooks) {

			if(rented.getRentID() == requestBooks.getRentID())
				requests = requestBooks.getRentedBooks();
		}

		return requests;
	}


	public List<Book> retrieveStatusBooks() {
		return statusBookList;
	}

	public void updateBook(Book book) {

		for(Book eachBook:books) {
			if(eachBook.getId() == book.getId()) {
				eachBook.setName(book.getName());
				eachBook.setPrice(book.getPrice());
				eachBook.setAvailable(book.getAvailable());
			}
		}
	}

	public void deleteBook(int id) {
		Iterator<Book> iterator = books.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id)
				iterator.remove();
		}
	}

	public void deleteRent(int id) {
		Iterator<Book> iterator = statusBookList.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id)
				iterator.remove();
		}
		retrieveBook(id).setAvailable('Y');
	}

}
