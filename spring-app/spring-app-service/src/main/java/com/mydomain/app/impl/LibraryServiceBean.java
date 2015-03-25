package com.mydomain.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mydomain.app.BookDao;
import com.mydomain.app.api.BookDoesNotExistException;
import com.mydomain.app.api.LibraryService;
import com.mydomain.app.domain.Book;

public class LibraryServiceBean implements LibraryService {

	@Autowired
	BookDao bookDao;

	@Override
	public Book addBook(Book book) {
		bookDao.save(book);
		return book;
	}

	@Override
	public Book findBook(Long id) throws BookDoesNotExistException {
		Book book = bookDao.findById(id);
		if (book == null) {
			throw new BookDoesNotExistException("The requested Book with id:" + id + " does not exist.");
		}
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		Book mergedBook = bookDao.update(book);
		return mergedBook;
	}

	@Override
	public void removeBook(Book book) throws BookDoesNotExistException {
		Book mergedBook = this.findBook(book.getId());

		if (mergedBook == null) {
			throw new BookDoesNotExistException("Attempt to remove Book: " + book + " failed because it does not Exist.");
		} else {
			bookDao.remove(mergedBook);
		}
	}

	@Override
	public List<Book> listAllBooks() {
		return bookDao.listAll();
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
