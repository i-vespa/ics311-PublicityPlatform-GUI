package project4GUI;
import java.sql.*;
import java.sql.Date;
import java.util.*;

//import com.luv2code.jdbc.employeesearch.core.Employee;

import java.awt.event.ActionListener;
import java.math.BigDecimal;

/*Client_database_connector: acts as a DAO (data access object), as a middleman
 * between the author_publicity_platform database and user interface
 * to gather data from the Client table, and process the data in a useful
 * way to be used by the GUI*/
public class Client_database_connector {
	//Connection conn = null;
	//connection to database for Client
	private Connection myConnection;
	//constructor
	Client_database_connector() {
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
			
			//Class.forName("com.mysql.jdbc.Driver");
			myConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/author_publicity_platform" , "root", "ics311");		
			
			System.out.println("Connection Object Created: " + myConnection);
			/*Statement st = myConnection.createStatement();
			ResultSet rs = st.executeQuery("select * from Client");
			
			while(rs.next()) {
				System.out.println(rs.getString("client_fname") + " " + rs.getString("client_lname") );
			}*/
		
		} catch (Exception ex) {ex.printStackTrace(); }
		
	}
	
	//getall rows and put them in a list and return it
	/* Returns a list of Client objects
	 * Will be called from the GUI class to instantiate a local list of clients to use
	 * rather than reconnection to the database continuously*/
	public List<Client> getAllClientsFromDatabase() throws Exception{
		List<Client> clientList = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
			
		/*Attempt to run statement to get all Clients from database, else throw exception
		 * to the calling function*/ 
		try {
			myStmt = myConnection.createStatement();
			myRs = myStmt.executeQuery("select * from client");
			
			while (myRs.next()) {
				Client tempClient = convertRowToClient(myRs);
				clientList.add(tempClient);
			} 

			return clientList;		
		}
		finally {
			close(myStmt, myRs);
		}
	
	}
	
	//list all values for a row
	//get first row
	//get previous row
	//get next row
	//get last row
	/*ConvertRowToClient is a helper function that encapsulates the functionality of making a Client
	 * object from the particular SQL row that results from the query.
	 * In particular, we will use this when we are compiling our list of employees to loop through*/
	private Client convertRowToClient(ResultSet myRs) throws SQLException {
		int client_id = myRs.getInt("client_id");
		String client_fname = myRs.getString("client_fname");
		String client_lname = myRs.getString("client_lname");
		int area_code = myRs.getInt("area_code");
		int phone_num = myRs.getInt("phone_num");
		String street = myRs.getString("street");
		String city = myRs.getString("city");
		String state = myRs.getString("state");
		int zip  = myRs.getInt("zip");
		String email =  myRs.getString("email");
		Date created_date = myRs.getDate("created_date");
		Date last_updated_date = myRs.getDate("last_update_date");
		
		/*int id = myRs.getInt("id");
		String lastName = myRs.getString("last_name");
		String firstName = myRs.getString("first_name");
		String email = myRs.getString("email");
		BigDecimal salary = myRs.getBigDecimal("salary");*/
		
		Client tempClient = new Client(client_id, client_fname, 
				client_lname, area_code, phone_num, 
				street, city, state, zip, 
				email, created_date, last_updated_date);
		//Employee tempEmployee = new Employee(id, lastName, firstName, email, salary);
		//return tempEmployee;
		return tempClient;
	}
	
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
		/*try {
			System.out.println("Loading driver...");

			try {
			    Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("Driver loaded!");
			} catch (ClassNotFoundException e) {
			    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
			}
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
			//conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/author_publicity_platform" , "root", "ics311");		
			
			System.out.println("Connection Object Created: " + conn);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Client");
			
			while(rs.next()) {
				System.out.println(rs.getString("client_fname") + " " + rs.getString("client_lname") );
			}
		
		} catch (Exception ex) {ex.printStackTrace();
		}*/
		//now query:
		//Statement st = con.createstate
		
		
		/*Testing correctness of getAllEmployes function*/
		Client_database_connector client_connector = new Client_database_connector();
		System.out.println(client_connector.getAllClientsFromDatabase());
	}
}