package com.application.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import mainObjects.Book;

@SpringBootApplication
@EntityScan("mainObjects")
public class mainApplication {

	public static void main(String[] args) {

		SpringApplication.run(mainApplication.class, args);
	}

}
