package mainObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity 
public class Book {

/*******************************************/

	@Id @GeneratedValue 
	public Long id;
	public String author;
	@Autowired
	private Work works[];
	public String url;

/*******************************************/
	
	private Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	private void setAuthor(String author) {
		this.author = author;
	}
	private Work[] getWorks() {
		return works;
	}
	private void setWorks(Work[] works) {
		this.works = works;
	}
	private String getUrl() {
		return url;
	}
	private void setUrl(String url) {
		this.url = url;
	}
	
/*******************************************/

	public Book() {
		
	}
	
	public Book(String author) {
		super();
		this.author = author;
		this.url = generateUrl();
	}

/*******************************************/
	
	@Override 
	public String toString() {
		return this.author;
	}
	
	public String generateUrl() {
		String aux = new String();
		aux = this.author.toLowerCase();
		aux = aux.replaceAll(" ", "-");
		return aux;
	}
	
	public Book orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*******************************************/
	
}