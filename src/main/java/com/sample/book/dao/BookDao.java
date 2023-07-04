package com.sample.book.dao;

import java.util.List;

import com.sample.book.entity.Book;

public interface BookDao{

	List<Book> findAll();

	void insertBook(Book book);

	void updateBook(Book book);

	void executeUpdateBook(Book book);

	public void deleteBook(Book book);
}
