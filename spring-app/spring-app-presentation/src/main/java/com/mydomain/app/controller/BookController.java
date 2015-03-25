package com.mydomain.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydomain.app.api.BookDoesNotExistException;
import com.mydomain.app.api.LibraryService;
import com.mydomain.app.config.ServiceConfig;
import com.mydomain.app.domain.Book;

@Controller
@ContextConfiguration(classes = { ServiceConfig.class })
public class BookController {
	@Autowired
	LibraryService libraryService;

	@RequestMapping("/book")
	public String hello(@RequestParam(value = "id", required = false, defaultValue = "0") Long id, Model model) {

		Book book;
		try {
			book = libraryService.findBook(id);
			model.addAttribute("title", book.getTitle());
		} catch (BookDoesNotExistException e) {
			e.printStackTrace();
		}

		//returns the view name
		return "book";

	}
}
