package com.application.main;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mainObjects.Book;
import mainObjects.Work;

@Controller
public class MainController {

	@Autowired
	private final BooksRepository repository;
	private final WorksRepository wrepo;

	MainController(BooksRepository repository, WorksRepository wrepo) {
		this.repository = repository;
		this.wrepo = wrepo;
	}

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("books", repository.findAll());
		return "index";
	}
	
	@RequestMapping("/library")
	public String library(@RequestParam(name = "user", required = false, 
			defaultValue = "new user") String user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("books", repository.findAll());
		return "YourLibrary";
	}

	@RequestMapping("/library/{url}")
	public String book(@PathVariable("url") String url, Model model) {
		model.addAttribute("author", repository.findByUrl(url).toString());
		Book book = repository.findByUrl(url);
		model.addAttribute("works", wrepo.findByBookId(book.id));
		model.addAttribute("url", url);
		return "YourBook";
	}
	
	@GetMapping("/library/{id}/delete")
	public String deleteAuthor(@PathVariable("id") long id, Model model) {
		Book book = repository.findById(id);
		repository.delete(book);
		return "redirect:/library";
	}

	@GetMapping("/addbook")
	public String addAuthorForm(Model model) {
		model.addAttribute("book", new Book());
		return "AddBook";
	}

	@PostMapping("/addbook")
	public String saveAuthorSubmission(@ModelAttribute @Valid Book book, Model model, BindingResult bindingResult) {
		/*
		 * if(repository.findByAuthor(book.author)==null) { repository.save(book);
		 * return "Result"; } else { model.addAttribute("url", book.url); return
		 * "NegativeResult"; }
		 */
		if(bindingResult.hasErrors()) {
			model.addAttribute("url", book.url);
			return "NegativeResult";
		}
		else {
		repository.save(book);
		return "Result";
		}
	}
	
	@GetMapping("/library/{url}/addwork")
	public String addWorkForm(Model model, @PathVariable String url) {
		Book book = repository.findByUrl(url);
		model.addAttribute("work", new Work(book.id));
		model.addAttribute("inheritAuthor", book.toString());
		String[] allTypes = {"novel", "novella", "short story", "essay", "poem", "other"};
		model.addAttribute("allTypes", allTypes);
		return "AddWork";
	}

	@PostMapping("/library/{url}/addwork")
		public String saveWorkSubmission(@ModelAttribute Work work, Model model) {
		if(wrepo.findByTitle(work.title)==null) {
			wrepo.save(work);
			if(repository.findByAuthor(work.author)==null) repository.save(new Book(work.author));
			model.addAttribute("work", work);
			return "ResultWork";
		}
		else {
			model.addAttribute("book", repository.findById(work.bookId));
			return "NegativeResult";
		}
	}
	
	@GetMapping("/delete/{title}")
	public String deleteUser(@PathVariable("title") String title, Model model) {
		List<Work> work = wrepo.findByTitle(title);
		wrepo.deleteAll(work);
		return "redirect:/library";
	}	
}