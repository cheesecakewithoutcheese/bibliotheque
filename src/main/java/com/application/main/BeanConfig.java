package com.application.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import mainObjects.Book;
import mainObjects.BookCollectionTemp;
import mainObjects.Oeuvre;

@Configuration 
@ComponentScan 
public class BeanConfig {
	
	private static final Logger log = LoggerFactory.getLogger(PersonalLibraryApplication.class);

	@Bean
	  CommandLineRunner initDatabase(BooksRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Book("New Author")));
	      log.info("Preloading " + repository.save(new Book("Another Author")));
	    };
	  }
	
	@Bean
	public CommandLineRunner demo(BooksRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Book("Bauer"));
			repository.save(new Book("Brian"));
			repository.save(new Book("Bauer"));
			repository.save(new Book("Palmer"));
			repository.save(new Book("Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Book book = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(book.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByAuthor("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	
	@Bean
	Book getBook() {
		return new Book();
	}
	
	@Bean
	Oeuvre getOeuvre() {
		return new Oeuvre();
	}
	
	@Bean
	BookCollectionTemp getBooks() {
		return new BookCollectionTemp();
	}
	
//	@Bean
//	@Description("Thymeleaf Template Resolver")
//	public ServletContextTemplateResolver templateResolver() {
//	    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//	    templateResolver.setPrefix("/WEB-INF/views/");
//	    templateResolver.setSuffix(".html");
//	    templateResolver.setTemplateMode("HTML5");
//
//	    return templateResolver;
//	}

//	@Bean
//	@Description("Thymeleaf Template Engine")
//	public SpringTemplateEngine templateEngine() {
//	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//	    templateEngine.setTemplateResolver(templateResolver());
//	    templateEngine.setTemplateEngineMessageSource(messageSource());
//	    return templateEngine;
//	}
	
//	@Bean
//	@Description("Thymeleaf View Resolver")
//	public ThymeleafViewResolver viewResolver() {
//	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	    viewResolver.setTemplateEngine(templateEngine());
//	    viewResolver.setOrder(1);
//	    return viewResolver;
//	}
	
	@Bean
	@Description("Spring Message Resolver")
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	
}
