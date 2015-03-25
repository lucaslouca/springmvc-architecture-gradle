package com.mydomain.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mydomain.app.BookDao;
import com.mydomain.app.dao.dummy.BookDaoImpl;

@Configuration
public class DaoDummyConfig {

	@Bean
	public BookDao bookDao() {
		return new BookDaoImpl();
	}

}
