package libraryProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ViewIssuedBooks {
	public static void issuedBooks() {
	    JFrame f = new JFrame("Users List");
        
	    JFrame g = new JFrame("All Issued Books Details");
	
		 String returnbooksFile = "allissuedbooksSerialization.txt";
	      ArrayList list; boolean found = false;

	      try {
				ArrayList<issueBooksParam> namesList = new ArrayList<issueBooksParam>();
				ArrayList<issueBooksParam> namesList_output = new ArrayList<issueBooksParam>();
				list = (ArrayList) SerializationLib.doDeserialize(returnbooksFile);
				// System.out.println("def():\n --"+"\n |\n "+def);

				namesList = (ArrayList<issueBooksParam>) list;
				
				System.out.println(System.lineSeparator());

				ArrayList<String> columns = new ArrayList<String>();
				ArrayList<String[]> values = new ArrayList<String[]>();
				columns.add("BookID");
				columns.add("Username");
				columns.add("period for");
				columns.add("issued date");
				
				for (int i = 0; i < namesList.size(); i++) {
					values.add(new String[] {namesList.get(i).bid ,
							namesList.get(i).username , 
							namesList.get(i).period, 
							namesList.get(i).issued_date});
				}

				TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				JTable table = new JTable(tableModel);
				// TestJFrame testJFrame = new TestJFrame();
				// table = new JTable(model);
				JScrollPane scrollPane = new JScrollPane(table);

				g.add(scrollPane);
				g.setSize(800, 500);
				g.setVisible(true);
				g.setLocationRelativeTo(null);
				 
	      } catch (ClassNotFoundException | IOException e) {
	  		e.printStackTrace();
	  	}
	      

         
         
	}
}
