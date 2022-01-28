package libraryProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import libraryProject.BaseClass.ex;

public class ReturnBook {
	public static void returnBook() {
		JFrame g = new JFrame("All Issued Books Details");
		JFrame f = new JFrame("All Issued Books Details");

		String returnbooksFile = "allissuedbooksSerialization.txt";
		ArrayList list;
		boolean found = false;

		try {
			ArrayList<issueBooksParam> namesList = new ArrayList<issueBooksParam>();
			ArrayList<issueBooksParam> namesList_output = new ArrayList<issueBooksParam>();
			list = (ArrayList) SerializationLib.doDeserialize(returnbooksFile);// allissuedbooksSerialization
			namesList = (ArrayList<issueBooksParam>) list;

			System.out.println(System.lineSeparator());

			ArrayList<String> columns = new ArrayList<String>();
			ArrayList<String[]> values = new ArrayList<String[]>();
			columns.add("BookID");
			columns.add("Username");
			columns.add("period for");
			columns.add("issued date");

			for (int i = 0; i < namesList.size(); i++) {
				values.add(new String[] { namesList.get(i).bid, namesList.get(i).username, namesList.get(i).period,
						namesList.get(i).issued_date });
			}

			TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			JTable table = new JTable(tableModel);
			// TestJFrame testJFrame = new TestJFrame();
			// table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);

			g.add(scrollPane);
			g.setSize(800, 500);
			g.setVisible(true);
			g.setLocationRelativeTo(null);

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		JLabel issueIdLabel, returnDateLabel, issue_datelbl, periodlbl, unamelbl;
		issueIdLabel = new JLabel("Book ID");
		issueIdLabel.setBounds(30, 15, 100, 30);

		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		issue_datelbl = new JLabel("Issue Date(DD-MM-YYYY)");
		issue_datelbl.setBounds(30, 110, 150, 30);

		returnDateLabel = new JLabel("Return Date(DD-MM-YYYY)");
		returnDateLabel.setBounds(30, 70, 150, 30);

		periodlbl = new JLabel("Period");
		periodlbl.setBounds(30, 140, 150, 30);

		unamelbl = new JLabel("Username/Issuer");
		unamelbl.setBounds(30, 170, 150, 30);

		JTextField bookidTextField = new JTextField();
		bookidTextField.setBounds(110, 15, 200, 30);

		JTextField issueTextField = new JTextField();
		issueTextField.setBounds(180, 110, 130, 30);

		JTextField returnTextField = new JTextField();
		returnTextField.setBounds(180, 70, 130, 30);
		returnTextField.setText(dateFormat.format(cal.getTime()));

		JTextField periodtextfield = new JTextField();
		periodtextfield.setBounds(180, 140, 130, 30);

		JTextField unameTextField = new JTextField();
		unameTextField.setBounds(180, 180, 130, 30);

		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(130, 220, 130, 25);
		btnReturn.setBackground(Color.decode("#D4AC0D"));
		btnReturn.setForeground(Color.WHITE);
		btnReturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String book_id = bookidTextField.getText();
				String return_date = returnTextField.getText();
				String issue_date = issueTextField.getText();
				String Period = periodtextfield.getText();
				String username = unameTextField.getText();
				int Period_int = Integer.parseInt(Period);

				boolean is_exists = false;
				ArrayList<String> booksIdsList = new ArrayList<>();
				// book id doesnot exists
				try {

					File myObj = new File("sdemo.txt");
					Scanner myReader = new Scanner(myObj);

					Scanner sc = new Scanner(new File("sdemo.txt"));
					while (sc.hasNext()) { // pehlay sa issue hochuki hain jo books
						String _bid = sc.next();
						String _bname = sc.next();
						String _genc = sc.next();
						String _price = sc.next();
						// namesList.remove(_bid);

						booksIdsList.add(_bid);

					}
					myReader.close();
					if (!booksIdsList.contains(book_id)) {
						JOptionPane.showMessageDialog(g, "This book id doesnot Exists");
						return;
						// this book is issued
					}
				}

				catch (FileNotFoundException ej) {
					System.out.println("An error occurred.");
					ej.printStackTrace();
				}

				// Calculate Fine
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				boolean is_fine = false;
				long Total_fine = 0;

				LocalDate date1 = LocalDate.parse(issue_date, dtf);
				LocalDate date2 = LocalDate.parse(return_date, dtf);

				long daysBetween = ChronoUnit.DAYS.between(date1, date2);
				System.out.println("Days: " + daysBetween);

				if (daysBetween > Period_int) {
					// FINE CALCULATION
					int perday_fine = 10;
					long fine_days = daysBetween - Period_int;
					fine_days = fine_days * perday_fine;
					Total_fine = fine_days;
				}

				File newfile = null;
				ArrayList<issueBooksParam> objlist_ = new ArrayList<issueBooksParam>();

				// delete record from file
				try {

					File myObj = new File("allissuedbooks.txt");
					// 907yu
					Scanner myReader = new Scanner(myObj);
					// create file again.

					Scanner sc = new Scanner(new File("allissuedbooks.txt"));
					while (sc.hasNext()) {
						String _username = sc.next();
						String _bid = sc.next();
						String _period = sc.next();
						String _issued_date = sc.next();
						/*
						 * issueBooksParam obj = new issueBooksParam(_username, _bid, _period,
						 * _issued_date); objlist_.add(obj);
						 */

						if (_username.equals(username) && _bid.equals(book_id)) { // remove it or skip it

						} else { // add it
							issueBooksParam obj = new issueBooksParam(_username, _bid, _period, _issued_date);
							objlist_.add(obj);
						}

					}
					myReader.close(); // file data selection
					sc.close();
				}

				catch (FileNotFoundException ej) {
					System.out.println("An error occurred.");
					ej.printStackTrace();
				}

				// if (objlist_.size() > 0) {
				if (objlist_.size() > 0) {
					File oldfile = new File("allissuedbooks.txt");
					boolean status = oldfile.delete();// delete allissuedbooks
					FileWriter writer_;
					try {
						// create new file

						for (int i = 0; i < objlist_.size(); i++) {

							writer_ = new FileWriter("allissuedbooks.txt", true); // pending return re save
							writer_.write((objlist_.get(i).username) + " ");
							writer_.write((objlist_.get(i).bid) + " ");
							writer_.write((objlist_.get(i).period) + " ");
							writer_.write((objlist_.get(i).issued_date) + " "); // write new
							writer_.close();
						}
					}
					// file recreated
					catch (IOException e1) { // TODO
						e1.printStackTrace();
					}
					// }

				} else {
					File oldfile = new File("allissuedbooks.txt");
					boolean status = oldfile.delete();// delete allissuedbooks

					FileWriter writer_ = null;
					try {
						writer_ = new FileWriter("allissuedbooks.txt", true);
						writer_.write("");
						writer_.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // write new

				}

				File oldfile_S = new File("allissuedbooksSerialization.txt");
				// File newfile_S = new File("allissuedbooksSerializationOld.txt");
				// oldfile_S.renameTo(newfile_S);
				oldfile_S.delete();

				String outputFile_ = "allissuedbooksSerialization.txt";
				// Serialize the object into a file.
				try {
					SerializationLib.doSerialize(objlist_, outputFile_);

				} catch (IOException ev) {
					ev.printStackTrace();
					return;
				}

				if (Total_fine > 0) {
					JOptionPane.showMessageDialog(null, "Success!!! Book Returned with Fine : " + Total_fine);
					return;
				} else {
					JOptionPane.showMessageDialog(null, "Success!!!Book Returned with No Fine!");
				}

			}

		});
		f.add(unameTextField);
		f.add(unamelbl);
		f.add(issueIdLabel);
		f.add(periodtextfield);
		f.add(periodlbl);
		f.add(issue_datelbl);
		f.add(issueTextField);
		f.add(returnDateLabel);
		f.add(returnDateLabel);
		f.add(btnReturn);

		f.add(bookidTextField);
		f.add(returnTextField);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
	}
}
