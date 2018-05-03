package project4GUI;

import java.sql.Date;
/*Book:
 *This class is used to contain data from a row of the book table
 *of the author_publicity_platform
 *Will be used in Form 3 */
public class Book {
	private int book_id;
	private int client_id;
	private String book_name;
	private String self_publish;
	private Date publish_date;
	private String where_available;
	private String genre;
	private String basic_plot;
	private Date created_date;
	private Date last_updated_date;
	
	/*Constructor*/
	public Book(int book_id, int client_id, String book_name, String self_publish, Date publish_date,
			String where_available, String genre, String basic_plot, Date created_date, Date last_updated_date) {
		
		this.book_id = book_id;
		this.client_id = client_id;
		this.book_name = book_name;
		this.self_publish = self_publish;
		this.publish_date = publish_date;
		this.where_available = where_available;
		this.genre = genre;
		this.basic_plot = basic_plot;
		this.created_date = created_date;
		this.last_updated_date = last_updated_date;
	}

	/*Getters and Setters*/
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getSelf_publish() {
		return self_publish;
	}

	public void setSelf_publish(String self_publish) {
		this.self_publish = self_publish;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getWhere_available() {
		return where_available;
	}

	public void setWhere_available(String where_available) {
		this.where_available = where_available;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBasic_plot() {
		return basic_plot;
	}

	public void setBasic_plot(String basic_plot) {
		this.basic_plot = basic_plot;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", client_id=" + client_id + ", book_name=" + book_name + ", self_publish="
				+ self_publish + ", publish_date=" + publish_date + ", where_available=" + where_available + ", genre="
				+ genre + ", basic_plot=" + basic_plot + ", created_date=" + created_date + ", last_updated_date="
				+ last_updated_date + "]\n";
	}
	
	/*ToString:
	 * to print out all information on a book object*/
	
	

}
