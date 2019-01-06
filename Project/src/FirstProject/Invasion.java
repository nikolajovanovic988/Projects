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

	private JButton newGame, loadGame, highScore, credits, exit;
	private Image image;
	
	private int buttonHeight = 20;
	private int buttonWidth = 100;
	private Gameplay gameplay;
	
	
	public Timer tm = new Timer(5, this);
	
	public Invasion() {
		
		setLayout(null);
		setButtons();
		
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		}
	
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
		
		if (e.getSource() == newGame) {
			this.removeAll();
			gameplay = new Gameplay (getWidth(), getHeight());
			//JButton button = new JButton("BUTTON");
			//button.setBounds(800/2 - buttonWidth/2, 500/2 - buttonHeight/2 - buttonHeight * 2 - 20, buttonWidth, buttonHeight);
			//this.add(button);
			repaint();
			
		} else if (e.getSource() == loadGame) {
			gameplay.loadGame();
		} else if (e.getSource() == highScore) {
			gameplay.highScore();
		} else if (e.getSource() == credits) {
			gameplay.credits();
		} else if (e.getSource() == exit) {
			System.exit(0);
		}
		
		if (gameplay != null) {
			
			if(gameplay.missle == false) {
				gameplay.missleY -= 5;
				if (gameplay.missleY < 0) {
					gameplay.missle = true;
				}
			}
		}
		
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
              gameplay.playerShipX = gameplay.playerShipX - 3;
        }
        else if (code == KeyEvent.VK_RIGHT) {
        	gameplay.playerShipX = gameplay.playerShipX + 3;
        }
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch == ' ') {
			gameplay.missle = false;
		}
		
	}

}
