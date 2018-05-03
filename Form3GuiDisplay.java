package project4GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.List;

public class Form3GuiDisplay extends JFrame{
	/*make labels for prompt for client_id to search*/
	JTextField clientIdTextField;
	
	/*make labels for all variables in Client class*/
	JLabel JL_large_title;
	JLabel JL_enter_client_id;
	
	/*text fields for each attribute in Client class*/
	//JTextField JT_client_id;
	
	/*Make GUI navigation buttons to submit user's query of client_id*/
	JButton btn_search;
	int pos = 0;
	BooksPerClient_database_connector bookClientDbConn = null;
	List<CondensedClient> clientList = null;
	List<Book> booksPerClient = null;
	
	/*Books table*/
	private JTable table;
	
	/*
	 * Form3GuiDisplay():
	 * Form3's constructor is used to display the form 3 GUI. 
	 * If a client_id is typed in  and the search button is pressed, it uses
	 * the Books-Client database connector to query all books
	 * for that client_id, if it exists*/
	public Form3GuiDisplay() {
		/*instantiate database connector*/
		// TODO Auto-generated constructor stub
		super("Form 3: Search Books for Client_ID");
		bookClientDbConn = new BooksPerClient_database_connector();
		final JScrollPane scrollPane;
		final JPanel contentPane;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JL_large_title = new JLabel("Search for Author's (client) Books:");
		JL_large_title.setFont(new Font("Arial", Font.BOLD, 20));
		
		JL_enter_client_id = new JLabel("Enter client_id");
		add(JL_enter_client_id);
		
		clientIdTextField = new JTextField();
		add(clientIdTextField);
		clientIdTextField.setColumns(10);
		
		/*Instantiate bounds of labels and text fields*/
		JL_large_title.setBounds(50, 20, 500, 50); 
		JL_enter_client_id.setBounds(20, 100, 100, 20);
		clientIdTextField.setBounds(200, 100, 100, 20);
		
		/*Location of search button*/
		btn_search = new JButton("Search");
		btn_search.setBounds(100, 150, 100, 20);
		
		/*Add actionlistener for search button*/
		btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String client_id = clientIdTextField.getText();
					List<Book> books = null;
					

					if (client_id != null && client_id.trim().length() > 0) {
						books = bookClientDbConn.getAllBooksForAClient(Integer.parseInt(client_id));
						
					} else {
						books = bookClientDbConn.getAllBooks();
					}
					
					// create the model and update the "table"
					BooksForClientTableModel model = new BooksForClientTableModel(books);
					booksPerClient = bookClientDbConn.getAllBooksForAClient(Integer.parseInt(client_id));	
					table.setModel(model);
					
					/*
					for (Employee temp : employees) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(Form3GuiDisplay.this, "Error: " + exc, "Error", 
							JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		
		/*Then set labels and add them to screen*/    
     	/*Adding labels to display*/
     	add(JL_large_title);
     	add(JL_enter_client_id);
     	add(clientIdTextField);
       
        table = new JTable(); //instantiate the jtable
        
        /*Adding current position's button's Client attributes to screen*/
        add(btn_search);
        setLayout(new BorderLayout());
        //remove exit on close so menu will remain open
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setPreferredScrollableViewportSize(new Dimension(450,100));
	    table.setFont(new Font("Arial", Font.BOLD, 10));
	    
	    scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		scrollPane.setViewportView(table);
        setLocationRelativeTo(null);
        setSize(900,500);
        setVisible(true);

		
	}
		
	public static void main(String[] args){ 
		   new Form3GuiDisplay();
	 }
    


}
