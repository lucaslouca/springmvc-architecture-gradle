package com.mydomain.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.mydomain.app.BookDao;
import com.mydomain.app.dao.jdbc.BookDaoImpl;

@Configuration
@ImportResource("classpath:spring-jdbc.xml")
public class DaoJdbcConfig {

	@Bean
	public BookDao bookDao() {
		return new BookDaoImpl();
	}

}
