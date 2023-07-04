package com.sample.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sample.book.dao.BookDaoImpl;
import com.sample.book.entity.Book;


@Service
public class BookServiceImpl implements BookService{
	@Resource 
	BookDaoImpl BookDao;
	@Override
	public List<Book> findAll() {
		return BookDao.findAll();
	}
	@Override
	public void insertBook(Book book) {
		BookDao.insertBook(book);
		
	}
	@Override
	public void updateBook(Book book) {
		BookDao.updateBook(book);
		
	}
	@Override
	public void executeUpdateBook(Book book) {
		BookDao.executeUpdateBook(book);
		
	}

	@Override
	public void deleteBook(Book book) {
		BookDao.deleteBook(book);
		
	}
}
