package libraryProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;  

public class AdminPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		// super.paintComponent(g);
		
		
		 //USE OF GRAPHICS CLASS

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.WHITE);

		g2.drawString("Library Management System", 40, 20);
	}

	public static void admin_menu() {

		
		 JMenu menu, submenu;  
         JMenuItem logoutmenu,viewBookmenu,addBookmenu,addusermenu,approveissuebookmenu, viewusersmenu,returnbooksmenu,viewissuebookmenu;  
         
         JFrame f = new JFrame("Admin Functions");
        
         
         JMenuBar mb=new JMenuBar();  
         menu=new JMenu("Menu");  
 
         logoutmenu=new JMenuItem("LogOut"); 
         viewBookmenu = new JMenuItem("View Books");
         addBookmenu = new JMenuItem("Add Books");
         addusermenu = new JMenuItem("Add Users");
         approveissuebookmenu = new JMenuItem("Issue Books");
         viewusersmenu = new JMenuItem("Add Users");
         returnbooksmenu = new JMenuItem("Return Books");
         viewissuebookmenu = new JMenuItem("View Issued Books");
         
        // i2=new JMenuItem("Item 2");  
         
         
         menu.add(viewBookmenu);
         menu.add(addBookmenu);  menu.add(addusermenu); menu.add(approveissuebookmenu);
         menu.add(viewusersmenu);menu.add(returnbooksmenu);menu.add(viewissuebookmenu);menu.add(logoutmenu);
         
         //menu.add(i2); menu.add(i3);  
       //  submenu.add(i4); submenu.add(i5);  menu.add(submenu);  
         mb.add(menu);  
         f.setJMenuBar(mb);  
         f.setSize(400,400);  
         f.setLayout(null);  
         f.setVisible(true);  
        
         logoutmenu.addActionListener(new ActionListener() {
        	    @Override
        	    public void actionPerformed(ActionEvent actionEvent) {
        	    	
        	      // Logout
        	    	f.dispose();
    				Login.login();
        	    }
        	});
		
         viewBookmenu.addActionListener(new ActionListener() {
     	    @Override
     	    public void actionPerformed(ActionEvent actionEvent) {
     	    	
     	    	ViewBooks.ViewBook();
     	    }
     	});
         //addBookmenu,addusermenu,approveissuebookmenu, viewusersmenu,returnbooksmenu,viewissuebookmenu;  
         addBookmenu.addActionListener(new ActionListener() {
      	    @Override
      	    public void actionPerformed(ActionEvent actionEvent) {
      	    	
      	    	AddBook.addBook();
      	    }
      	});
         addusermenu.addActionListener(new ActionListener() {
       	    @Override
       	    public void actionPerformed(ActionEvent actionEvent) {
       	    	
       	    	AddUser.addUser();
       	    }
       	});
         approveissuebookmenu.addActionListener(new ActionListener() {
        	    @Override
        	    public void actionPerformed(ActionEvent actionEvent) {
        	    	
        	    	IssueBook.issueBook();
        	    }
        	});
         viewusersmenu.addActionListener(new ActionListener() {
     	    @Override
     	    public void actionPerformed(ActionEvent actionEvent) {
     	    	
     	    	ViewUsers.ViewUser();
     	    }
     	});
         returnbooksmenu.addActionListener(new ActionListener() {
      	    @Override
      	    public void actionPerformed(ActionEvent actionEvent) {
      	    	
      	    	ReturnBook.returnBook();
      	    }
      	});
         viewissuebookmenu.addActionListener(new ActionListener() {
       	    @Override
       	    public void actionPerformed(ActionEvent actionEvent) {
       	    	
       	    	ViewIssuedBooks.issuedBooks();
       	    }
       	});
		
		f.getContentPane().add(new AdminPanel());
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

		JButton btnViewBooks = new JButton("View Books");
		btnViewBooks.setBackground(Color.decode("#ABEBC6"));
		btnViewBooks.setForeground(Color.BLACK);
		btnViewBooks.setBounds(90, 50, 170, 75);

		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooks.ViewBook();
			}
		});

		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.setBounds(90, 270, 170, 75);
		btnViewUsers.setBackground(Color.decode("#ABEBC6"));
		btnViewUsers.setForeground(Color.BLACK);
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewUsers.ViewUser();
			}
		});

		JButton btnViewIssBooks = new JButton("View Issued Books");
		btnViewIssBooks.setBounds(90, 375, 170, 75);
		btnViewIssBooks.setBackground(Color.decode("#ABEBC6"));
		btnViewIssBooks.setForeground(Color.BLACK);
		btnViewIssBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ViewIssuedBooks.issuedBooks();

			}
		});
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(290, 375, 170, 75);
		btnLogout.setBackground(Color.red);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Login.login();
			}
		});
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(90, 155, 170, 75);
		btnAddUser.setBackground(Color.decode("#ABEBC6"));
		btnAddUser.setForeground(Color.BLACK);
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser.addUser();

			}
		});

		JButton btnAddBooks = new JButton("Add Book");
		btnAddBooks.setBounds(290, 50, 170, 75);
		btnAddBooks.setBackground(Color.decode("#ABEBC6"));
		btnAddBooks.setForeground(Color.BLACK);
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook.addBook();
			}
		});

		JButton btnIssueBooks = new JButton("Issue Books");
		btnIssueBooks.setBounds(290, 155, 170, 75);
		btnIssueBooks.setBackground(Color.decode("#ABEBC6"));
		btnIssueBooks.setForeground(Color.BLACK);
		btnIssueBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBook.issueBook();

			}
		});

		JButton btnReturnBook = new JButton("Return Books");
		btnReturnBook.setBounds(290, 270, 170, 75);
		btnReturnBook.setBackground(Color.decode("#ABEBC6"));
		btnReturnBook.setForeground(Color.BLACK);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ReturnBook.returnBook();
			}
		});

		f.add(btnReturnBook);
		f.add(btnIssueBooks);
		f.add(btnAddBooks);
		f.add(btnViewIssBooks);
		f.add(btnViewUsers);
		f.add(btnViewBooks);
		f.add(btnAddUser);
		f.add(btnLogout);
		f.getContentPane().setBackground(Color.decode("#196F3D"));
		f.setSize(600, 600);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		// f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setResizable(false);
	}
}
