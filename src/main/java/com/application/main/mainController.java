package com.application.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class mainController {
	
	@Autowired 
	private final BooksRepository repository;
	private final WorksRepository wrepo;
	
	mainController(BooksRepository repository, WorksRepository wrepo){
		this.repository = repository;
		this.wrepo = wrepo;
	}
	
	@RequestMapping("/library")
	public String library(@RequestParam(name="user", required=false, defaultValue="new user") String user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("books", repository.findAll());
		return "YourLibrary";
	}
	
	@RequestMapping("/{author}")
	public String book(@PathVariable String author, Model model) {
		model.addAttribute("author", repository.findByAuthor(author));
		model.addAttribute("works", wrepo.findByAuthor(author));
		return "YourBook";
	}
}
