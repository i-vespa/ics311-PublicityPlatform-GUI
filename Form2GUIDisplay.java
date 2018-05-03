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


/*Form2GuiDisplay: Displays the GUI user interface for the Client table of the
 * author_publicity_platform database. 
 * It allows the user to naviage through each client in the Client table
 * through the use of "first", "last", "next" and "previous" buttons
 *
 * This class uses a Client_database_connector class object as a DAO between
 * the actual database, and the GUI.
 * */
public class Form2GUIDisplay extends JFrame{
	JLabel JL_large_title;
	/*make labels for all variables in Client class*/
	JLabel JL_client_id;
	JLabel JL_client_fname;
	JLabel JL_client_lname;
	
	/*text fields for each attribute in Client class*/
	JTextField JT_client_id;
	JTextField JT_client_fname;
	JTextField JT_client_lname;
	
	/*Make GUI navigation buttons to move to first, next, previous, and last object*/
	JButton btn_first,btn_next,btn_previous,btn_last;
	int pos = 0;
	ContactAssocWithClient_database_connector contactClientDbConn = null;
	List<CondensedClient> clientList = null;
	List<Contact> contactsPerClient = null;
	/*Contact table*/
	private JTable table;
	
	/**
	 * Creates the frame and displays it.
	 */
	public Form2GUIDisplay() {
		super("Form 2: Contacts Per Client");
		contactClientDbConn = new ContactAssocWithClient_database_connector();
		
		/*TESTING!!! CONTENT PANES*/
		final JScrollPane scrollPane;
		final JPanel contentPane;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		/*Instantiate all text labels in the GUI */
		JL_large_title = new JLabel("Author & Associated Contact Information:");
		JL_large_title.setFont(new Font("Arial", Font.BOLD, 20));
		JL_client_id =  new JLabel("Client ID:");
		JL_client_fname =  new JLabel("Client fname:");
		JL_client_lname =  new JLabel("Client lname:");
		
		/*Set locations for labels*/
		 JL_large_title.setBounds(50, 20, 500, 50);
		 JL_client_id.setBounds(20, 100, 100, 20);
	     JL_client_fname.setBounds(20, 130, 100, 20);
	     JL_client_lname.setBounds(20, 160, 100, 20);	
	    /*JL_client_id.setBounds(20, 20, 100, 20);
	     JL_client_fname.setBounds(20, 50, 100, 20);
	     JL_client_lname.setBounds(20, 80, 100, 20);	
	    */
	     /*Instantiate Client attribute text fields */
	     JT_client_id = new JTextField(30);
	     JT_client_fname = new JTextField(30);
	     JT_client_lname = new JTextField(30);
	     /*Set dimensions of Client attribute fields in GUI*/
	     JT_client_id.setBounds(130,100,150,20);
	     JT_client_fname.setBounds(130, 130, 150, 20);
	     JT_client_lname.setBounds(130, 160, 150, 20);

	     //Instantiate and set dimensions of buttons
	     btn_first = new JButton("First");
	     btn_next = new JButton("Next");
	     btn_previous = new JButton("Previous");
	     btn_last = new JButton("Last");
	     btn_first.setBounds(300, 100, 100, 20);
	     btn_next.setBounds(300, 130, 100, 20);
	     btn_previous.setBounds(300, 160, 100, 20);
	     btn_last.setBounds(300, 190, 100, 20);
	    
	     // Button to show the Next user from the List
	     btn_next.addActionListener(new ActionListener() { 
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	             try  { 
	    		 pos++;
	               if(pos < contactClientDbConn.getAllDistinctClientsFromDatabase().size()){
	               //if(pos < BindList().size()){
	                   ShowPosInfo(pos);
	               }
	               else{
	            	   pos = contactClientDbConn.getAllDistinctClientsFromDatabase().size() - 1;
	                   //pos = BindList().size() - 1;
	                   ShowPosInfo(pos);
	                   JOptionPane.showMessageDialog(null, "END");
	               }
	         }catch (Exception ex) {ex.printStackTrace(); }
	             }         
	     });

	     // Button to show the First user from the List
	     //activated when "first" button is pressed
	     btn_first.addActionListener(new ActionListener(){    
	    	 @Override
	    	 public void actionPerformed(ActionEvent e){
	    		 pos = 0;
	             ShowPosInfo(pos);
	        }
	        });
	             
	     // Button to show the Last user from the List
	     //activates when "next" button is pressed
	     //gets final row using the local list composed in the data connector
	     btn_last.addActionListener(new ActionListener(){
	    	 @Override       
	    	 public void actionPerformed(ActionEvent e){
	        	try {
	        	pos = contactClientDbConn.getAllDistinctClientsFromDatabase().size() -1;
	            ShowPosInfo(pos);
	        	} catch (Exception ex) {ex.printStackTrace(); }
	        }
	        });
	                
	     //Button to show the Previous user from the List
	     //activates when  "previous" button is pressed
	     btn_previous.addActionListener(new ActionListener(){  
	    	 @Override  
	    	 public void actionPerformed(ActionEvent e){
	    		 pos--;
	    		 if(pos > 0){
	    			 ShowPosInfo(pos);
	    		 }
	    		 else{
	    			 pos = 0;
	    			 ShowPosInfo(pos);
	    			 JOptionPane.showMessageDialog(null, "END");  
	    		 }     
	    	 }
	        });
    
	     	/*Then set labels and add them to screen*/    
	     	/*Adding labels to display*/
	     	add(JL_large_title);
	     	add(JL_client_id);
	        add(JL_client_fname);
	        add(JL_client_lname);
	        
	        table = new JTable(); //instantiate the jtable
	        /*Update the position info of the client based on the position passed*/
	        ShowPosInfo(pos);
	        
	        /*Adding current position's button's Client attributes to screen*/
	        add(btn_last);
	        add(btn_first);
	        add(btn_previous);
	        add(btn_next);
	        add(JT_client_id);
	        add(JT_client_fname);
	        add(JT_client_lname);
	        
	        /*Final framing GUI configuration and send to screen*/
	        //setLayout(null);
	        setLayout(new BorderLayout());
	       //remove exit on close so menu will remain open
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        table.setPreferredScrollableViewportSize(new Dimension(450,100));
	        table.setFont(new Font("Arial", Font.BOLD, 10));
	        
	        //this.add(table);
	        /*JScrollPane scrollPane = new JScrollPane(table);
	        JPanel panel = new JPanel();
	        panel.add(scrollPane);
	        JFrame frame = new JFrame();
	        frame.getContentPane().add(panel, BorderLayout.SOUTH);*/
	        
	        scrollPane = new JScrollPane();
			contentPane.add(scrollPane, BorderLayout.SOUTH);
			
			scrollPane.setViewportView(table);
	        
	        setLocationRelativeTo(null);
	        setSize(900,500);
	        setVisible(true);
	}
	
	/*Helper function to update the text fields in GUI to client
	 * in ClientList based on index */
	public void ShowPosInfo(int index) {
		try {
		//assigning client id info to each JText fields in GUI display
		JT_client_id.setText(Integer.toString(
				contactClientDbConn.getAllDistinctClientsFromDatabase().get(index).getClient_id()));
		//assigning client name info to each JText field in GUI display
		JT_client_fname.setText(contactClientDbConn.getAllDistinctClientsFromDatabase().
				get(index).getClient_fname());
		JT_client_lname.setText(contactClientDbConn.getAllDistinctClientsFromDatabase().
				get(index).getClient_lname());
		
		/*Set contact table to that particular client*/
		// create the model and update the "table"
		int client_id = contactClientDbConn.getAllDistinctClientsFromDatabase().get(index).getClient_id();
		contactsPerClient = contactClientDbConn.getAllContactsForAClient(client_id);	
		ContactsForClientTableModel model= new ContactsForClientTableModel(contactsPerClient);
		table.setModel(model);		
		}  catch (Exception ex) {ex.printStackTrace(); }
    }
	
	public static void main(String[] args){ 
		//Form1GuiDisplay maingui = new Form1GuiDisplay();
	       new Form2GUIDisplay();
	 }
  
}

