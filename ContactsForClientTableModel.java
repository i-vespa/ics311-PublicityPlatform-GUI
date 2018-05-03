package project4GUI;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/*ContactsForClientTableModel : a model for a list of Contacts
 * for a particular client. Will be used when generating
 * a table for each client in Form2GUIDisplay*/
public class ContactsForClientTableModel extends AbstractTableModel{
	
	private static final int CONTACT_ID_COL = 0;
	private static final int STATION_ETC_COL = 1; 
	private static final int CONTACT_FNAME_COL = 2;
	private static final int CONTACT_LNAME_COL = 3;
	private static final int AREA_CODE_COL = 4;
	private static final int PHONE_NUM_COL = 5;
	private static final int EMAIL_COL = 6;
	private static final int WEBISTE_COL = 7;
	private static final int MEDIA_TYPE_COL = 8;
	private static final int CITY_COL = 9;
	private static final int STATE_COL = 10;
	private static final int CREATED_DATE_COL = 11;
	private static final int LAST_UPDATED_DATE_COL = 12;
	
	private String[] columnNames = { "contact_id",
	"station_etc",
	"contact_fname",
	"contact_lname",
	"area_code",
	"phone_num",
	"email",
	"website",
	"media_type",
	"city",
	"state",
	"created_date",
	"last_updated_date" };
	private List<Contact> contacts;

	public ContactsForClientTableModel(List<Contact> contactsForAClient) {
		contacts = contactsForAClient;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return contacts.size();
	}   

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Contact tempContact = contacts.get(row);
		/*CONTACT_ID_COL 
		CONTACT_ID_COL  
		CONTACT_FNAME_COL
		CONTACT_LNAME_COL
		AREA_CODE_COL 
		PHONE_NUM_COL 
		EMAIL_COL 
		WEBISTE_COL
		MEDIA_TYPE_COL
		CITY_COL
		STATE_COL
		CREATED_DATE_COL 
		LAST_UPDATED_DATE_COL*/
		
		switch (col) {
		case CONTACT_ID_COL :
			return tempContact.getContact_id();
		case STATION_ETC_COL :
			return tempContact.getStation_etc();
		case CONTACT_FNAME_COL:
			return tempContact.getContact_fname();
		case CONTACT_LNAME_COL:
			return tempContact.getContact_lname();
		
		case AREA_CODE_COL :
			return tempContact.getArea_code();	
		case PHONE_NUM_COL :
			return tempContact.getPhone_num();	
		
		case EMAIL_COL :
			return tempContact.getEmail();	
		case WEBISTE_COL :
			return tempContact.getWebsite();
		
		case MEDIA_TYPE_COL:
			return tempContact.getMedia_type();
		case CITY_COL :
			return tempContact.getCity();
		case STATE_COL:
			return tempContact.getState();
		
		case CREATED_DATE_COL:
			return tempContact.getCreated_date();
		case LAST_UPDATED_DATE_COL:
			return tempContact.getLast_updated_date();	
		
		default: //default set so it always returns an object
			return tempContact.getContact_id();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

