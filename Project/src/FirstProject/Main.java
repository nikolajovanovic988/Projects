package FirstProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame{

	public static JFrame window;
	public static Animation animation = new Animation();
	public static Invasion invasion;
	public static JMenuBar menubar;
	public static MySQL_Project database;
	public static boolean checkIfLocalSelected = false;
	
	public static JMenuItem SQL, INVASION;
	
	public static void main(String[] args) {
		window = new JFrame ("My First Project");
		main();
		window.setSize(820,500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation((screenSize.width - window.getWidth()) / 2 , (screenSize.height - window.getHeight()) / 2);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}


	public static void main () {
		window.setContentPane(animation);
		menubar = new JMenuBar();
		window.setJMenuBar(menubar);
		
		JMenu menu = new JMenu("Projects");
		menubar.add(menu);
		
		SQL = new JMenuItem ("MySQL Project");
		SQL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				database = new MySQL_Project();
				checkIfLocalSelected = true;
				window.getContentPane().removeAll();
				window.setContentPane(database);
				window.revalidate();
			}
			
		});
		
		INVASION = new JMenuItem ("Play a game");
		INVASION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invasion = new Invasion();
				checkIfLocalSelected = true;
				window.getContentPane().removeAll();
				window.setContentPane(invasion);
				window.revalidate();
			}
			
		});
		
		menu.add(SQL);
		menu.add(INVASION);
	}
}
