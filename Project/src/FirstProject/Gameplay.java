package FirstProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gameplay extends JPanel implements ActionListener {

	private int width;
	private int height;
	public Ship palyerShip;
	public boolean missle = true; // to check if missile is ready to be fired again
	public int missleX;
	public int missleY;
	
	private int leftRightDistance = 20;
	private int topDistance = 10;
	private int botomDistance = 10;
	private int spaceBetweenShips = 20;
	private int numOfShips = 10;
	private Ship[][] ships = new Ship[4][numOfShips];
	private boolean setup = false;
	
	public int playerShipX;
	public int playerShipY;
	public boolean LRBorderCheck = true;
	public int scale = 0;
	private int explosionFrameNumber = 0;
	
	public Gameplay (int width, int height) {
		this.height = height;
		this.width = width;
				
		
	}
	
	// 
	public void paintComponenet(Graphics g) {
		super.paintComponent(g);
		
		if (setup == false) {
			for (int i = 0; i < ships.length; i++) {
				for (int j = 0; j < ships[0].length; j++) {
					ships[i][j] = new Ship();
					ships[i][j].setShipWidth(((width - (leftRightDistance*2)) - (spaceBetweenShips*(numOfShips-1))) / numOfShips);
					ships[i][j].setShipHeight(30);
				}
			}
			setup = true;
		}
		
		if (palyerShip == null) {
			palyerShip = new Ship();
			palyerShip.setShipWidth(((width - (leftRightDistance*2)) - (spaceBetweenShips*(numOfShips-1))) / numOfShips);
			palyerShip.setShipHeight(30);
			playerShipX = width/2 - palyerShip.getShipWidth()/2;
			playerShipY = height - botomDistance - 10;
		}
		
		if (LRBorderCheck) {
			scale++;
		} else if (!LRBorderCheck) {
			scale--;
		}
		
		missle(g);
		drawShips(g);
		
	}
	
	public void drawShips( Graphics g) {
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[0].length; j++) {
				int x,y;
				x = scale + j*spaceBetweenShips + leftRightDistance + j*ships[i][j].getShipWidth();
				y = i*spaceBetweenShips + topDistance +(int)(ships[i][j].getShipHeight() * 0.35) + i * ships[i][j].getShipHeight();
				
				if (ships[i][j].getStatus() == true) {
					
					ships[i][j].drawShip(g, x, y);
					
					if (checkIfHitt(x,y)) {
						ships[i][j].setStatus(false);
						ships[i][j].setExploading(true);
					}
					if (x <= 0) {
						LRBorderCheck = true;
					} else if (x + ships[i][j].shipWidth >= width) {
						LRBorderCheck = false;
					}
				}
				
				if (ships[i][j].getExploading() == true) {
					ships[i][j].exploading(g, x, y, explosionFrameNumber);
					if (explosionFrameNumber >= 10) {
						ships[i][j].setExploading(false);
						explosionFrameNumber = 0;
					}
					explosionFrameNumber++;
				}
			}
		}
		
		//explosionFrameNumber ++;
		
		palyerShip.drawPlayerShip(g,  playerShipX - palyerShip.getShipWidth()/2 , playerShipY);
	}
	
	public void missle(Graphics g) {
		if (missle) {
			g.setColor(Color.WHITE);
			
			missleX = playerShipX - 3;
			missleY = playerShipY - (int)(palyerShip.getShipHeight() * 0.65);
			
			g.fillRect(missleX , missleY, 4	, 6);
		} else if (missle == false) {
			g.setColor(Color.WHITE);
			missleY -= 5;
			g.fillRect(missleX , missleY, 4	, 6);
			if (missleY < 0) {
				missle = true;
			}
		}
	}
	
	public boolean checkIfHitt(int x, int y) {
		
		if(missleX >= x & missleX <= x + palyerShip.getShipWidth() & missleY == y) {
			missle = true;
			return true;
		}
		
		return false;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

}
