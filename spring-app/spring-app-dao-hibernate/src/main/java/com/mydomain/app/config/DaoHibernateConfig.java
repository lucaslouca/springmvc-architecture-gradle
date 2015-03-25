package com.mydomain.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mydomain.app.BookDao;
import com.mydomain.app.dao.hibernate.BookDaoImpl;

@Configuration
@EnableTransactionManagement
@ImportResource("classpath:spring-hibernate.xml")
public class DaoHibernateConfig {

	@Bean
	public BookDao bookDao() {
		return new BookDaoImpl();
	}

}
