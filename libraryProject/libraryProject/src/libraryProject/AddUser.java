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
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddUser {
public static void addUser() {
	 JFrame g = new JFrame("Enter User Details"); 
     
	 
     
     JLabel nameLabel,usernameLabel,passwordLabel;  
     
     nameLabel=new JLabel("Name");  
     nameLabel.setBounds(30,15, 100,30); 
     
     usernameLabel=new JLabel("Username");  
     usernameLabel.setBounds(30,50, 100,30); 
      
     passwordLabel=new JLabel("Password");  
     passwordLabel.setBounds(30,85, 100,30); 
    
     JTextField nameTextField = new JTextField();
     nameTextField.setBounds(110, 15, 200, 30);
      
     
     JTextField usernameTextField = new JTextField();
     usernameTextField.setBounds(110, 50, 200, 30);
      
     
     JPasswordField pwdPasswordField=new JPasswordField();
     pwdPasswordField.setBounds(110, 85, 200, 30);
     
     JRadioButton adminRB = new JRadioButton("Admin");
     adminRB.setBounds(55, 130, 200,30);
     
     JRadioButton userRB = new JRadioButton("User");
     userRB.setBounds(130, 130, 200,30);
     
     ButtonGroup bg=new ButtonGroup();    
     bg.add(adminRB);bg.add(userRB);  
      
                      
     JButton btnCreate=new JButton("Create");
     btnCreate.setBounds(130,180,100,25);
     btnCreate.setBackground(Color.decode("#1B4F72"));
     btnCreate.setForeground(Color.WHITE);
     btnCreate.addActionListener(new ActionListener() {
          
         public void actionPerformed(ActionEvent e){
         String name=nameTextField.getText();
         String username = usernameTextField.getText();
         @SuppressWarnings("deprecation")
		String password = pwdPasswordField.getText();
         Boolean admin = false;
         String role="nil";
          
         if(username.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter username"); 
	            return;
	        } 
	       if(password.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter password"); 
	           return;
	        }
	     
         if(adminRB.isSelected()) {
             admin=true;
             role="Admin";
         }
         else   if(userRB.isSelected()) 
         {
        	 role="user";
        //user
         }
         ArrayList<UsersParam> objlist = new ArrayList<UsersParam>();

         
         try {
             File myObj = new File("users.txt");
             Scanner myReader = new Scanner(myObj);
             
             Scanner sc = new Scanner(new File("users.txt"));
             while(sc.hasNext()){
            	 String name_p = sc.next();
                 String username_p = sc.next();
                 String password_p = sc.next();
                 String role_p = sc.next();
               
               
                UsersParam obj = new UsersParam(name_p, username_p, password_p, role_p);
                objlist.add(obj);
                
             }
             
             
             myReader.close();
           } catch (FileNotFoundException ej) {
             System.out.println("An error occurred.");
             ej.printStackTrace();
           }
         
         
         UsersParam obj2 = new UsersParam(name,username,password, role);
         objlist.add(obj2);
        // objlist.add(obj2);
        
         
         
			
			  FileWriter writer; 
			  try { writer = new FileWriter("users.txt", true);
			  writer.write((name) +" ");
			  writer.write((username) +" ");
			  writer.write((password)+" ");
			  writer.write((role)+" "); // write new
			  writer.close(); }
			  catch (IOException e1) { // TODO
			    e1.printStackTrace(); }
			 
         
         String outputFile="usersSerialization.txt";
      // Serialize the object into a file.
         try {
             SerializationLib.doSerialize(objlist, outputFile);
             JOptionPane.showMessageDialog(g, "User Added Sucessfully !");
         } catch (IOException ev) {
             ev.printStackTrace();
             return;
         } 
         
         }
          
     });
          
      
         g.add(btnCreate);
         g.add(userRB);
         g.add(adminRB);
         g.add(nameLabel);
         g.add(usernameLabel);
         g.add(passwordLabel);
         g.add(usernameTextField);
         g.add(pwdPasswordField);
         g.add(nameTextField);
         g.setSize(450,300);
         g.setLayout(null);
         g.setVisible(true);
         g.setLocationRelativeTo(null);
      
      
}
}
