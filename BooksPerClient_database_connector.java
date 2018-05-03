package project4GUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*BooksPerClient_database_connector: acts as a DAO (data access object), 
 * as a middle-man between the author_publicity_platform database and user interface
 * to gather data from the natural joined Client-Book tables,
 * (to basically gather all the author clients and books associated with them)
 * 
 *  This class also will and process the gathered table data in a useful way to 
 *  be used by the GUI for Form3*/
public class BooksPerClient_database_connector {
	private Connection myConnection;
	
	BooksPerClient_database_connector() {
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
	
		
	
	/*Helper Method: get all books for a client based on their client_id*/
	public List<Book> getAllBooksForAClient(int client_id) throws Exception{
		List<Book> bookList = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
			
		/*Attempt to run statement to get all Clients from database, else throw exception
		 * to the calling function*/ 
		try {
			
			myStmt = myConnection.createStatement();
			
			/*Query to list of contacts associated with client of aparticular id*/
			myRs = myStmt.executeQuery("select client_id, client_fname, client_lname, "
					+ "book_id, book_name, self_publish, publish_date, where_available, "
					+ "genre, basic_plot, book.created_date, book.last_update_date "
					+ "from client join book using (client_id) "
					+ "where client_id = "+ Integer.toString(client_id) + ";");
			
			while (myRs.next()) {
				/*Convert particular row's contact attribtues to a contact object*/
				//Client tempClient = convertRowToClient(myRs);
				Book tempBook = convertRowToBook(myRs);
				bookList.add(tempBook);
			
				//CondensedClient tempCondensedClient = convertRowToCondensedClient(myRs);
				//condensedClientList.add(tempCondensedClient);
				}
			return bookList;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	/*Helper method - getAllBooks - will be used in GUI if used doesnt enter a client_id
	 * in search bar*/
	public List<Book> getAllBooks() throws Exception{
		List<Book> bookList = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;
			
		/*Attempt to run statement to get all Clients from database, else throw exception
		 * to the calling function*/ 
		try {
			myStmt = myConnection.createStatement();
			/*Query to list of contacts associated with client of aparticular id*/
			myRs = myStmt.executeQuery("select book_id, book_name, self_publish, publish_date, "
					+ "where_available, "
					+ "genre, basic_plot, book.created_date, book.last_update_date "
					+ "from client join book using (client_id);");
	
			while (myRs.next()) {
				/*Convert particular row's contact attribtues to a contact object*/
				//Client tempClient = convertRowToClient(myRs);
				Book tempBook = convertRowToBook(myRs);
				bookList.add(tempBook);
			
				//CondensedClient tempCondensedClient = convertRowToCondensedClient(myRs);
				//condensedClientList.add(tempCondensedClient);
				}
			return bookList;		
		}
		finally {
			close(myStmt, myRs);
		}
	}	
		
	/*convertRowToBok: helper function that makes a book object for a particular
	 * row from a SQL query*/
	private Book convertRowToBook(ResultSet myRs) throws SQLException {
		int book_id = myRs.getInt("book_id");
		int client_id = myRs.getInt("client_id");
		String book_name = myRs.getString("book_name");
		String self_publish = myRs.getString("self_publish");
		Date publish_date = myRs.getDate("publish_date");
		String where_available = myRs.getString("where_available");
		String genre = myRs.getString("genre");
		String basic_plot = myRs.getString("basic_plot");
		Date created_date = myRs.getDate("book.created_date");
		Date last_updated_date = myRs.getDate("book.last_update_date");
		
		Book tempBook = 
				new Book(book_id, client_id, book_name, self_publish, publish_date, 
						where_available, genre, basic_plot, created_date, last_updated_date);
		return tempBook;		
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
		BooksPerClient_database_connector booksAssocClient_connector = 
				new BooksPerClient_database_connector();
		

		/*Testing Correctness of getAllContactsForClient*/
		System.out.println(booksAssocClient_connector.getAllBooksForAClient(100));
	}	
}

