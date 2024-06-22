package com.bbp.bootboardproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BootBoardProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBoardProjectApplication.class, args);
	}

}
