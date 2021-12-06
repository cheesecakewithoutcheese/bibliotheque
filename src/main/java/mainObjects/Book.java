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
	private Oeuvre oeuvres[];
	public String url;

/***********************************************************************************************************/


  private Long getId() { return id; }
  
  private String getUrl() {
	return url;
}

private void setUrl(String url) {
	this.url = url;
}

private void setId(Long id) { this.id = id; }
 

	private String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		this.author = author;
	}

	private Oeuvre[] getOeuvres() {
		return oeuvres;
	}

	private void setWorks(Oeuvre[] oeuvres) {
		this.oeuvres = oeuvres;
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
	
}
