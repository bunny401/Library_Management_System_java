package libraryProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public static void login() {
		
	     
	    JFrame f=new JFrame("Login");
	    
	    
	    JLabel usernameLabel,passwordLabel;  
	    
	    usernameLabel=new JLabel("Username");  
	    usernameLabel.setBounds(90,75, 100,30); 
	    usernameLabel.setForeground(Color.WHITE);
	    passwordLabel=new JLabel("Password");  
	    passwordLabel.setBounds(90,130, 100,30);    
	    passwordLabel.setForeground(Color.WHITE);
	     
	    JTextField usernameTextField = new JTextField(); 
	    usernameTextField.setBounds(170, 75, 200, 30);
	         
	    JPasswordField pwdPasswordField=new JPasswordField(); 
	    pwdPasswordField.setBounds(170, 130, 200, 30);
	       
	    JButton btnLogin=new JButton("Login");
	    btnLogin.setBounds(190,180,150,25);
	    btnLogin.setBackground(Color.decode("#2980B9"));
	    btnLogin.setForeground(Color.WHITE);
	    btnLogin.addActionListener(new ActionListener() {  
	         
	        public void actionPerformed(ActionEvent e){ 
	 
	        String username_input = usernameTextField.getText(); 
	        @SuppressWarnings("deprecation")
			String password_input = pwdPasswordField.getText(); 
	         
	        if(username_input.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter username"); 
	        } 
	        else if(password_input.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter password"); 
	        }
	        else { 
	            
	           // Connection connection=DbConnection.connect();  
	            try
	            {
	            	
	            	File myObj = new File("users.txt");
	                Scanner myReader = new Scanner(myObj);
	                boolean user_found = false;
	                           
	                Scanner sc = new Scanner(new File("users.txt"));
	                while(sc.hasNext()){
	                	String name=sc.next(); 
	                    String _username = sc.next();
	                    String _password = sc.next();
	                    String role = sc.next();
	                     
	                    
	                  if(username_input.equals(_username) && password_input.equals(_password))
	                  {
	                	  user_found = true;
	                	  if(role.equals("admin"))
	                	  {
	                		  f.dispose();
	    	            	  AdminPanel.admin_menu();
	                	  }
	                	  else
	                	  {
	                		  f.dispose();
	 	            		 UserPanel.user_menu(username_input);
	                	  }
	                  }
	                  else {}
	                   
	                    }//end while loop.
	            
	                myReader.close();
	                
	           
	              if(user_found==false) { 
	                  System.out.print("No user");  
	                  
	                  JOptionPane.showMessageDialog(null,"Wrong Username/Password!"); 
	 
	              }
	            	  

	            }
	            catch (Exception ex) {
	                 ex.printStackTrace();
	        }
	        }
	    }               
	    });
	   
		
	    JLabel img=new JLabel(new ImageIcon("src/splashImg.jpg"));
		f.add(img);
	    f.add(pwdPasswordField); 
	    f.add(btnLogin);
	    f.add(usernameTextField);  
	    f.add(usernameLabel);  
	    f.add(passwordLabel); 
	    f.setResizable(false);
 	    f.getContentPane().setBackground( Color.decode("#2E4053") );
	    f.setSize(500,380);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
	}
}
