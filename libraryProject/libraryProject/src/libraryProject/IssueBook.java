package libraryProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class IssueBook {
	public static void issueBook() {

		JFrame g = new JFrame("Enter Details");
		JFrame f = new JFrame("issue books Requests");
		// serializationdemo
		String allissuedrequestBooksFile = "borrowBooksSerialization.txt";
		String outputFile = "allissuedbooksSerialization.txt";
		// following code reads into the file

		ArrayList list, i_list;

		// BooksParameters defNext = null;
		DefaultTableModel model = new DefaultTableModel();

		try {

			ArrayList<issueBooksParam> alreadyissuedList = null;
			ArrayList<issueBooksParam> namesList = new ArrayList<issueBooksParam>();
			list = (ArrayList) SerializationLib.doDeserialize(allissuedrequestBooksFile);// borrowed books file

			namesList = (ArrayList<issueBooksParam>) list;
			// f book is already issued then dont show its Request again. read from issued
			// ones

			
			 /* File file = new File(outputFile); if (file.exists()) { alreadyissuedList =
			  new ArrayList<issueBooksParam>(); i_list = (ArrayList)
			  SerializationLib.doDeserialize(outputFile);// issued books file
			  alreadyissuedList = (ArrayList<issueBooksParam>) list; // username check.
			  namesList.retainAll(alreadyissuedList); // find common elements
			  namesList.removeAll(alreadyissuedList);*/
			  
			  //}
			 

			ArrayList<String> columns = new ArrayList<String>();
			ArrayList<String[]> values = new ArrayList<String[]>();
			columns.add("username");
			columns.add("bid");
			columns.add("period for");
			columns.add("request issued date");
			// columns.add("Action");
			JButton btnOK = new JButton("Issue Book Requests");
			// JButton btn[];
			for (int i = 0; i < namesList.size(); i++) {
				// color those who are issued
				values.add(new String[] { namesList.get(i).username, namesList.get(i).bid, namesList.get(i).period,
						namesList.get(i).issued_date, });
			}

			TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			JTable table = new JTable(tableModel);
			// TestJFrame testJFrame = new TestJFrame();
			// table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);

			f.add(scrollPane);
			// f.add(btnOK);
			f.setSize(800, 400);
			f.setVisible(true);
			f.setLocationRelativeTo(null);

//

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		JLabel bidLabel, uidLabel, periodLabel, issueDateLabel;
		bidLabel = new JLabel("Book ID(BID)");
		bidLabel.setBounds(30, 15, 100, 30);

		uidLabel = new JLabel("Username");
		uidLabel.setBounds(30, 53, 100, 30);

		periodLabel = new JLabel("Period(days)");
		periodLabel.setBounds(30, 90, 100, 30);

		issueDateLabel = new JLabel("Issued Date(DD-MM-YYYY)");
		issueDateLabel.setBounds(30, 127, 150, 30);

		JTextField bidTextField = new JTextField();
		bidTextField.setBounds(130, 15, 200, 30);

		JTextField userNameTextField = new JTextField();
		userNameTextField.setBounds(130, 53, 200, 30);

		JTextField periodTextField = new JTextField();
		periodTextField.setBounds(130, 90, 200, 30);

		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		JTextField issueTextField = new JTextField();
		issueTextField.setBounds(180, 130, 150, 30);
		issueTextField.setText(dateFormat.format(cal.getTime()));

		JButton btnIssue = new JButton("Submit");
		btnIssue.setBounds(130, 220, 110, 25);
		btnIssue.setBackground(Color.decode("#8E44AD"));
		btnIssue.setForeground(Color.WHITE);

		btnIssue.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String username = userNameTextField.getText();
				String bid = bidTextField.getText();
				String period = periodTextField.getText();
				String issued_date = issueTextField.getText(); // String
				// bookName=bookNameTextField.getText();
				int period_int = 0;
				int bid_int = 0;

				boolean isPeriod = true;
				boolean isBid = true;
				try {
					period_int = Integer.parseInt(period);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please Enter Period in numbers!");
					isPeriod = false;
				}

				/*
				 * try { bid_int=Integer.parseInt(bid); } catch(NumberFormatException ex) {
				 * JOptionPane.showMessageDialog(null,"Please Enter bid in number!");
				 * isBid=false; }
				 */

				if (isPeriod == true && isBid == true) {

					// add to file //allissuedbooks.txt }
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
					
					
					
					

					ArrayList<issueBooksParam> objlist = new ArrayList<issueBooksParam>();

					try {
						File myObj = new File("allissuedbooks.txt");
						Scanner myReader = new Scanner(myObj);

						Scanner sc = new Scanner(new File("allissuedbooks.txt"));
						while (sc.hasNext()) {
							// pehlay sa issue hochuki hain jo books
							String _username = sc.next();
							String _bid = sc.next();
							String _period = sc.next();
							String _issued_date = sc.next();

							if (_username.equals(username) && _bid.equals(bid)) {
								JOptionPane.showMessageDialog(g, "Book already issued	 !");
								// data already fed
								return;
							}
							if (_username.equals(username) &&(_bid.contains(bid))) {
								// remove it or skip it

							} else {
								// add them
								issueBooksParam obj = new issueBooksParam(_username, _bid, _period, _issued_date);
								objlist.add(obj);
							}

						}
						myReader.close();
					}

					catch (FileNotFoundException ej) {
						System.out.println("An error occurred.");
						ej.printStackTrace();
					}

					// now add to text file
					FileWriter writer;
					try {
						writer = new FileWriter("allissuedbooks.txt", true);
						writer.write((username) + " ");
						writer.write((bid) + " ");
						writer.write((period) + " "); // write new
						writer.write((issued_date) + " "); // write new
						writer.close();
					} catch (IOException e1) { // TODO
						e1.printStackTrace();
					}

					issueBooksParam obj2 = new issueBooksParam(username, bid, period, issued_date);
					objlist.add(obj2);
					try {
						SerializationLib.doSerialize(objlist, outputFile);
						// JOptionPane.showMessageDialog(g, "Book issued Sucessfully !");
					} catch (IOException ev) {
						ev.printStackTrace();
						return;
					}

				}

				// Delete from borrowed books file

				// delete record from file

				File newfile = null;
				File newfile_S = null;
				ArrayList<issueBooksParam> objlist_ = new ArrayList<issueBooksParam>();
				ArrayList<issueBooksParam> objlistb_ = new ArrayList<issueBooksParam>();
				try {

					File myObj = new File("borrowedbooks.txt");
					// 907yu
					Scanner myReader = new Scanner(myObj);
					// create file again.

					Scanner sc = new Scanner(new File("borrowedbooks.txt"));
					while (sc.hasNext()) {
						String _username = sc.next();
						String _bid = sc.next();
						String _period = sc.next();
						String _issued_date = sc.next();

						/*
						 * issueBooksParam obj = new issueBooksParam(_username, _bid, _period,
						 * _issued_date); objlistb_.add(obj);
						 */

						if (_username.equals(username) && _bid.equals(bid)) { // remove it or skip it

						} else { // add it
							issueBooksParam obj = new issueBooksParam(_username, _bid, _period, _issued_date);
							objlistb_.add(obj);
							try {
								FileWriter writer_;
								writer_ = new FileWriter("borrowedbooksNew.txt", true);
								writer_.write((_username) + " ");
								writer_.write((_bid) + " ");
								writer_.write((_period) + " ");
								writer_.write((_issued_date) + " ");
								writer_.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}

						}

					}
					myReader.close(); // file data selection
					sc.close();

				}

				catch (FileNotFoundException ej) {
					System.out.println("An error occurred.");
					ej.printStackTrace();
				}

				// if (new_file.exists()) {
				File new_file = new File("borrowedbooksNew.txt");
				File oldfile = new File("borrowedbooks.txt");
				if (new_file.exists()) {
					
					boolean sttaus = oldfile.delete();
					if (sttaus == true) {

						boolean result = new_file.renameTo(oldfile);
						if (result == true) {
							System.out.println("success rename");
						}

					}
				}
				else
				{
					PrintWriter writer;
					try {
						writer = new PrintWriter("borrowedbooks.txt");
						writer.print("");
						writer.flush();
						writer.close();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

				// You should create a temporary file in which you write the data.
				// After that you can delete the original file, then rename the temporary file
				// to the original

				// }

				File oldfile_B = new File("borrowBooksSerialization.txt");
				File newfile_B = new File("borrowBooksSerializationOld.txt");
				oldfile_B.renameTo(newfile_B);
				oldfile_B.delete();

				String outputFileB_ = "borrowBooksSerialization.txt";
				// Serialize the object into a file.
				try {
					SerializationLib.doSerialize(objlistb_, outputFileB_);
					JOptionPane.showMessageDialog(g, "Book issued Sucessfully !");
				} catch (IOException ev) {
					ev.printStackTrace();
					return;
				}

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
		g.setSize(450, 300);
		g.setLayout(null);
		g.setVisible(true);
		g.setLocationRelativeTo(null);
		g.setResizable(false);
	}
}
