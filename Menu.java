package project4GUI;
import javax.swing.*;

/*Menu: a basic menu that provides access to the 3 GUI Forms*/
import java.awt.event.*;
public class Menu {
	static Form1GuiDisplay form1object = null;
	static Form2GUIDisplay form2object = null;
	static Form3GuiDisplay form3object = null;
	
	public static void main (String args[]) {
		JFrame  frame = new JFrame("Menu");
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu menu = new JMenu("Menu");
		menubar.add(menu);
		//form 1 object
		JMenuItem form1ClientMenuItem = new JMenuItem("Form 1: Client");
		menu.add(form1ClientMenuItem);
		
		//form 2 object
		JMenuItem form2ContactsPerClientMenuItem = new JMenuItem("Form 2: Clients and Associated Contacts");
		menu.add(form2ContactsPerClientMenuItem);
		
		//form 3 object
				JMenuItem form3BooksPerClientMenuItem = new JMenuItem("Form 3: Clients and Associated Books");
				menu.add(form3BooksPerClientMenuItem);
				
		
		form1ClientMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				form1object = new Form1GuiDisplay();
			}
		});
		
		
		form2ContactsPerClientMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				form2object = new Form2GUIDisplay();
				
			}
		});
		
		form3BooksPerClientMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				form3object = new Form3GuiDisplay();
				
			}
		});
		}

}
