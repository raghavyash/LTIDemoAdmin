package com.lti;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class CustomerMainWebApplication extends SpringBootServletInitializer{
	private static final Logger LOGGER = LogManager.getLogger(CustomerMainWebApplication.class);
	public static void main(String[] args) {
		 LOGGER.info("Application has been started");
		SpringApplication.run(CustomerMainWebApplication.class, args);

	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CustomerMainWebApplication.class);
    }
}
