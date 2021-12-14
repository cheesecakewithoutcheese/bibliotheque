package com.application.main;

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

	@RequestMapping("/library")
	public String library(@RequestParam(name = "user", required = false, defaultValue = "new user") String user,
			Model model) {
		model.addAttribute("user", user);
		model.addAttribute("books", repository.findAll());
		return "YourLibrary";
	}

	@RequestMapping("/library/{author}")
	public String book(@PathVariable String author, Model model) {
		model.addAttribute("author", repository.findByAuthor(author));
		model.addAttribute("works", wrepo.findByAuthor(author));
		return "YourBook";
	}

	@PostMapping("/update/{id}")
	public String updateAuthor(@PathVariable("id") long id, @Valid Book author, BindingResult result, Model model) {
		if (result.hasErrors()) {
			author.setId(id);
			return "update-user";
		}
		repository.save(author);
		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Book author = repository.findById(id);
		repository.delete(author);
		return "redirect:/index";
	}

	@GetMapping("/addbook")
	public String addAuthorForm(Model model) {
		model.addAttribute("book", new Book());
		return "AddBook";
	}

	@PostMapping("/addbook")
	public String saveAuthorSubmission(@ModelAttribute Book book) {

		repository.save(book);

		return "Result";
	}

	@GetMapping("/addwork")
	public String addWorkForm(Model model) {
		model.addAttribute("work", new Work());
		String[] allTypes = {"novel", "novella", "short story", "essay", "poem", "other"};
		model.addAttribute("allTypes", allTypes);
		return "AddWork";
	}

	@PostMapping("/addwork")
		public String saveWorkSubmission(@ModelAttribute Work work) {

		wrepo.save(work);
		repository.save(new Book(work.author));
		
		return "Result";
	}
}