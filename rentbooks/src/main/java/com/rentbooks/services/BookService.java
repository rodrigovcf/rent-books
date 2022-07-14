package com.rentbooks.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import com.rentbooks.model.Book;

@Service
public class BookService {

	private static List<Book> books = new ArrayList<Book>();
	
	//Livros disponíveis Y
	private static List<Book> availableBooks = new ArrayList<Book>();
	
	
	private static List<Book> statusBookList = new ArrayList<Book>();
	private static int bookCount = 1000;
	
	static {
		books.add(new Book(++bookCount, "Wings of Fire", 150, 'N'));
		books.add(new Book(++bookCount, "Life of Monk", 50, 'N'));
		books.add(new Book(++bookCount, "Programming", 250, 'Y'));
		books.add(new Book(++bookCount, "Design Pattern", 30, 'Y'));
		books.add(new Book(++bookCount, "Programming", 250, 'Y'));
		books.add(new Book(++bookCount, "Design Pattern", 30, 'Y'));
		books.add(new Book(++bookCount, "Programming", 250, 'Y'));
		books.add(new Book(++bookCount, "Design Pattern", 30, 'Y'));
	}

	public List<Book> addAvailableBooks() {
		availableBooks = new ArrayList<Book>();
		for(Book book: books) {
			if(book.getAvailable() == 'Y')
				availableBooks.add(book);
		}
		return availableBooks;
	}

	public void addBook(String name, int price, char available) {
		books.add(new Book(++bookCount, name, price, 'Y'));
	}

	public List<Book> retrieveBooks(){
		List<Book> filteredBooks = new ArrayList<Book>();
		for (Book book: books) {
			filteredBooks.add(book);
		}
		return filteredBooks;
	}

	
	//Busca um livro da lista geral de livros, com base em um id
	public Book retrieveBook(int id) {
		for (Book book: books) {
			if(book.getId() == id)
				return book;
		}
		return null;
	}

	
	//Requisita um livro disponivel Y e atualiza a lista geral para N
	//Com base no id do livro
	public List<Book> requestBook(int id) {
		statusBookList.add(retrieveBook(id));
//		books.remove(retrieveBook(id));
		retrieveBook(id).setAvailable('N');
		return statusBookList;
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
