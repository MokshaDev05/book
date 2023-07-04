package com.sample.book.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.book.entity.Book;
import com.sample.book.mapper.BookRowMapper;


@Repository
public class BookDaoImpl implements BookDao{
	
	public BookDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template; 
	@Override
	public List<Book> findAll() {
		return template.query("select * from book", new BookRowMapper());
	}
	@Override
	public void insertBook(Book book) {
		 final String sql = "insert into book(bookId, bookName , bookISBN) values(:bookId,:bookName,:bookISBN)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("bookId", book.getBookId())
					.addValue("bookName", book.getBookName())
					
					.addValue("bookISBN", book.getBookISBN());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateBook(Book book) {
		 final String sql = "update book set bookName=:bookName, bookISBN=:bookISBN where bookId=:bookId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("bookId", book.getBookId())
					.addValue("bookName", book.getBookName())
					
					.addValue("bookISBN", book.getBookISBN());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void executeUpdateBook(Book book) {
		 final String sql = "update book set bookName=:bookName, bookISBN=:bookISBN, where bookId=:bookId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("bookId", book.getBookId());
		 map.put("bookName", book.getBookName());
	
		 map.put("bookISBN", book.getBookISBN());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void deleteBook(Book book) {
		 final String sql = "delete from book where bookId=:bookId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("bookId",book.getBookId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
}
