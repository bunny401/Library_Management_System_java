package libraryProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


// class borrow books named as MyBooks
public class MyBooks {
public static void myBooks(String UID)
{
	JFrame g = new JFrame("Enter Details");
    JFrame f = new JFrame("My Books"); 
    //serializationdemo
    String allBooksFile = "serializationdemo.txt";
    String outputFile = "borrowBooksSerialization.txt";
    String issuedbooksFile = "allissuedbooksSerialization.txt";
	// following code reads into the file

	ArrayList list,i_list;
String user = UID;

	BooksParameters defNext = null;
	DefaultTableModel model = new DefaultTableModel();
	 
	try {
		ArrayList<issueBooksParam> alreadyissuedList = null;
		ArrayList<BooksParameters> namesList = new ArrayList<BooksParameters>();
		list = (ArrayList) SerializationLib.doDeserialize(allBooksFile);
		// System.out.println("def():\n --"+"\n |\n "+def);

		namesList = (ArrayList<BooksParameters>) list;
		System.out.println(System.lineSeparator());
		
		
		/*
		 * alreadyissuedList = new ArrayList<issueBooksParam>(); i_list = (ArrayList)
		 * SerializationLib.doDeserialize(issuedbooksFile);// issued books file
		 * alreadyissuedList = (ArrayList<issueBooksParam>) list; // username check.
		 * namesList.retainAll(alreadyissuedList); // find common elements
		 * namesList.removeAll(alreadyissuedList);
		 */
		

		ArrayList<String> columns = new ArrayList<String>();
		ArrayList<String[]> values = new ArrayList<String[]>();
		columns.add("BookID");
		columns.add("BookName");
		columns.add("Genre");
		columns.add("Price");

		for (int i = 0; i < namesList.size(); i++) {
			values.add(new String[] {namesList.get(i).book_id , namesList.get(i).bname ,  namesList.get(i).genre, namesList.get(i).price });
		}

		TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		JTable table = new JTable(tableModel);
		// TestJFrame testJFrame = new TestJFrame();
		// table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		f.add(scrollPane);
		f.setSize(800, 400);
		f.setVisible(true);
		f.setLocationRelativeTo(null);

//

	} catch (ClassNotFoundException | IOException e) {
		e.printStackTrace();
	}
	 
	//create submit window
	JLabel bidLabel,uidLabel,periodLabel,issueDateLabel;  
    bidLabel=new JLabel("Book ID(BID)"); 
    bidLabel.setBounds(30,15, 100,30); 
     
     
    uidLabel=new JLabel("Username");  
    uidLabel.setBounds(30,53, 100,30); 
     
//    bookNameLabel=new JLabel("Book Name");  
//    bookNameLabel.setBounds(30,90, 100,30); 
    
    periodLabel=new JLabel("Period(days)");  
    periodLabel.setBounds(30,90, 100,30); 
     
    issueDateLabel=new JLabel("Request Date(DD-MM-YYYY)");  
    issueDateLabel.setBounds(30,127, 150,30); 
     
    JTextField bidTextField = new JTextField();
    bidTextField.setBounds(130, 15, 200, 30);
     
     
    JTextField userNameTextField=new JTextField();
    userNameTextField.setBounds(130, 53, 200, 30);
    userNameTextField.setText(user);
    userNameTextField.setEditable(false);
    
//    JTextField bookNameTextField=new JTextField();
//    bookNameTextField.setBounds(130, 90, 200, 30);
    
    JTextField periodTextField=new JTextField();
    periodTextField.setBounds(130, 90, 200, 30);
     
    Calendar cal = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
    JTextField issueTextField=new JTextField();
    issueTextField.setBounds(180, 130, 150, 30); 
    issueTextField.setText(dateFormat.format(cal.getTime()));
    

    JButton btnIssue=new JButton("Submit");  
    btnIssue.setBounds(130,220,110,25);
    btnIssue.setBackground(Color.decode("#8E44AD"));
    btnIssue.setForeground(Color.WHITE);
    btnIssue.addActionListener(new ActionListener() {
         
    	//save the data in file
        public void actionPerformed(ActionEvent e)
        {
        String username = userNameTextField.getText();
        String bid = bidTextField.getText();
        String period = periodTextField.getText();
        String issued_date = issueTextField.getText();
        
        
        ArrayList<issueBooksParam> objlist = new ArrayList<issueBooksParam>();
        
        try {
        	boolean is_exists = false;
        	 ArrayList<String> booksIdsList = new ArrayList<>();
        	  // book id doesnot exists
    		  try {
    			  
    			  File myObj = new File("sdemo.txt"); Scanner myReader = new
    		  		  Scanner(myObj);
    		  		  
    		  		  Scanner sc = new Scanner(new File("sdemo.txt")); while
    		  		  (sc.hasNext()) { // pehlay sa issue hochuki hain jo books
    		  			  String _bid =sc.next(); 
    		  			  String _bname = sc.next(); 
    		  			  String _genc = sc.next();
    		  			  String _price = sc.next();
    		  			 // namesList.remove(_bid);
    		  			
    		  			 booksIdsList.add(_bid);
    
    		  		  
    		  		  } 
    		  		 myReader.close();
    		  		 if(!booksIdsList.contains(bid))
		  			  {
		  				JOptionPane.showMessageDialog(g, "This book id doesnot Exists");
		  				return;
		  			  //this book is issued
		  			  }
    		  		 }
    		  		  
    		  		  catch (FileNotFoundException ej) { System.out.println("An error occurred.");
    		  		  ej.printStackTrace(); }
        	
        	// omit those which are already issued

    		
  		  try { File myObj = new File("allissuedbooks.txt"); 
  		  Scanner myReader = new Scanner(myObj);
  		  
  		  Scanner sc = new Scanner(new File("allissuedbooks.txt")); while
  		  (sc.hasNext()) { // pehlay sa issue hochuki hain jo books
  			  String _username =sc.next(); 
  			  String _bid = sc.next(); 
  			  String _period = sc.next();
  			  String _issued_date = sc.next();
  			 // namesList.remove(_bid);
  			  if(_bid.contains(bid))
  			  {
  				JOptionPane.showMessageDialog(g, "This book is already issued to another user for "+ " "+ _period + "" +"days");
  				return;
  			  //this book is issued
  			  }
  		  
  		  
  		  } myReader.close(); }
  		  
  		  catch (FileNotFoundException ej) { System.out.println("An error occurred.");
  		  ej.printStackTrace(); }
  		 
  		
  		  		 

  		  
            File myObj = new File("borrowedbooks.txt");
            Scanner myReader = new Scanner(myObj);
                       
            Scanner sc = new Scanner(new File("borrowedbooks.txt"));
            while(sc.hasNext()){
                String _username = sc.next();
                String _bid = sc.next();
                String _period = sc.next();
                String _issued_date = sc.next();
              
             // record already exists check here4 if(username_input.equals(_username) && password_input.equals(_password))
                if(_username.equals(username) && _bid.equals(bid) )
                {
                	JOptionPane.showMessageDialog(g, "Book Record already Exists !");
                	//data already fed
                return;
                }
                else if(!_username.equals(username) && _bid.equals(bid))
                {
                	JOptionPane.showMessageDialog(g, "The Book is already borrowed for " + " "+_period + " "+"days ");
                	//data already fed
                return;
                }
              
                issueBooksParam obj = new issueBooksParam(_username, _bid, _period ,_issued_date);
               objlist.add(obj);
                }
            myReader.close();
        } 
          
        catch (FileNotFoundException ej) {
            System.out.println("An error occurred.");
            ej.printStackTrace();
          }
        
        
        
        FileWriter writer; 
		  try { writer = new FileWriter("borrowedbooks.txt", true);
		  writer.write((username) +" ");
		  writer.write((bid)+" ");
		  writer.write((period)+" "); // write new
		  writer.write((issued_date)+" "); // write new
		  writer.close();
		  }
		  catch (IOException e1) { // TODO
		    e1.printStackTrace(); }
        
        issueBooksParam obj2 = new issueBooksParam( username,bid, period,issued_date);
        objlist.add(obj2);
        try {
            SerializationLib.doSerialize(objlist, outputFile);
            JOptionPane.showMessageDialog(g, "Book borrowed Sucessfully !");
        } catch (IOException ev) {
            ev.printStackTrace();
            return;} 
        }  
        
        });

    g.add(periodLabel);
    g.add(issueDateLabel);
    g.add(btnIssue);
    g.add(bidLabel);
    g.add(uidLabel);
    g.add(userNameTextField);
    g.add(bidTextField);
    g.add(periodTextField);
    g.add(issueTextField);
    g.setSize(450,300);
    g.setLayout(null);
    g.setVisible(true);
    g.setLocationRelativeTo(null);
    g.setResizable(false);
}
}