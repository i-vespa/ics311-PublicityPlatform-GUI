package project4GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
    
/*Form1GuiDisplay: Displays the GUI user interface for the Client table of the
 * author_publicity_platform database. 
 * It allows the user to naviage through each client in the Client table
 * through the use of "first", "last", "next" and "previous" buttons
 * 
 * This class uses a Client_database_connector class object as a DAO between
 * the actual database, and the GUI.
 * */
public class Form1GuiDisplay extends JFrame/*implements ActionListener*/{

	/* Will contain a list that is filled by the client_database_connector*/
	/*will contain a client_database_connector object*/	
	/*make labels for all variables in Client class*/
	JLabel JL_client_id;
	JLabel JL_client_fname;
	JLabel JL_client_lname;
	JLabel JL_area_code;
	JLabel JL_phone_num;
	JLabel JL_street;
	JLabel JL_city;
	JLabel JL_state;
	JLabel JL_zip;
	JLabel JL_email;
	JLabel JL_created_date;
	JLabel JL_last_updated_date;
	//JLabel JL_fname, JL_lname, JL_age, JL_id;
       
	/*text fields for each attribute in Client class*/
	JTextField JT_client_id;
	JTextField JT_client_fname;
	JTextField JT_client_lname;
	JTextField JT_area_code;
	JTextField JT_phone_num;
	JTextField JT_street;
	JTextField JT_city;
	JTextField JT_state;
	JTextField JT_zip;
	JTextField JT_email;
	JTextField JT_created_date;
	JTextField JT_last_updated_date;
	
    
	/*Make GUI navigation buttons to move to first, next, previous, and last object*/
	JButton btn_first,btn_next,btn_previous,btn_last;
	int pos = 0;
	Client_database_connector clientDbConn = null;
	List<Client> clientList = null;
           
	/**
	 * Creates the frame and displays it.
	 */
	public Form1GuiDisplay() {
		super("Form 1: Client Table");
		clientDbConn = new Client_database_connector();
		/*Instantiate all text labels in the GUI */
		JLabel JL_client_id =  new JLabel("Client ID:");
		JLabel JL_client_fname =  new JLabel("Client fname:");
		JLabel JL_client_lname =  new JLabel("Client lname:");
		JLabel JL_area_code =  new JLabel("Area Code:");
		JLabel JL_phone_num =  new JLabel("Phone:");
		JLabel JL_street =  new JLabel("Street");
		JLabel JL_city =  new JLabel("City:");
		JLabel JL_state =  new JLabel("State:");
		JLabel JL_zip =  new JLabel("Zip:");
		JLabel JL_email =  new JLabel("Email:");
		JLabel JL_created_date =  new JLabel("Created Date:");
		JLabel JL_last_updated_date =  new JLabel("Last Updated:");
		
		/*Set locations for labels*/
	     JL_client_id.setBounds(20, 20, 100, 20);
	     JL_client_fname.setBounds(20, 50, 100, 20);
	     JL_client_lname.setBounds(20, 80, 100, 20);	
	     JL_area_code.setBounds(20, 110, 100, 20);
	     JL_phone_num.setBounds(20, 140, 100, 20);
	     JL_street.setBounds(20, 170, 100, 20);
	     JL_city.setBounds(20, 200, 100, 20);
	     JL_state.setBounds(20, 230, 100, 20);
	     JL_zip.setBounds(20, 260, 100, 20);
	     JL_email.setBounds(20, 290, 100, 20);
	     JL_created_date.setBounds(20, 320, 100, 20);
	     JL_last_updated_date.setBounds(20, 360, 100, 20);
				     
	     /*Instantiate all text fields*/
	     JT_client_id = new JTextField(30);
	     JT_client_fname = new JTextField(30);
	     JT_client_lname = new JTextField(30);
	     JT_area_code = new JTextField(20);
	     JT_phone_num = new JTextField(20);
	 	 JT_street = new JTextField(50);
	 	 JT_city = new JTextField(50);
	 	 JT_state = new JTextField(50);
	 	 JT_zip = new JTextField(10);
	 	 JT_email = new JTextField(20);
	 	 JT_created_date = new JTextField(10);
	 	 JT_last_updated_date = new JTextField(10);
	     
	     /*Set dimensions of Client attribute fields in GUI*/
	     JT_client_id.setBounds(130,20,150,20);
	     JT_client_fname.setBounds(130, 50, 150, 20);
	     JT_client_lname.setBounds(130, 80, 150, 20);
	     JT_area_code.setBounds(130, 110, 150, 20);
	     JT_phone_num.setBounds(130, 140, 150, 20); 
	 	 JT_street.setBounds(130, 170, 150, 20);
	 	 JT_city.setBounds(130, 200, 150, 20);
	 	 JT_state.setBounds(130, 230, 150, 20);
	 	 JT_zip.setBounds(130, 260, 150, 20);
	 	 JT_email.setBounds(130, 290, 200, 20);
	 	 JT_created_date.setBounds(130, 320, 150, 20);
	 	 JT_last_updated_date.setBounds(130, 360, 150, 20);   
	     //Instantiate and set dimensions of buttons
	     btn_first = new JButton("First");
	     btn_next = new JButton("Next");
	     btn_previous = new JButton("Previous");
	     btn_last = new JButton("Last");
	     btn_first.setBounds(300, 20, 100, 20);
	     btn_next.setBounds(300, 50, 100, 20);
	     btn_previous.setBounds(300, 80, 100, 20);
	     btn_last.setBounds(300, 110, 100, 20);
	     
	        
	     // Button to show the Next user from the List
	     btn_next.addActionListener(new ActionListener() { 
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	             try  { 
	    		 pos++;
	               if(pos < clientDbConn.getAllClientsFromDatabase().size()){
	               //if(pos < BindList().size()){
	                   ShowPosInfo(pos);
	               }
	               else{
	            	   pos = clientDbConn.getAllClientsFromDatabase().size() - 1;
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
	        	pos = clientDbConn.getAllClientsFromDatabase().size() -1;
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
	        
	        /*Adding labels to display*/
	        add(JL_client_id);
	        add(JL_client_fname);
	        add(JL_client_lname);
	        add(JL_area_code);
	        add(JL_phone_num);
	        add(JL_street);
	        add(JL_city);
	        add(JL_state);
	        add(JL_zip);
	        add(JL_email);
	        add(JL_email);
	        add(JL_created_date);
	        add(JL_last_updated_date);
	        
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
	        add(JT_area_code);
	        add(JT_phone_num); 
	        add(JT_street);
	        add(JT_city);
	        add(JT_state);
	        add(JT_zip);
	        add(JT_email);
	        add(JT_created_date);
	        add(JT_last_updated_date); 
	        /*Final framing GUI configuration and send to screen*/
	        setLayout(null);
	        
	       //remove exit on close so menu will remain open
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setSize(500,500);
	        setVisible(true);
	    } 
	    

	/*Helper function to update the text fields in GUI to client
	 * in ClientList based on index */
	public void ShowPosInfo(int index) {
		try {
		//assigning client id info to each JText fields in GUI display
		JT_client_id.setText(Integer.toString(
				clientDbConn.getAllClientsFromDatabase().get(index).getClient_id()));
		//assigning client name info to each JText field in GUI display
		JT_client_fname.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getClient_fname());
		JT_client_lname.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getClient_lname());
		JT_client_lname.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getClient_lname());
		
		//assigning phone number info to each JText fields in GUI display
		JT_area_code.setText(Integer.toString(
				clientDbConn.getAllClientsFromDatabase().get(index).getArea_code()));
		JT_phone_num.setText(Integer.toString(
				clientDbConn.getAllClientsFromDatabase().get(index).getPhone_num()));
		
		//assigning address info to each JText fields in GUI display
		JT_street.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getStreet());
		JT_city.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getCity());
		JT_state.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getState());
		JT_zip.setText(Integer.toString(
				clientDbConn.getAllClientsFromDatabase().
				get(index).getZip()));
		//assigning email info to each JText field in GUI display
		JT_email.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getEmail());
		
		//assigning data retention (date) info to each JText fields in GUI display
		JT_created_date.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getCreated_date().toString());
		JT_last_updated_date.setText(clientDbConn.getAllClientsFromDatabase().
				get(index).getLast_updated_date().toString());
		}  catch (Exception ex) {ex.printStackTrace(); }
    }
    


	public static void main(String[] args){ 
		//Form1GuiDisplay maingui = new Form1GuiDisplay();
	       new Form1GuiDisplay();
	 }
}
