package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication


@ComponentScan({"com.company"})
public class AssignApplication extends SpringBootServletInitializer{
	
	@Override
	
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	
	      return application.sources(AssignApplication.class);
	
	   }

	public static void main(String[] args) {
		SpringApplication.run(AssignApplication.class, args);
	}

}
