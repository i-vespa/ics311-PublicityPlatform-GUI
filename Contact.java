package project4GUI;

import java.sql.Date;

/*Contact class: a container for a Contact entity retrieved from the 
	 * author_publicity_platform database. Will be used by the ContactAssocWithClient_database_connector 
	 * to construct a list of Contact objects, based on the information from the Contact table
	 * of the author_publicity_platform database
	 * */
public class Contact {
	private int contact_id;
	private String station_etc; //make accessor, constructor call, toString, getters, and setters
	private String contact_fname;
	private String contact_lname;
	private int area_code;
	private int phone_num;
	private String email;
	private String website;
	private String media_type;
	private String city;
	private String state;
	Date created_date;
	Date last_updated_date;
	
	/*Constructor*/
	public Contact(int contact_id, String station_etc, String contact_fname, String contact_lname, int area_code, int phone_num,
			String email, String website, String media_type, String city, String state, Date created_date,
			Date last_updated_date) {
		super();
		this.contact_id = contact_id;
		this.station_etc = station_etc;
		this.contact_fname = contact_fname;
		this.contact_lname = contact_lname;
		this.area_code = area_code;
		this.phone_num = phone_num;
		this.email = email;
		this.website = website;
		this.media_type = media_type;
		this.city = city;
		this.state = state;
		this.created_date = created_date;
		this.last_updated_date = last_updated_date;
	}

	/*Getter and Setter methods*/
	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getContact_fname() {
		return contact_fname;
	}

	public void setContact_fname(String contact_fname) {
		this.contact_fname = contact_fname;
	}

	public String getContact_lname() {
		return contact_lname;
	}

	public void setContact_lname(String contact_lname) {
		this.contact_lname = contact_lname;
	}

	public int getArea_code() {
		return area_code;
	}

	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}

	public int getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(int phone_num) {
		this.phone_num = phone_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	public String getStation_etc() {
		return station_etc;
	}

	public void setStation_etc(String station_etc) {
		this.station_etc = station_etc;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	/*ToString method to print out attributes of a Contact object
	 * primarily used for testing*/
	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", station_etc=" + station_etc + ", contact_fname=" + contact_fname
				+ ", contact_lname=" + contact_lname + ", area_code=" + area_code + ", phone_num=" + phone_num
				+ ", email=" + email + ", website=" + website + ", media_type=" + media_type + ", city=" + city
				+ ", state=" + state + ", created_date=" + created_date + ", last_updated_date=" + last_updated_date
				+ "]\n";
	}
	
}
