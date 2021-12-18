package mainObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Work {

/*********************************************************************/
	
	@Id
	@GeneratedValue
	public Long id;
	public Long bookId;
	public String title, type, author;
	public boolean status;
	public int year;

/*********************************************************************/

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private Long getBookId() {
		return bookId;
	}

	private void setBookId(Long book_Id) {
		this.bookId = bookId;
	}

	private String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	private String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	private String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		this.author = author;
	}

	private boolean isStatus() {
		return status;
	}

	private void setStatus(boolean status) {
		this.status = status;
	}

	private int getYear() {
		return year;
	}

	private void setYear(int year) {
		this.year = year;
	}

/*********************************************************************/

	public Work() {
		
	}

	public Work(String title) {
		super();
		this.title = title;
	}

	public Work(Long bookId) {
		super();
		this.bookId = bookId;
	}
	
/*********************************************************************/
	
	@Override
	public String toString() {
		String r = new String();
		if (this.status)
			r = "read";
		else
			r = "not read";
		return this.title + " by " + this.author + ", " + this.type + " (" + this.year + ") " + r;
	}
}
