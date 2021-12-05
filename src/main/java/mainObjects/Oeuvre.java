package mainObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Oeuvre {

/***********************************************************************************************************/
	
	private Long id;
	private String title, type;
	private boolean status;
	private int year;
	
/***********************************************************************************************************/
	
	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
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

/***********************************************************************************************************/
	
	public Oeuvre() {
	}

	private Oeuvre(Long id) {
		super();
		this.id = id;
	}

	private Oeuvre(String title) {
		super();
		this.title = title;
	}

	private Oeuvre(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	private Oeuvre(String title, boolean status) {
		super();
		this.title = title;
		this.status = status;
	}

	private Oeuvre(Long id, String title, boolean status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}
	private Oeuvre(String title, String type, boolean status) {
		super();
		this.title = title;
		this.type = type;
		this.status = status;
	}
	
/***********************************************************************************************************/
	public String toString() {
		String r = new String();
		if(this.status) r = "read";
		else r = "not read";
		return this.title + ", " + this.type + " (" + this.year + ") " + r;
	}
}
