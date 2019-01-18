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
		
		public JButton walkingMan, jdbc, game;
		
		public Intro() {

			walkingMan = new JButton("Animation");
			jdbc = new JButton("SQL and JDBC project");
			game = new JButton("Play the game");
			
			walkingMan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					animation = new Animation();
					checkIfLocalSelected = true;
					window.getContentPane().removeAll();
					window.setContentPane(animation);
					window.revalidate();
				}
			});
			
			jdbc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					database = new MySQL_Project();
					checkIfLocalSelected = true;
					window.getContentPane().removeAll();
					window.setContentPane(database);
					window.revalidate();
				}
			});
			
			game.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					invasion = new Invasion();
					checkIfLocalSelected = true;
					window.getContentPane().removeAll();
					window.setContentPane(invasion);
					window.revalidate();
				}
			});
			
			add(walkingMan);
			add(jdbc);
			add(game);
		}
		
		
		
	}
	
	
	public static void start () {
		//window.setContentPane(animation);
		
		actionListeners();
	}
	
	public static void actionListeners() {
		
		menubar = new JMenuBar();
		window.setJMenuBar(menubar);
		
		JMenu menu = new JMenu("Projects");
		menubar.add(menu);
		
		ANIMATION = new JMenuItem ("Introduction");
		ANIMATION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				animation = new Animation();
				checkIfLocalSelected = true;
				window.getContentPane().removeAll();
				window.setContentPane(animation);
				window.revalidate();
			}
		});
		
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
		
		menu.add(ANIMATION);
		menu.add(SQL);
		menu.add(INVASION);
	}
	
}
