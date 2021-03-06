package libraryProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UserIssuedBooks {

	public static void userIssuedBooks(String UID) {
		String user =UID;
		
		JFrame g = new JFrame("Books Available");
		 String returnbooksFile = "allissuedbooksSerialization.txt";
		  
			ArrayList list; boolean found = false;

			//List<issueBooksParam> defNext = null;
			try {
				ArrayList<issueBooksParam> namesList = new ArrayList<issueBooksParam>();
				ArrayList<issueBooksParam> namesList_output = new ArrayList<issueBooksParam>();
				list = (ArrayList) SerializationLib.doDeserialize(returnbooksFile);
				// System.out.println("def():\n --"+"\n |\n "+def);

				namesList = (ArrayList<issueBooksParam>) list;
				
				System.out.println(System.lineSeparator());

				ArrayList<String> columns = new ArrayList<String>();
				ArrayList<String[]> values = new ArrayList<String[]>();
				 
				columns.add("bid");
				columns.add("username");
				columns.add("period for");
				columns.add("request issued date");
				
				String bookid, username="", issue_date, Period;
				//int i_value=0;
				//List<String> filteredList = new ArrayList<>();
				for (issueBooksParam i : namesList){
					  //i_value++;
	                  if (i.username.equals(user)){
	                      System.out.println(i);
	                  namesList_output.add(i);
	                     found = true;
	                   /*  bookid =i.bid;
	                     username = i.username;
	                     issue_date=i.issued_date;
	                     Period = i.period;
	            
	                     
							
							 * values2.add(i.bid); filteredList.add(username); filteredList.add(issue_date);
							 * filteredList.add(Period);
							 */
							 
	                 	 
	                     //break;
	                  }
	                  else
	                  {
							/*
							 * Iterator<issueBooksParam> itr = namesList.iterator(); while (itr.hasNext()) {
							 * issueBooksParam pp = itr.next(); if (!pp.equals(user)) {
							 * namesList.remove(pp); } }
							 */

	                	  
	                  }
	              }
				
				 
				for (int i = 0; i < namesList_output.size(); i++) {
					values.add(new String[] {namesList_output.get(i).bid ,
							namesList_output.get(i).username , 
							namesList_output.get(i).period, 
							namesList_output.get(i).issued_date});
				}

				TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				JTable table = new JTable(tableModel);
				// TestJFrame testJFrame = new TestJFrame();
				// table = new JTable(model);
				JScrollPane scrollPane = new JScrollPane(table);

				g.add(scrollPane);
				g.setSize(800, 400);
				g.setVisible(true);
				g.setLocationRelativeTo(null);

		//

			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			 g.setSize(800,400);
		        g.setLayout(null);
		        g.setVisible(true);
		        g.setLocationRelativeTo(null);    
		        g.setResizable(false);
	}
}
