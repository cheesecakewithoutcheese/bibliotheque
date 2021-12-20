package com.application.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import mainObjects.Book;
import mainObjects.Work;

@Configuration
@ComponentScan
public class BeanConfig {

	@Bean
	Book getBook() {
		return new Book();
	}

	@Bean
	Work getWork() {
		return new Work();
	}

	/*********************************************************************/
	//private static final Logger log = LoggerFactory.getLogger(mainApplication.class);

	/*
	 * @Bean CommandLineRunner initDatabase(BooksRepository repository) {
	 * 
	 * return args -> { log.info("Preloading " + repository.save(new
	 * Book("Liviu Rebreanu"))); log.info("Preloading " + repository.save(new
	 * Book("Ion Neculce"))); }; }
	 */
	
	/*
	 * @Bean int initDatabase(BooksRepository repo) { repo.save(new
	 * Book("Ion Barbu")); return 0; }
	 */

	/*
	 * @Bean public CommandLineRunner demo(BooksRepository repository) { return
	 * (args) -> {
	 * 
	 * // save a few books //repository.save(new Book("Charles Baudelaire"));
	 * //repository.save(new Book("Jonathan Swift")); //repository.save(new
	 * Book("Daniel Defoe"));
	 * 
	 * // fetch all books log.info("books found with findAll():");
	 * log.info("-------------------------------"); for (Book book :
	 * repository.findAll()) { log.info(book.toString()); } log.info("");
	 * 
	 * // fetch an individual book by ID Book book = repository.findById(1L);
	 * log.info("Customer found with findById(1L):");
	 * log.info("--------------------------------"); log.info(book.toString());
	 * log.info("");
	 * 
	 * // fetch customers by last name
	 * log.info("Author found with findByAuthor('Charles Baudelaire'):");
	 * log.info("--------------------------------------------");
	 * repository.findByAuthor("Charles Baudelaire").forEach(charles -> {
	 * log.info(charles.toString()); }); // for (Customer bauer : //
	 * repository.findByLastName("Bauer")) { // log.info(bauer.toString()); // }
	 * log.info(""); }; }
	 */

	/*
	 * @Bean CommandLineRunner initRepository(WorksRepository wrepo) {
	 * 
	 * return args -> { log.info("Preloading " + wrepo.save(new
	 * Work("Liviu Rebreanu", "Ion"))); log.info("Preloading " + wrepo.save(new
	 * Work("Ion Neculce", "O sama de cuvinte"))); log.info("Preloading " +
	 * wrepo.save(new Work("Liviu Rebreanu", "Rascoala"))); }; }
	 */

	/*
	 * @Bean public CommandLineRunner demoRepo(WorksRepository wrepo) { return
	 * (args) -> { // save a few customers //wrepo.save(new
	 * Work("Charles Baudelaire", //"Florile raului")); wrepo.save(new
	 * Work("Jonathan Swift", //"Calatoriile lui Gulliver")); wrepo.save(new
	 * Work("Charles Baudelaire", // "fleures de mals"));
	 * 
	 * // fetch all customers log.info("Customers found with findAll():");
	 * log.info("-------------------------------"); for (Work work :
	 * wrepo.findAll()) { log.info(work.toString()); } log.info("");
	 * 
	 * // fetch an individual customer by ID Work work = wrepo.findById(2L);
	 * log.info("Customer found with findById(1L):");
	 * log.info("--------------------------------"); try {
	 * log.info(work.toString()); } catch (NullPointerException e) {
	 * log.info("nu s-a gasit"); } log.info("");
	 * 
	 * // fetch customers by last name
	 * log.info("Author found with findByTitle('ion'):");
	 * log.info("--------------------------------------------");
	 * wrepo.findByTitle("Ion").forEach(ion -> { log.info(ion.toString()); });
	 * log.info(""); }; }
	 */

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
