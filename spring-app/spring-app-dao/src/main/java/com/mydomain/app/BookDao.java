package com.mydomain.app;

import java.util.List;

import com.mydomain.app.domain.Book;

public interface BookDao extends GenericDao<Book> {

	List<Book> listAll();

}
