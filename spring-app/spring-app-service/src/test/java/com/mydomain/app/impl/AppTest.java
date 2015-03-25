package com.mydomain.app.impl;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mydomain.app.api.LibraryService;
import com.mydomain.app.config.DaoDummyConfig;
import com.mydomain.app.config.ServiceConfig;
import com.mydomain.app.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceConfig.class, DaoDummyConfig.class })
public class AppTest extends TestCase {

	@Autowired
	LibraryService service;

	@Test
	public void testApp() {
		Book book = new Book();
		book.setTitle("Misery");
		book.setAuthor("Steven King");
		Book domain = service.addBook(book);
		assertNotNull(domain.getId());
	}
}
