package FirstProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gameplay extends JPanel implements ActionListener {

	private int width;
	private int height;
	public Ship ship;
	public boolean missle = true; // to check if missile is ready to be fired again
	public int missleX;
	public int missleY;
	
	private int leftRightDistance = 20;
	private int topDistance = 10;
	private int botomDistance = 10;
	private int spaceBetweenShips = 20;
	private int numOfShips = 10;
	private boolean[][] shipExistence = new boolean[4][numOfShips];
	
	public int playerShipX;
	public int playerShipY;
	public boolean LRBorderCheck = true;
	public int scale = 0;
	
	public Gameplay (int width, int height) {
		this.height = height;
		this.width = width;
				
		
	}
	
	// 
	public void paintComponenet(Graphics g) {
		super.paintComponent(g);
		
		
		if (ship == null) {
			ship = new Ship();
			playerShipX = width/2 - ship.shipWidth/2;
			playerShipY = height - botomDistance - 10;
		}
		if (LRBorderCheck) {
			scale++;
		} else if (!LRBorderCheck) {
			scale--;
		}
		drawShips(g);
	}
	
	public void drawShips( Graphics g) {
		ship.shipWidth = ((width - (leftRightDistance*2)) - (spaceBetweenShips*(numOfShips-1))) / numOfShips;
		ship.shipHeight = 30;
		
		for (int i = 0; i < shipExistence.length; i++) {
			for (int j = 0; j < shipExistence[0].length; j++) {
				int x,y;
				if (shipExistence[i][j] == false) {
					x = scale + j*spaceBetweenShips + leftRightDistance + j*ship.shipWidth;
					y = i*spaceBetweenShips + topDistance +(int)(ship.shipHeight * 0.35) + i * ship.shipHeight;
					ship.drawShip(g, x, y);
					
					if (x <= 0) {
						LRBorderCheck = true;
					} else if (x + ship.shipWidth >= width) {
						LRBorderCheck = false;
					}
				}
			}
		}
		
		if (missle) {
			g.setColor(Color.WHITE);
			
			missleX = playerShipX - 3;
			missleY = playerShipY - (int)(ship.shipHeight * 0.65);
			
			g.fillRect(missleX , missleY, 4	, 6);
		} else if (missle == false) {
			g.setColor(Color.WHITE);
			missleY -= 5;
			g.fillRect(missleX , missleY, 4	, 6);
			if (missleY < 0) {
				missle = true;
			}
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
