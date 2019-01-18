package FirstProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Invasion extends JPanel implements ActionListener, KeyListener {

	private JButton newGame, loadGame, highScore, credits, exit, back, save;
	
	private Image image;
	
	private int buttonHeight = 20;
	private int buttonWidth = 120;
	private Gameplay gameplay;
	private TextShow textShow;
	private HighScore hScore = new HighScore("HighScore.txt");
	private Save saveGame;
	
	private String playerName;
	
	private Timer tm = new Timer(5, this);
	
	public Invasion() {
		
		setLayout(null);
		setButtons();
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	
	// set buttons on panel
	public void setButtons() {
		newGame = new JButton("New Game");
		loadGame = new JButton("Load Game");
		highScore = new JButton("High Score ");
		credits = new JButton("Credits");
		exit = new JButton("Exit");
		
		newGame.addActionListener(this);
		loadGame.addActionListener(this);
		highScore.addActionListener(this);
		credits.addActionListener(this);
		exit.addActionListener(this);
		
		newGame.setBounds(800/2 - buttonWidth/2, 500/2 - buttonHeight/2 - buttonHeight * 2 - 20, buttonWidth, buttonHeight);
		loadGame.setBounds(800/2 - buttonWidth/2, 500/2 - buttonHeight/2 - buttonHeight - 10, buttonWidth, buttonHeight);
		highScore.setBounds(800/2 - buttonWidth/2, 500/2 - buttonHeight/2, buttonWidth, buttonHeight);
		credits.setBounds(800/2 - buttonWidth/2, 500/2 - buttonHeight/2 + buttonHeight + 10, buttonWidth, buttonHeight);
		exit.setBounds(800/2 - buttonWidth/2, 500/2 - buttonHeight/2 + buttonHeight * 2 + 20, buttonWidth, buttonHeight);
		
		add(newGame);
		add(loadGame);
		add(highScore);
		add(credits);
		add(exit);
	}
	
	// Paint on canvas
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		setBackground(g);
		
		if (gameplay != null) {
			gameplay.paintComponenet(g);
			if (gameplay.gameEnded()) {
				
				hScore.setScore(gameplay.getscore() +" "+ playerName);
				gameplay = null;
				
				highScore.setBounds(800/2 - buttonWidth/2, 500/2 - buttonHeight/2, buttonWidth, buttonHeight);
				
				tm.stop();
				
				setButtons();
				repaint();
				
			}
		} else if (textShow != null) {
			textShow.move++;
			textShow.paintComponent(g);
		}
	}
	
	// Set background picture
	private void setBackground(Graphics g) {
		
		try {
			image = ImageIO.read(new File("alienfleet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	// Action performed for buttons
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newGame || e.getSource() == loadGame) {
			
			this.removeAll();
			tm.start();
			
			playerName = JOptionPane.showInputDialog("Enter your name: ");
			gameplay = new Gameplay (getWidth(), getHeight());
			
			if (e.getSource() == loadGame){
				
				saveGame = new Save("Save.txt");
				gameplay.setSavedShipsList(saveGame.getSave());
			}
			back = new JButton("exit");
			save = new JButton("save");
			
			back.setBounds(getWidth() - 150, 20, 65, 15);
			save.setBounds(getWidth() - 75, 20, 65, 15);
			
			back.addActionListener(this);
			save.addActionListener(this);
			
			add(back);
			add(save);
			repaint();	

		} else if (e.getSource() == highScore) {
			hScore = new HighScore("HighScore.txt");
			hScore.showHighScore();
			
		} else if (e.getSource() == credits) {
			this.removeAll();
			tm.start();
			if (textShow == null) {
				textShow = new TextShow("Credits.txt");
				textShow.setCords(30, getHeight() + 10, -10, 15, Color.WHITE);
			}
			back = new JButton("<-Back");
			back.setBounds(20, 20, buttonWidth, buttonHeight);
			back.addActionListener(this);
			add(back);
			
		} else if (e.getSource() == exit) {
			System.exit(0);
		}
		
		// this action pr are for manipulation when you are in objects
		
		if (e.getSource() == back) { // return to menu
			textShow = null;
			gameplay = null;
			tm.stop();
			this.removeAll();
			setButtons();
			
		} else if(e.getSource() == save) { // save game
			saveGame = new Save("Save.txt");
			saveGame.setSave(gameplay.getSavedShipsList());
		}
		
		repaint();
	}

	// just for gameplay class
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
        	if ((gameplay.playerShipX - gameplay.palyerShip.shipWidth/2) > 0) {
        		gameplay.playerShipX = gameplay.playerShipX - 3;
        	}
        }
        else if (code == KeyEvent.VK_RIGHT) {
        	if ((gameplay.playerShipX + gameplay.palyerShip.shipWidth/2) < getWidth()) {
        		gameplay.playerShipX = gameplay.playerShipX + 3;
        	}
        }
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch == ' ') {
			gameplay.missile = false;
		}
		
	}

}
