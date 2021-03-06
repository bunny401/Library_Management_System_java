package libraryProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SearchBook {
	
	
	public static void searchBook() {

	JFrame g = new JFrame("Books Available");
	JFrame f = null;
	
	JLabel nameLabel=new JLabel("Enter Book name");  
     nameLabel.setBounds(20, 20, 200, 20); 

    
     JTextField nameTextField = new JTextField();
     nameTextField.setBounds(170, 20, 200, 20);
     
     JButton btnSearch = new JButton("Search");  
     btnSearch.setBounds(20, 50, 100, 20); 
     
     btnSearch.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e){
         String bookNameSearch = nameTextField.getText();
         String returnbooksFile = "serializationdemo.txt";
			ArrayList list; boolean found = false;
			try {
				ArrayList<BooksParameters> namesList = new ArrayList<BooksParameters>();
				ArrayList<BooksParameters> namesList_output = new ArrayList<BooksParameters>();
				list = (ArrayList) SerializationLib.doDeserialize(returnbooksFile);
				 

				namesList = (ArrayList<BooksParameters>) list;
				
				System.out.println(System.lineSeparator());

				ArrayList<String> columns = new ArrayList<String>();
				ArrayList<String[]> values = new ArrayList<String[]>();
				 
				columns.add("username");
				columns.add("book name");
				columns.add("period for");
				columns.add("request issued date");
				
				String bookid, username="", issue_date, Period;
				for (BooksParameters i : namesList){
					  //i_value++;
	                  if (i.bname.equals(bookNameSearch)){
	                      System.out.println(i);
	                  namesList_output.add(i);
	                     found = true;
	                  
	                  }
	                  else
	                  {
	                  }
	              }
				
				 
				for (int i = 0; i < namesList_output.size(); i++) {
					values.add(new String[] {namesList_output.get(i).book_id ,
							namesList_output.get(i).bname , 
							namesList_output.get(i).genre, 
							namesList_output.get(i).price});
				}

				TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				JTable table = new JTable(tableModel);
				// TestJFrame testJFrame = new TestJFrame();
				// table = new JTable(model);
				JScrollPane scrollPane = new JScrollPane(table);
System.out.println(values);
 JFrame f= new JFrame("Result");
				f.add(scrollPane);
				f.setSize(800, 400);
				f.setVisible(true);
				f.setLocationRelativeTo(null);

		//

			} catch (ClassNotFoundException | IOException ez) {
				ez.printStackTrace();
			}
			 
         }
     });
     
     g.add(btnSearch);
     g.add(nameLabel);
     g.add(nameTextField);
     g.setSize(800,400);
     g.setLayout(null);
     g.setVisible(true);
     g.setLocationRelativeTo(null);
      
    
}
}
