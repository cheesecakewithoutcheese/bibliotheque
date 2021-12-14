package mainObjects;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Work {

/***********************************************************************************************************/
	@Id @GeneratedValue
	public Long id;
	public String title, type, author;
	public boolean status;
	public int year;
	
/***********************************************************************************************************/
	
	private Long getId() {
		return id;
	}
	public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
	private void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

/***********************************************************************************************************/
	
	public Work() {
	}

	private Work(Long id) {
		super();
		this.id = id;
	}

	public Work(String title) {
		super();
		this.title = title;
	}

	private Work(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	private Work(String title, boolean status) {
		super();
		this.title = title;
		this.status = status;
	}

	private Work(Long id, String title, boolean status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}
	public Work(String title, String type, boolean status) {
		super();
		this.title = title;
		this.type = type;
		this.status = status;
	}
	public Work(String author, String title) {
		super();
		this.author = author;
		this.title = title;
	}
	
/***********************************************************************************************************/
	public String toString() {
		String r = new String();
		if(this.status) r = "read";
		else r = "not read";
		return this.title + " by " + this.author + ", " + this.type + " (" + this.year + ") " + r;
	}
}
