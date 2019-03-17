package com.videogame.invasion.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.videogame.invasion.controller.Controller;
import com.videogame.invasion.view.play.Play;

public class Menu extends JPanel implements ActionListener, KeyListener {

	private Controller controller;
	private CreditsView creditsView;
	private HighScoreView highScoreView;
	private Play play;

	private JButton newGame, loadGame, highScore, credits, exit, back, save;
	private int buttonHeight = 20;
	private int buttonWidth = 120;

	private Image image;

	private Timer tm = new Timer(5, this);

	public Menu() {
		setLayout(null);

		addKeyListener(this);
		setFocusable(true);
		setButtons();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(g);

		if (play.isStart()) {

			play.paintComponent(g);

			if (play.isGameEnd()) {

				controller.getModel().getSaveHighScore().saveScore(play.getscore() + " " + play.getPlayerName());
				tm.stop();

				play.setStart(false);
				play.setSetup(false);
				
				this.removeAll();
				setButtons();
			}

		} else if (creditsView.isStart()) {

			creditsView.move++;
			creditsView.paintComponent(g);
		}

		repaint();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == newGame || e.getSource() == loadGame) {

			this.removeAll();
			tm.start();
			
			if (e.getSource() == newGame) {
				play.setPlayerName(JOptionPane.showInputDialog("Enter your name: "));
			}
			
			play.setWidth(getWidth());
			play.setHeight(getHeight());
			play.setStart(true);
			
			if (e.getSource() == loadGame) {
				play.setSavedShipsList(controller.getModel().getLoad().getLoad());
			}

			

			back = new JButton("exit");
			save = new JButton("save");

			back.setBounds(getWidth() - 150, 20, 65, 15);
			save.setBounds(getWidth() - 75, 20, 65, 15);

			back.addActionListener(this);
			save.addActionListener(this);

			add(back);
			add(save);

		} else if (e.getSource() == highScore) {

			highScoreView.setLines(controller.getModel().getLoadHighScore().loadScore());
			highScoreView.showHighScore();

		} else if (e.getSource() == credits) {

			this.removeAll();
			tm.start();

			creditsView.setLines(controller.getModel().getCredits().getText());
			creditsView.setStart(true);
			creditsView.setCords(30, getHeight() + 10, -10, 15, Color.WHITE);
			creditsView.move = 0;

			back = new JButton("<-Back");
			back.setBounds(20, 20, 100, buttonHeight);
			back.addActionListener(this);
			add(back);

		} else if (e.getSource() == save) {
			
			controller.getModel().getSave().setSave(play.getSavedShipsList());
			
		} else if (e.getSource() == back) {

			tm.stop();
			creditsView.setStart(false);
			play.setStart(false);
			play.setSetup(false);
			this.removeAll();
			setButtons();

		} else if (e.getSource() == exit) {

			System.exit(0);

		}
		
		repaint();
	}

	private void setBackground(Graphics g) {

		try {
			image = ImageIO.read(new File("alienfleet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	private void setButtons() {
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

		newGame.setBounds(800 / 2 - buttonWidth / 2, 500 / 2 - buttonHeight / 2 - buttonHeight * 2 - 20, buttonWidth,
				buttonHeight);
		loadGame.setBounds(800 / 2 - buttonWidth / 2, 500 / 2 - buttonHeight / 2 - buttonHeight - 10, buttonWidth,
				buttonHeight);
		highScore.setBounds(800 / 2 - buttonWidth / 2, 500 / 2 - buttonHeight / 2, buttonWidth, buttonHeight);
		credits.setBounds(800 / 2 - buttonWidth / 2, 500 / 2 - buttonHeight / 2 + buttonHeight + 10, buttonWidth,
				buttonHeight);
		exit.setBounds(800 / 2 - buttonWidth / 2, 500 / 2 - buttonHeight / 2 + buttonHeight * 2 + 20, buttonWidth,
				buttonHeight);

		add(newGame);
		add(loadGame);
		add(highScore);
		add(credits);
		add(exit);
	}

	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		if (code == KeyEvent.VK_LEFT) {
			if ((play.getPlayerShipX() - play.getPalyerShip().getShipWidth() / 2) > 0) {
				play.setPlayerShipX(play.getPlayerShipX() - 3);
			}
		} else if (code == KeyEvent.VK_RIGHT) {
			if ((play.getPlayerShipX() + play.getPalyerShip().getShipWidth() / 2) < getWidth()) {
				play.setPlayerShipX(play.getPlayerShipX() + 3);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch == ' ') {
			play.setMissile(false);
		}

	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public CreditsView getCreditsView() {
		return creditsView;
	}

	public void setCreditsView(CreditsView creditsView) {
		this.creditsView = creditsView;
	}

	public HighScoreView getHighScoreView() {
		return highScoreView;
	}

	public void setHighScoreView(HighScoreView highScoreView) {
		this.highScoreView = highScoreView;
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}
}
