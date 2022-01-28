package libraryProject;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
public class splashScreen{
	public static void main(String[] args) throws InterruptedException {
		JWindow w = new JWindow();
		w.setSize(500,400);
		w.setLocationRelativeTo(null);
		w.dispose();
		JLabel l1=new JLabel(new ImageIcon("src/splashImg.jpg"));
		w.add(l1);
		JProgressBar pb=new JProgressBar();
		pb.setStringPainted(true);
		pb.setBackground(Color.ORANGE);
		pb.setForeground(Color.DARK_GRAY);
		w.add(BorderLayout.SOUTH,pb);
		
		w.setVisible(true);
		for(int i=0;i<=100;i++)
		{
			Thread.sleep(30);
			pb.setValue(i);
			
		}
		if(pb.getValue()==100)
		{
			w.dispose();
			Login.login();
		}
	}
}