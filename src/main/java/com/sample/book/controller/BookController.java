package com.sample.book.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.book.entity.Book;
import com.sample.book.service.BookService;

@RestController
public class BookController {

	@Resource 
	BookService bookService;
	
	@GetMapping(value = "/book")
	public List<Book> getBook() {
		return bookService.findAll();
	
	}
	
	@PostMapping(value = "/book")
	public void createUser(@RequestBody Book book) {
		bookService.insertBook(book);
	
	}
	
	@PutMapping(value = "/book")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		
	
	}
	@PutMapping(value = "/executeUpdateBook")
	public void executeUpdateBook(@RequestBody Book book) {
		bookService.executeUpdateBook(book);
	
	}
	
	@DeleteMapping(value = "/book")
	public void deleteBook(@RequestBody Book book) {
		bookService.deleteBook(book);
	
	}
	
	
	
}
