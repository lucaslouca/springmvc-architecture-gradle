package com.mydomain.app.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mydomain.app.BookDao;
import com.mydomain.app.domain.Book;
import com.mydomain.app.mappers.BookMapper;

public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		this.setDataSource(dataSource);
		this.getJdbcTemplate().setDataSource(dataSource);
	}

	/**
	 * Insert a new Book into the database.
	 * 
	 * @throws RuntimeException
	 *             if id is not null
	 */
	@Override
	public Book save(Book book) {
		if (book.getId() == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", book.getTitle());
			map.put("author", book.getAuthor());
			SimpleJdbcInsert sji = new SimpleJdbcInsert(getJdbcTemplate());
			sji.setTableName("book");
			sji.setGeneratedKeyName("id");
			Long id = (Long) sji.executeAndReturnKey(map);
			book.setId(id);
			return book;
		} else {
			throw new RuntimeException("Book exist");
		}
	}

	/**
	 * Find a Book by id.
	 * 
	 * @return Book if it exists, else it returns null.
	 */
	@Override
	public Book findById(Long id) {
		String sql = "select * from book where id = ?;";
		try {
			return getJdbcTemplate().queryForObject(sql, new BookMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * Update a Book in the database. If book does not exist (id==null) the book
	 * is inserted into the database, else it gets updated.
	 * 
	 * @return Book the persisted book
	 */
	@Override
	public Book update(Book book) {
		if (book.getId() == null) {
			return this.save(book);
		} else {
			getJdbcTemplate().update("update book set name = ?, author = ? where id = ?", book.getTitle(), book.getAuthor(), book.getId());
			return book;
		}
	}

	/**
	 * Remove an existing book from the database.
	 * 
	 * @throws IllegalArgumentException
	 *             if id is null
	 */
	@Override
	public void remove(Book book) {
		if (book.getId() == null) {
			throw new IllegalArgumentException("Book is not created yet, the ID is null.");
		} else {
			getJdbcTemplate().update("delete from book where id = ?", book.getId());
		}

	}

	@Override
	public List<Book> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
