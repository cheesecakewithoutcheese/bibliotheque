package com.application.main;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import mainObjects.Oeuvre;

@Component
public interface WorksRepository extends CrudRepository<Oeuvre, Long>{
	
	Oeuvre findById(long id);
	List <Oeuvre> findByTitle(String title);
	List <Oeuvre> findByStatus(boolean status);
	List <Oeuvre> findByType(String type);
	List <Oeuvre> findByAuthor(String author);
}
