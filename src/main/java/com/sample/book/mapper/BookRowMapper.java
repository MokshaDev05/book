package com.sample.book.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.book.entity.Book;



public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		Book book = new Book();
		book.setBookId(rs.getString("BookId"));
		book.setBookName(rs.getString("BookName"));
		
		book.setBookISBN(rs.getString("BookISBN"));
 
        return book;
	}


}
