package main.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SQL.MySQL_Project;

public class Main extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame window;
	public static JMenuBar menubar;
	
	public static MySQL_Project database;
	
	public static boolean checkIfLocalSelected = false;
	
	public static JMenuItem SQL, INVASION, ANIMATION;
	
	public static void main(String[] args) {
		window = new JFrame ("My First Project");
		start();
		Intro container = new Intro();
		window.setContentPane(container);
		
		window.setSize(820,500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation((screenSize.width - window.getWidth()) / 2 , (screenSize.height - window.getHeight()) / 2);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public static class Intro extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JButton walkingMan, jdbc, game;
		
		public Intro() {

			walkingMan = new JButton("Animation");
			jdbc = new JButton("SQL and JDBC project");
			game = new JButton("Play the game");
			
			addListeners(walkingMan, jdbc, game);
			
			add(walkingMan);
			add(jdbc);
			add(game);
		}
		
	}
	
	
	public static void start () {
		//window.setContentPane(animation);
		ApplicationContext context = new ClassPathXmlApplicationContext("/beanPackage/beans.xml");
		database = (MySQL_Project)context.getBean("mysql_project");
		((ClassPathXmlApplicationContext) context).close();
		actionListeners();
	}
	
	public static void actionListeners() {
		
		menubar = new JMenuBar();
		window.setJMenuBar(menubar);
		
		JMenu menu = new JMenu("Projects");
		menubar.add(menu);
		
		ANIMATION = new JMenuItem ("Introduction");
		SQL = new JMenuItem ("MySQL Project");
		INVASION = new JMenuItem ("Play a game");
		
		
		addListeners(ANIMATION, SQL, INVASION);
		
		menu.add(ANIMATION);
		menu.add(SQL);
		menu.add(INVASION);
	}
	
	private static void addListeners(AbstractButton ANIMATION, AbstractButton SQL, AbstractButton INVASION) {
		
		SQL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//database = new MySQL_Project();
				checkIfLocalSelected = true;
				window.getContentPane().removeAll();
				window.setContentPane(database);
				start ();
				window.revalidate();
			}
			
		});
	}
	
}
