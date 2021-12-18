package com.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("mainObjects")
public class mainApplication {

	public static void main(String[] args) {

		SpringApplication.run(mainApplication.class, args);
	}

}
