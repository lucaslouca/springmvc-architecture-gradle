package com.mydomain.app.dao.dummy;

import java.util.ArrayList;
import java.util.List;

import com.mydomain.app.BookDao;
import com.mydomain.app.domain.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public Book save(Book o) {
		System.out.println("Book saved");
		o.setId(1l);
		return o;
	}

	@Override
	public Book findById(Long id) {
		System.out.println("Book find");
		Book book = new Book();
		book.setTitle("Dummy Title");
		book.setAuthor("Dummy Author");
		book.setId(id);
		return book;
	}

	@Override
	public Book update(Book o) {
		System.out.println("Book updated");
		return o;
	}

	@Override
	public void remove(Book o) {
		System.out.println("Book removed");

	}

	@Override
	public List<Book> listAll() {
		return new ArrayList<Book>();
	}

}
