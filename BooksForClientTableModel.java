package project4GUI;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/*BooksForClientTableModel : a model for a list of Books
 * for a particular client. Will be used when generating
 * a table for each client in Form3GuiDisplay*/
public class BooksForClientTableModel extends AbstractTableModel{
	private static final int BOOK_ID_COL = 0;
	private static final int CLIENT_ID_COL = 1; 
	private static final int BOOK_NAME_COL = 2;
	private static final int SELF_PUBLISH_COL = 3;
	private static final int PUBLISH_DATE_COL = 4;
	private static final int WHERE_AVAILABLE_COL = 5;
	private static final int GENRE_COL = 6;
	private static final int BASIC_PLOT_COL = 7;
	private static final int CREATED_DATE_COL = 8;
	private static final int LAST_UPDATED_DATE_COL = 9;
	
	private String[] columnNames = { "book_id",
	"client_id",
	"book_name",
	"self_publish",
	"publish_date",
	"where_available",
	"genre",
	"basic_plot",
	"created_date",
	"last_update_date" };
	private List<Book> books;
	
	public BooksForClientTableModel(List<Book> booksForAClient) {
		books = booksForAClient;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return books.size();
	}   

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {

		Book tempBook = books.get(row);
		/*
		 * BOOK_ID_COL ;
		CLIENT_ID_COL; 
		BOOK_NAME_COL;
		SELF_PUBLISH_COL;
		PUBLISH_DATE_COL;
		WHERE_AVAILABLE_COL;
		GENRE_COL;
		BASIC_PLOT_COL;
		CREATED_DATE_COL;
		LAST_UPDATED_DATE_COL;
		 */
		
		switch (col) {
		case BOOK_ID_COL :
			return tempBook.getBook_id();
		case CLIENT_ID_COL :
			return tempBook.getClient_id();
		case BOOK_NAME_COL:
			return tempBook.getBook_name();
		case SELF_PUBLISH_COL:
			return tempBook.getSelf_publish();
		
		case PUBLISH_DATE_COL :
			return tempBook.getPublish_date();	
		case WHERE_AVAILABLE_COL :
			return tempBook.getWhere_available();	
		
		case GENRE_COL :
			return tempBook.getGenre();	
		case BASIC_PLOT_COL :
			return tempBook.getBasic_plot();		
		case CREATED_DATE_COL:
			return tempBook.getCreated_date();
		case LAST_UPDATED_DATE_COL:
			return tempBook.getLast_updated_date();	
		
		default: //default set so it always returns an object
			return tempBook.getBook_id();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
