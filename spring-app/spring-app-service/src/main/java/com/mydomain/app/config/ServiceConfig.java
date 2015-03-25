package com.mydomain.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import com.mydomain.app.api.LibraryService;
import com.mydomain.app.impl.LibraryServiceBean;

@Configuration
@ContextConfiguration(classes = { DaoDummyConfig.class })
public class ServiceConfig {

	@Bean
	public LibraryService libraryService() {
		return new LibraryServiceBean();
	}

}
