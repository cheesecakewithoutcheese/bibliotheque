package mainObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity 
public class Book {

/***********************************************************************************************************/

	@Id @GeneratedValue public Long id;
	public String author;
	private Work works[];
	public String url;

/***********************************************************************************************************/


  private Long getId() { return id; }
  
  private String getUrl() {
	return url;
}

private void setUrl(String url) {
	this.url = url;
}

public void setId(Long id) { this.id = id; }
 

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	private Work[] getWorks() {
		return works;
	}

	private void setWorks(Work[] works) {
		this.works = works;
	}

/***********************************************************************************************************/

	public Book() {
		//this.author = "new author";
	}
	public Book(String author) {
		super();
		this.author = author;
		this.url = generateUrl();
	}

	/*
	 * private Book(Long id) { super(); this.id = id; }
	 * 
	 * private Book(Long id, String author) { super(); this.id = id; this.author =
	 * author; }
	 */

/***********************************************************************************************************/
	public String toString() {
		return this.author;
	}
	
	public String generateUrl() {
		String aux = new String();
		aux = author.toLowerCase();
		aux = aux.replaceAll(" ", "");
		return aux;
	}
	
	public void main(String args[]) {
		
	}

	public Book orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
