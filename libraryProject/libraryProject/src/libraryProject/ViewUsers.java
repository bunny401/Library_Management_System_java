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

public class ViewUsers {
	
	public static void ViewUser()
	{
		 JFrame f = new JFrame("Users List");
         
          
          
		 JFrame g = new JFrame("All Users Details");
			 String returnbooksFile = "usersSerialization.txt";
		      ArrayList list; boolean found = false;

		      try {
					ArrayList<UsersParam> namesList = new ArrayList<UsersParam>();
					ArrayList<UsersParam> namesList_output = new ArrayList<UsersParam>();
					list = (ArrayList) SerializationLib.doDeserialize(returnbooksFile);
					// System.out.println("def():\n --"+"\n |\n "+def);

					namesList = (ArrayList<UsersParam>) list;
					
					System.out.println(System.lineSeparator());

					ArrayList<String> columns = new ArrayList<String>();
					ArrayList<String[]> values = new ArrayList<String[]>();
					columns.add("User Name");
					columns.add("Password");
					columns.add("Role");
				 
					
					for (int i = 0; i < namesList.size(); i++) {
						values.add(new String[] {namesList.get(i).username ,
								namesList.get(i).password , 
								namesList.get(i).role_});
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
