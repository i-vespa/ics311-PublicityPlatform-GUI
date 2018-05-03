package project4GUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*ContactAssocWithClient_database_connector: acts as a DAO (data access object), 
 * as a middle-man between the author_publicity_platform database and user interface
 * to gather data from the natural joined Client-ClientPublicityContact-Contact tables,
 * (to basically gather all the author clients and contacts associated with them)
 * 
 *  This class also will and process the gathered table data in a useful way to 
 *  be used by the GUI*/
public class ContactAssocWithClient_database_connector {
	private Connection myConnection;
	
	/*Connect to database*/
	ContactAssocWithClient_database_connector() {
		/*attempt to connect to Client database*/
		try {
			System.out.println("Loading driver...");

			/*attempting to find driver in classpath*/
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("Driver loaded!");
			} catch (ClassNotFoundException e) {
			    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
			}			
			myConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/author_publicity_platform" , "root", "ics311");		
			System.out.println("Connection Object Created: " + myConnection);
			} catch (Exception ex) {ex.printStackTrace(); }
		
	}
	
	/*Query to Client natural join clientpublicitycontact  
	 * natural join Contact table */
	
	/*Get all contacts from table - note there will be repeats*/
	/*Helper Method: get all contacts per client*/
	public List<Contact> getAllContactsForAClient(int client_id) throws Exception{
		List<Contact> contactList = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
			
		/*Attempt to run statement to get all Clients from database, else throw exception
		 * to the calling function*/ 
		try {
			myStmt = myConnection.createStatement();
			/*Query to list of contacts associated with client of aparticular id*/
			myRs = myStmt.executeQuery(" select client_id, contact_id, contact_fname, "
					+ "contact_lname, station_etc, contact.area_code, contact.phone_num, "
					+ "contact.email, website, media_type, contact.city, contact.state, "
					+ "contact.created_date, contact.last_update_date "
					+ "from client join clientpublicitycontact using (client_id) join contact using (contact_id) "
					+ "where client_id = "+ Integer.toString(client_id) + ";");
			
			while (myRs.next()) {
				/*Convert particular row's contact attribtues to a contact object*/
				//Client tempClient = convertRowToClient(myRs);
				Contact tempContact = convertRowToContact(myRs);
				contactList.add(tempContact);
			
				//CondensedClient tempCondensedClient = convertRowToCondensedClient(myRs);
				//condensedClientList.add(tempCondensedClient);
				}
			return contactList;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	

	/*Helper Method: convert row to Condensed Client*/
	/*convertRowToCondensedClient is a helper function that encapsulates the functionality of 
	 * making a CondensedClient object from the particular SQL row that results from the query.
	 * In particular, we will use this when we are compiling our list of clients to loop through
	 * in the GUI*/
	private CondensedClient convertRowToCondensedClient(ResultSet myRs) throws SQLException {
		int client_id = myRs.getInt("client_id");
		String client_fname = myRs.getString("client_fname");
		String client_lname = myRs.getString("client_lname");
		CondensedClient tempCondensedClient = new CondensedClient(client_id, client_fname, 
				client_lname);
		return tempCondensedClient;
	}
	/*convertRowToContact: helper function that makes a contact object for a particular
	 * row from a SQL query*/
	private Contact convertRowToContact(ResultSet myRs) throws SQLException {
		int client_id = myRs.getInt("client_id");
		int contact_id = myRs.getInt("contact_id");
		String station_etc = myRs.getString("station_etc");
		String contact_fname = myRs.getString("contact_fname");
		String contact_lname = myRs.getString("contact_lname");
		int area_code = myRs.getInt("contact.area_code");
		int phone_num= myRs.getInt("contact.phone_num");
		String email = myRs.getString("contact.email");
		String website = myRs.getString("website");
		String media_type = myRs.getString("media_type");
		String city = myRs.getString("contact.city");
		String state = myRs.getString("contact.state");
		Date created_date = myRs.getDate("contact.created_date");
		Date last_updated_date = myRs.getDate("contact.last_update_date");

		Contact tempContact = 
				new Contact(contact_id, station_etc, contact_fname, contact_lname, area_code, phone_num,
				email, website, media_type, city,state, created_date, last_updated_date);
		
		return tempContact;
	}
	
	
	/*Helper Method: Get all <DISTINCT> clients from table*/
	/*getAllDistinctClientsFromDatabase: gathers a list of unique Clients
	 * objects from the natural joined Client-ClientPublicityContact-Contact tables.
	 * Reason why we want distinct clients is because there can be repeats of the 
	 * same Client in the table
	 *  
	 *  */
	public List<CondensedClient> getAllDistinctClientsFromDatabase() throws Exception{
		List<CondensedClient> condensedClientList = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
			
		/*Attempt to run statement to get all Clients from database, else throw exception
		 * to the calling function*/ 
		try {
			myStmt = myConnection.createStatement();
			myRs = myStmt.executeQuery("select distinct(client_id), client_fname, client_lname "
					+ "from client join clientpublicitycontact using (client_id) join contact using (contact_id);");
			
			while (myRs.next()) {
				//Client tempClient = convertRowToClient(myRs);
				CondensedClient tempCondensedClient = convertRowToCondensedClient(myRs);
				condensedClientList.add(tempCondensedClient);
			} 
			return condensedClientList;		
		}
		finally {
			close(myStmt, myRs);
		}	
	}
	
	/*Helper Method: Close methods */
	/*Close connection to statement and result set when not using it*/
	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
	
	//supplementary close function
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	
	public static void main(String[] args) throws Exception {	
		/*Testing connectivity*/
		ContactAssocWithClient_database_connector contactAssocClient_connector = 
				new ContactAssocWithClient_database_connector();
		
		/*Testing correctness of getAllDistinctClientsFromDatabase function*/
		System.out.println(contactAssocClient_connector.getAllDistinctClientsFromDatabase());

		/*Testing Correctness of getAllContactsForClient*/
		System.out.println(contactAssocClient_connector.getAllContactsForAClient(102));
	}
}
