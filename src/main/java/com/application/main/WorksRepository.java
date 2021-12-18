package com.application.main;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import mainObjects.Work;

@Component
public interface WorksRepository extends CrudRepository<Work, Long>{
	
	Work findById(long id);
	List <Work> findByTitle(String title);
	List <Work> findByStatus(boolean status);
	List <Work> findByType(String type);
	List <Work> findByAuthor(String author);
	List <Work> findByBookId(Long bookId);
}
