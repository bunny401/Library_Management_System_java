package libraryProject;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddBook implements Serializable{
	
public static void addBook() {
	 
    JFrame g = new JFrame("Enter Book Details");
    
    
    JLabel bNameLabel,genreLabel,priceLabel, Book_idlbl;  
    
     
    Book_idlbl=new JLabel("Book ID(BID)"); 
    Book_idlbl.setBounds(30,15, 100,30);
    		  
    		  
    bNameLabel=new JLabel("Book Name");
    bNameLabel.setBounds(30,53, 100,30);
    		  
    genreLabel=new JLabel("Genre ");
    genreLabel.setBounds(30,90, 100,30);
    		  
    priceLabel=new JLabel("Price");
    priceLabel.setBounds(30,127, 150,30);
    		  
    		  JTextField bidTextField = new JTextField(); 
    		  bidTextField.setBounds(130, 15, 200, 30);
    		  
    		  
    		  JTextField bNameTextField=new JTextField();
    		  bNameTextField.setBounds(130, 53, 200, 30);
    		 
    		  
    		  JTextField genreTextField=new JTextField();
    		  genreTextField.setBounds(130,90, 200, 30);
    		  
    		  JTextField priceTextField=new JTextField();
    		  priceTextField.setBounds(130,
    		  130, 150, 30);
    		  
             
     
    JButton btnAddBook=new JButton("Submit");
    btnAddBook.setBounds(130,220,110,25);
    btnAddBook.setBackground(Color.GREEN);
    btnAddBook.setForeground(Color.WHITE);
    btnAddBook.addActionListener(new ActionListener() {
         
        public void actionPerformed(ActionEvent e){
        
        	  String book_id = bidTextField.getText();	 
        	     String    bname = bNameTextField.getText();
        	     String   genre = genreTextField.getText();
        	     String   price = priceTextField.getText();
        	
        	 if(book_id.equals("")) 
 	        {
 	            JOptionPane.showMessageDialog(null,"Please enter Book ID"); 
 	            return;
 	        } 
 	       if(bname.equals("")) 
 	        {
 	            JOptionPane.showMessageDialog(null,"Please enter Book Name"); 
 	           return;
 	        }
 	      if(genre.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter genre"); 
	            return;
	        }
 	     if(price.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter price"); 
	            return;
	        }
     	 
      
     ArrayList<BooksParameters> objlist = new ArrayList<BooksParameters>();

     
     try {
         File myObj = new File("sdemo.txt");
         Scanner myReader = new Scanner(myObj);
         
				/*
				 * while (myReader.hasNextLine()) { String data = myReader.nextLine(); //
				 * System.out.println(data); }
				 */
         
         Scanner sc = new Scanner(new File("sdemo.txt"));
         while(sc.hasNext()){
        	 String book_id_ = sc.next();
             String book_name = sc.next();
             String book_genre = sc.next();
             String book_price = sc.next();
           
           
            BooksParameters obj = new BooksParameters(book_id_, book_name, book_genre, book_price);
            objlist.add(obj);
            
         }
         
         
         myReader.close();
       } catch (FileNotFoundException ej) {
         System.out.println("An error occurred.");
         ej.printStackTrace();
       }
     
    

     
     BooksParameters obj2 = new BooksParameters(book_id,bname, genre, price);
         objlist.add(obj2);
        // objlist.add(obj2);
        
         
         
			
			  FileWriter writer; 
			  try { writer = new FileWriter("sdemo.txt", true);
			  writer.write((book_id) +" ");
			  writer.write((bname) +" ");
			  writer.write((genre)+" ");
			  writer.write((price)+" "); // write new
			  writer.close(); }
			  catch (IOException e1) { // TODO
			    e1.printStackTrace(); }
			 
         
         String outputFile="serializationdemo.txt";
      // Serialize the object into a file.
         try {
             SerializationLib.doSerialize(objlist, outputFile);
             JOptionPane.showMessageDialog(g, "Data Added Sucessfully !");
         } catch (IOException ev) {
             ev.printStackTrace();
             return;
         } 
			
       
        }
         
    });
         
        g.add(priceLabel);
        g.add(btnAddBook);
        g.add(Book_idlbl);     
        g.add(bNameLabel);
        g.add(genreLabel);
        g.add(bidTextField);
        g.add(bNameTextField);
        g.add(genreTextField);
        g.add(priceTextField);
        g.setSize(450,300);
        g.setLayout(null);
        g.setVisible(true);
        g.setLocationRelativeTo(null);
        g.setResizable(false);
                
}
 


}
