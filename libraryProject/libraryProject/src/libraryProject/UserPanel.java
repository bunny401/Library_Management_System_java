package libraryProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserPanel extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
			
		 //USE OF GRAPHICS CLASS
			/*
			 * Graphics2D g2d = (Graphics2D) g; FontMetrics fm = g2d.getFontMetrics();
			 * g2d.translate(0, fm.getAscent()); g2d.drawString("hello", 0, 0);
			 * g2d.translate(0, 0);
			 */
		
		  Graphics2D g2 = (Graphics2D) g;
		  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		  RenderingHints.VALUE_ANTIALIAS_ON); g2.setColor(Color.WHITE);
		  
		  g2.drawString(" Graphics Class ! Library Management System ", 10,20);
		 
	}

	public static void user_menu(String UID) {
	    
	    
		UserPanel m=new UserPanel();  
		JFrame frame = new JFrame("User Panel");
		
		
        JButton btnViewBooks,btnborrowbooks, btnReturnbooks, btnmyBooks,btnLogout,btnSearchBook;
        btnViewBooks = new JButton("View all Books");
        btnViewBooks.setBackground(Color.decode("#ABEBC6"));
	    btnViewBooks.setForeground(Color.BLACK);
	    btnViewBooks.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	             
	           ViewBooks.ViewBook();            
	    }
	    }
	    );
	    
	    btnborrowbooks = new JButton("Borrow Books");
	    btnborrowbooks.setBackground(Color.decode("#ABEBC6"));
	    btnborrowbooks.setForeground(Color.BLACK);
	    btnborrowbooks.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	
	        	MyBooks.myBooks(UID);
	                 
	    }
	    }
	    );
		/*
		 * btnReturnbooks = new JButton("Return Books");
		 * btnReturnbooks.setBackground(Color.decode("#ABEBC6"));
		 * btnReturnbooks.setForeground(Color.BLACK);
		 * btnReturnbooks.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e){ ReturnBookRequest.returnBookRequest(UID); } }
		 * );
		 */
	    btnSearchBook = new JButton("Search Books");
	    btnSearchBook.setBackground(Color.decode("#ABEBC6"));
	    btnSearchBook.setForeground(Color.BLACK);
	    btnSearchBook.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	SearchBook.searchBook();
	    }
	    }
	    );
	    
	    btnmyBooks = new JButton("My Books");
	    btnmyBooks.setBackground(Color.decode("#ABEBC6"));
	    btnmyBooks.setForeground(Color.BLACK);
	    btnmyBooks.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	UserIssuedBooks.userIssuedBooks(UID);
	    }
	    }
	    );
	    
	    //
	    
	    
	    btnLogout = new JButton("Logout");
	    btnLogout.setBackground(Color.decode("#ABEBC6"));
	    btnLogout.setForeground(Color.BLACK);
	    btnLogout.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	frame.dispose();
	        	Login.login();
	                 
	    }
	    }
	    );
        
	    frame.getContentPane().setBackground( Color.decode("#196F3D") );
        frame.add(btnViewBooks);
        frame.add(btnborrowbooks);
        frame.add(btnSearchBook);
        frame.add(btnmyBooks);
        frame.add(btnLogout);
        frame.setLayout(new GridLayout(2,3));
        frame.setSize(600,500);  
        frame.setVisible(true);
        
        
        frame.getContentPane().add(new UserPanel());
	   /* JFrame f=new JFrame("User Functions"); 
	    	    
	    JButton btnViewBooks=new JButton("View all Books");
	    btnViewBooks.setBounds(20,20,160,75);
	    btnViewBooks.setBackground(Color.WHITE);
	    btnViewBooks.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	             
	           ViewBooks.ViewBook();            
	    }
	    }
	    );
	     
	    JButton btnMyBooks=new JButton("Borrow Books");
	    btnMyBooks.setBounds(230,20,160,75);
	    btnMyBooks.setBackground(Color.WHITE);
	    //btnMyBooks.setForeground(Color.);
	    btnMyBooks.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	
	        	MyBooks.myBooks(UID);
	                 
	    }
	    }
	    );
	    
	    JButton btnborrow=new JButton("My Book");
	    btnborrow.setBounds(130,20,120,75);
	    btnborrow.setBackground(Color.WHITE);
	    //btnMyBooks.setForeground(Color.);
	    btnborrow.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	
	        	Borrowbook.borrowbook();
	                 
	    }
	    }
	    );
	    
	    JButton btnReturnBooks=new JButton("Return Book");
	    btnReturnBooks.setBounds(20,120,160,75);
	    btnReturnBooks.setBackground(Color.WHITE);
	    //btnMyBooks.setForeground(Color.);	
	    btnReturnBooks.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	
	        	//MyBooks.myBooks(UID);
	                 
	    }
	    }
	    );
	    
	    JButton btnLogout=new JButton("Logout");
	    btnLogout.setBounds(20,120,160,75);
	    btnLogout.setBackground(Color.WHITE);
	    btnLogout.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	f.dispose();
	        	Login.login();
	                 
	    }
	    }
	    );
	     
	     
	     
	    f.add(btnMyBooks); 
	    f.add(btnViewBooks); 
	   // f.getContentPane().add(btnborrowBooks); 
	    f.add(btnborrow); 
	    f.add(btnLogout);
	    f.getContentPane().setBackground( Color.decode("#3B5998") );
	    f.setSize(700,300);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.revalidate();
	    f.setLocationRelativeTo(null);
	    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    f.setResizable(false); 
	    }*/
}
}
