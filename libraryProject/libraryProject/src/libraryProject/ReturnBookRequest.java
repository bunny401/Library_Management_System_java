package libraryProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ReturnBookRequest {

	public static void returnBookRequest(String UID)
	{
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
				 
				columns.add("username");
				columns.add("bid");
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
			/*
			 * g.setSize(800,400); g.setLayout(null); g.setVisible(true);
			 * g.setLocationRelativeTo(null); g.setResizable(false);
			 */
	
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		JLabel bookIDlbl,usernamelbl,returndatelbl;  
		bookIDlbl=new JLabel("Book ID");  
		bookIDlbl.setBounds(30,15, 100,30); 
	     
	     
		usernamelbl=new JLabel("User Name");  
		usernamelbl.setBounds(30,53, 100,30); 
	     
		returndatelbl=new JLabel("Return Date");  
		returndatelbl.setBounds(30,90, 100,30); 
	     
	    
	    JTextField bookid_tf = new JTextField();
	    bookid_tf.setBounds(110, 15, 200, 30);
	     
	    
	    JTextField userTextField=new JTextField();
	    userTextField.setBounds(110, 53, 200, 30);
	    
	    JTextField returnTextField=new JTextField();
	    returnTextField.setBounds(110, 90, 200, 30);
		
		    returnTextField.setText(dateFormat.format(cal.getTime()));
		    
		    JButton btnReturn=new JButton("Return");
		    btnReturn.setBounds(130,130,90,25);
		    btnReturn.setBackground(Color.GREEN);
		    btnReturn.setForeground(Color.WHITE);
		    btnReturn.addActionListener(new ActionListener() {
		         
		        public void actionPerformed(ActionEvent e){
		        
		        	 
		     String    bookid = bookid_tf.getText();
		     String   username = userTextField.getText();
		     String   returnDate = returnTextField.getText();
		     ArrayList<BooksParameters> objlist = new ArrayList<BooksParameters>();
		     
		     try {
		         File myObj = new File("ReturnbooksRequests.txt");
		         Scanner myReader = new Scanner(myObj);
		         
		     Scanner sc = new Scanner(new File("ReturnbooksRequests.txt"));
	         while(sc.hasNext()){
	             String bookid_ = sc.next();
	             String username_ = sc.next();
	             String returnDate_ = sc.next();
	           
	           
	            BooksParameters obj = new BooksParameters("",bookid_, username_, returnDate_
	            		);
	            objlist.add(obj);
	            
	         }
	         myReader.close();
		       } catch (FileNotFoundException ej) {
		         System.out.println("An error occurred.");
		         ej.printStackTrace();
		       }
	         
		     BooksParameters obj2 = new BooksParameters("",bookid, username, returnDate);
	         objlist.add(obj2);
	         
	         FileWriter writer; 
			  try { writer = new FileWriter("ReturnbooksRequests.txt", true);
			  writer.write((bookid) +" ");
			  writer.write((username)+" ");
			  writer.write((returnDate)+" "); // write new
			  writer.close(); }
			  catch (IOException e1) { // TODO
			    e1.printStackTrace(); }
			  
			  String outputFile="ReturnbooksReqserialization.txt";
		      // Serialize the object into a file.
		         try {
		             SerializationLib.doSerialize(objlist, outputFile);
		         } catch (IOException ev) {
		             ev.printStackTrace();
		             return;
		         } 
		         
		     
		        }

		        });
		    g.add(returndatelbl);
		    g.add(usernamelbl);
		    g.add(bookIDlbl);
	        g.add(btnReturn );
	        g.add(userTextField);
	        g.add(bookid_tf );
	        g.add(returnTextField);
	        g.setSize(800,400);
	        g.setLayout(null);
	        
	        g.setVisible(true);
	        g.setLocationRelativeTo(null);    
	        g.setResizable(false);
	}
}
