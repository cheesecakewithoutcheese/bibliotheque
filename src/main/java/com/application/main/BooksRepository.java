package com.application.main;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import mainObjects.Book;
import mainObjects.Oeuvre;

public interface BooksRepository extends CrudRepository<Book, Long>{

  List<Book> findByAuthor(String author);
  Book findById(long id);
  List <Book> findByUrl(String url);
}