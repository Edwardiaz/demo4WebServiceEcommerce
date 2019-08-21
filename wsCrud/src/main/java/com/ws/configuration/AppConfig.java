package com.ws.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Identifies this class to Spring as a configuration file
public class AppConfig {
	
	@Bean
	public String productsService() {
		return "RestProductsController";
	}
	
}
