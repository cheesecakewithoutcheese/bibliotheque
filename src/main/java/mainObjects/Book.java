package mainObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity 
public class Book {

/*******************************************/

	@Id @GeneratedValue 
	public Long id;
	@NotNull
	@Size(min=2, max=50)
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
/*******************************************/

	public Book() {
	}
	
	public Book(String author) {
		super();
		this.author = author;
	}

/*******************************************/
	
	@Override 
	public String toString() {
		return this.author;
	}
	
	public void generateUrl() {
		String aux = new String();
			aux = aux.replaceAll(" ", "-");
			aux = this.author.toLowerCase();
		this.url = aux;
	}
	
	public Book orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void main(String args[]) {
		try {
			generateUrl();
		}catch(NullPointerException e) {
			this.url = "notInitialized";
			System.out.println("null pointer exception: url could not be initialized");
		}
	}
	
/*******************************************/
	
}