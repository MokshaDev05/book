package com.sample.book.service;

import java.util.List;

import com.sample.book.entity.Book;



public interface BookService {
	List<Book> findAll();

	void insertBook(Book book);

	void updateBook(Book book);

	void executeUpdateBook(Book book);

	void deleteBook(Book book);
	
}
