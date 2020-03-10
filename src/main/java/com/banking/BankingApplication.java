package com.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages="com.banking")
@EntityScan("com.banking.Model.**")
@ComponentScan({"com.banking.Configuration","com.banking.Controller"})
public class BankingApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(BankingApplication.class);
	}
}
