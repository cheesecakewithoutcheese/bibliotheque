package com.application.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mainObjects.Book;

@Controller 
public class mainController {
	
	@Autowired 
	private final BooksRepository repository;
	
	mainController(BooksRepository repository){
		this.repository = repository;
	}
	
	@RequestMapping("/library")
	public String library(@RequestParam(name="user", required=false, defaultValue="new user") String user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("books", repository.findAll());
		return "YourLibrary";
	}
	
}
