package com.nirmal.pachakari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EnableResourceServer
public class PachakariApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PachakariApplication.class);
		app.run(args);
	}	
}
