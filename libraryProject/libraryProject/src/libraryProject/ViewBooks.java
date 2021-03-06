package libraryProject;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ViewBooks extends Canvas {
	public static void ViewBook() {
		
		/*
		 * ViewBooks m=new ViewBooks(); JFrame f=new JFrame(); f.add(m);
		 * f.setSize(400,400); //f.setLayout(null); f.setVisible(true);
		 */
		
		JFrame f = new JFrame("Books Available");

		String outputFile = "serializationdemo.txt";
		// following code reads into the file

		ArrayList list;

		BooksParameters defNext = null;
		DefaultTableModel model = new DefaultTableModel();
	
		try {
			ArrayList<BooksParameters> namesList = new ArrayList<BooksParameters>();
			list = (ArrayList) SerializationLib.doDeserialize(outputFile);
			// System.out.println("def():\n --"+"\n |\n "+def);

			namesList = (ArrayList<BooksParameters>) list;
			System.out.println(System.lineSeparator());

			ArrayList<String> columns = new ArrayList<String>();
			ArrayList<String[]> values = new ArrayList<String[]>();
			columns.add("BookName");
			columns.add("Genre");
			columns.add("Price");

			for (int i = 0; i < namesList.size(); i++) {
				values.add(new String[] { namesList.get(i).bname ,  namesList.get(i).genre, namesList.get(i).price });
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


		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		
	}
	public void paint(Graphics g) {
		g.drawString("Hello",40,40);
		setBackground(Color.WHITE);
		g.fillRect(130, 30,100, 80);
		g.drawOval(30,130,50, 60);
		setForeground(Color.RED);
		g.fillOval(130,130,50, 60);
		g.drawArc(30, 200, 40,50,90,60);
		g.fillArc(30, 130, 40,50,180,40);
		
	}
}
