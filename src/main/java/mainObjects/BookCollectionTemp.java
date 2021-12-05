package mainObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.application.main.BeanConfig;

@Component 
public class BookCollectionTemp{
	
	@Autowired
	private Book[] books;

	private Book[] getBooks() {
		return books;
	}

	private void setBooks(Book[] books) {
		this.books = books;
	}

	public BookCollectionTemp() {
	}

	private BookCollectionTemp(Book[] books) {
		super();
		this.books = books;
	}
	
}
