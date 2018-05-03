package project4GUI;

import java.sql.Date;
/*
 * Client class: a container for a Client entity retrieved from the 
 * Client database will be used by the Client_database_connector to construct
 * a list of Client objects, based on the information from the Client table
 * of the author_publicity_platform database
 * */
public class Client {
	private int client_id;
	private String client_fname;
	private String client_lname;
	private int area_code;
	private int phone_num;
	private String street;
	private String city;
	private String state;
	private int zip;
	private String email;
	Date created_date;
	Date last_updated_date;
	
	public Client(int client_id, String client_fname, String client_lname, int area_code, int phone_num, String street,
			String city, String state, int zip, String email, Date created_date, Date last_updated_date) {
		super();
		this.client_id = client_id;
		this.client_fname = client_fname;
		this.client_lname = client_lname;
		this.area_code = area_code;
		this.phone_num = phone_num;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.created_date = created_date;
		this.last_updated_date = last_updated_date;
	}

	/*Getter and Setter methods*/
	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_fname() {
		return client_fname;
	}

	public void setClient_fname(String client_fname) {
		this.client_fname = client_fname;
	}

	public String getClient_lname() {
		return client_lname;
	}

	public void setClient_lname(String client_lname) {
		this.client_lname = client_lname;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	/*Method to display all data to a UI, primarily used for testing for now*/
	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", client_fname=" + client_fname 
				+ ", client_lname=" + client_lname+ ", area_code=" + area_code 
				+ ", phone_num=" + phone_num + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", email=" + email 
				+ ", created_date=" + created_date 
				+ ", last_updated_date=" + last_updated_date + "]\n";
	}
	
	

}
