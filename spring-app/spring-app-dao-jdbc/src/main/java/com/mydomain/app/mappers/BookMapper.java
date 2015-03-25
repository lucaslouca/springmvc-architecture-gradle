package com.mydomain.app.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mydomain.app.domain.Book;

public class BookMapper implements RowMapper<Book> {
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		if (rs.first()) {
			Book book = new Book();
			book.setId(rs.getLong("id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			return book;
		} else {
			return null;
		}
	}
}
