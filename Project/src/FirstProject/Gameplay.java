package FirstProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gameplay extends JPanel implements ActionListener {

	private int width;
	private int height;
	private Ship ship;
	public boolean missle = true; // to check if missile is ready to be fired again
	public int missleX;
	public int missleY;
	
	private int leftRightDistance = 20;
	private int topDistance = 10;
	private int botomDistance = 10;
	private int spaceBetweenShips = 10;
	private int numOfShips = 10;
	private boolean[][] shipExistence = new boolean[4][numOfShips];
	
	public int playerShipX;
	public int playerShipY;
	
	
	
	public Gameplay (int width, int height) {
		this.height = height;
		this.width = width;
				
		
	}
	
	// 
	public void paintComponenet(Graphics g) {
		super.paintComponent(g);
		
		
		if (ship == null) {
			ship = new Ship(width, height);
			playerShipX = width/2 - ship.shipWidth/2;
			playerShipY = height - botomDistance - (int)(ship.shipHeight * 0.35);
		}
		drawShips(g);
	}
	
	public void drawShips( Graphics g) {
		ship.shipWidth = ((width - (leftRightDistance*2)) - (spaceBetweenShips*(numOfShips-1))) / numOfShips;
		ship.shipHeight = 30;
		
		for (int i = 0; i < shipExistence.length; i++) {
			for (int j = 0; j < shipExistence[0].length; j++) {
				
				int x = j*spaceBetweenShips + leftRightDistance + j*ship.shipWidth;
				int y = i*spaceBetweenShips + topDistance +(int)(ship.shipHeight * 0.35) + i * ship.shipHeight;
				ship.drawShip(g, x, y);
				
			}
		}
		
		if (missle) {
			g.setColor(Color.WHITE);
			
			missleX = playerShipX - 4;
			missleY = playerShipY - (int)(ship.shipHeight * 0.65);
			
			g.fillRect(missleX , missleY, 4	, 6);
		}
		if (missle == false) {
			g.setColor(Color.WHITE);
			
			g.fillRect(missleX , missleY, 4	, 6);
		}
		ship.drawPlayerShip(g,  playerShipX - ship.shipWidth/2 , playerShipY);
	}
	
	public void newGame() {
		
	}
	
	public void loadGame() {
		
	}
	
	public void highScore() {
		
	}
	
	public void credits() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		
	}

}
