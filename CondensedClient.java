package project4GUI;
/*Condensed Client: a helper-class that composes a Client object
 * of only the client_id, client_fname, and client_lname
 * 
 *  This is to be used in ContactAssocWithClient_database (form2), since
 *  the natural join of the Client-ClientPublicityContact-Contact tables will
 *  result in a 'loss' of the attributes like city, state, etc. associated
 *  with the client, since they have the same name as the Contact table.
 *  
 *  Since Form2's GUI only needs the Client's ID, f_name and l_name,
 *  we will use this condensedClient to contain this essential data. 
 *  */
public class CondensedClient {
	private int client_id;
	private String client_fname;
	private String client_lname;
	
	/*Constructor*/
	public CondensedClient(int client_id, String client_fname, String client_lname) {
		super();
		this.client_id = client_id;
		this.client_fname = client_fname;
		this.client_lname = client_lname;
	}

	/*Getters and setters*/
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

	/*ToString printing method*/
	@Override
	public String toString() {
		return "CondensedClient [client_id=" + client_id + ", client_fname=" + client_fname + ", client_lname="
				+ client_lname + "]\n";
	}

}
