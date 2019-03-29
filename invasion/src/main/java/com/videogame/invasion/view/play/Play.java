package com.videogame.invasion.view.play;

import java.awt.Color;
import java.awt.Graphics;

public class Play {

	private ShipsFactory shipsFactory;

	private int numOfShips = 1;
	private EnemyShip[][] ships = new EnemyShip[1][numOfShips];
	private boolean setup = false;

	private PlayerShip palyerShip;
	private int playerShipX;
	private int playerShipY;
	private boolean LRBorderCheck = true;

	private boolean missile = true; // to check if missile is ready to be fired again
	private int missileX;
	private int missileY;

	private boolean start = false;
	private String playerName;

	private int width;
	private int height;

	private int leftRightDistance = 20;
	private int topDistance = 50;
	private int botomDistance = 10;
	private int spaceBetweenShips = 20;

	private int scale = 0;
	private int explosionFrameNumber = 0;

	private int score = 10000;
	private int time = 0;
	private int missileNum = 0;

	public void paintComponent(Graphics g) {

		// first setup when game starts

		if (setup == false) {

			setSetup();

		}

		// check if ship is in far left or right border
		if (LRBorderCheck) {
			scale++;
		} else if (!LRBorderCheck) {
			scale--;
		}
		
		missile(g); // draw missile
		drawShips(g); // draw all ships
		
	}

	private void setSetup() {

		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[0].length; j++) {
				ships[i][j] = new EnemyShip();
				ships[i][j].setShipWidth(
						((width - (leftRightDistance * 2)) - (spaceBetweenShips * (numOfShips - 1))) / numOfShips);
				ships[i][j].setShipHeight(30);
			}
		}
		setup = true;

		// first setup of player ship

		palyerShip = shipsFactory.getPlayerShip();
		palyerShip.setShipWidth(
				((width - (leftRightDistance * 2)) - (spaceBetweenShips * (numOfShips - 1))) / numOfShips);
		palyerShip.setShipHeight(30);
		playerShipX = width / 2 - palyerShip.getShipWidth() / 2;
		playerShipY = height - botomDistance - 10;

	}

	private void drawShips(Graphics g) {
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[0].length; j++) {
				int x, y;
				x = scale + j * spaceBetweenShips + leftRightDistance + j * ships[i][j].getShipWidth();
				y = i * spaceBetweenShips + topDistance + (int) (ships[i][j].getShipHeight() * 0.35)
						+ i * ships[i][j].getShipHeight();

				if (ships[i][j].isStatus() == true) {

					ships[i][j].drawShip(g, x, y);

					if (checkIfHit(x, y)) {
						ships[i][j].setStatus(false);
						ships[i][j].setExplosion(true);
					}
					if (x <= 0) {
						LRBorderCheck = true;
					} else if (x + ships[i][j].getShipWidth() >= width) {
						LRBorderCheck = false;
					}
				}

				if (ships[i][j].isExplosion() == true) {
					ships[i][j].exploading(g, x + ships[i][j].getShipWidth() / 2, y, explosionFrameNumber);
					if (explosionFrameNumber >= 8) {
						ships[i][j].setExplosion(false);
						explosionFrameNumber = 0;
					}
					explosionFrameNumber++;
				}
			}
		}

		// draw player ship
		palyerShip.drawShip(g, playerShipX - palyerShip.getShipWidth() / 2, playerShipY);

	}

	// check if missile is lunched and draw it
	private void missile(Graphics g) {
		if (missile) {
			g.setColor(Color.WHITE);

			missileX = playerShipX - 3;
			missileY = playerShipY - (int) (palyerShip.getShipHeight() * 0.65) - 1;

			g.fillRect(missileX, missileY, 4, 6);
		} else if (missile == false) {
			g.setColor(Color.WHITE);
			missileY -= 5;
			g.fillRect(missileX, missileY, 4, 6);
			if (missileY < 0) {
				missile = true;
				missileNum++;
			}
		}
	}

	// check if ship is hit
	public boolean checkIfHit(int x, int y) {

		if (missileX >= x & missileX <= x + palyerShip.getShipWidth() & missileY == y) {
			missile = true;
			missileNum++;
			return true;
		}

		return false;
	}

	// check if all ships are down, and return result
	public boolean gameEnded() {
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[0].length; j++) {
				if (ships[i][j].isStatus() == true) {
					return false;
				}
			}
		}
		return true;
	}

	// return list of ships who are alive
	public String[][] getSavedShipsList() {

		String[][] list = new String[4][numOfShips];

		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[0].length; j++) {

				if (ships[i][j].isStatus() == true) {
					list[i][j] = "1";
				} else {
					list[i][j] = "0";
				}
			}
		}

		return list;
	}

	// set ships status
	public void setSavedShipsList(String[][] list) {

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[0].length; j++) {

				ships[i][j] = new EnemyShip();
				ships[i][j].setShipWidth(
						((width - (leftRightDistance * 2)) - (spaceBetweenShips * (numOfShips - 1))) / numOfShips);
				ships[i][j].setShipHeight(30);

				if (list[i][j].equals("1")) {
					ships[i][j].setStatus(true);
				} else {
					ships[i][j].setStatus(false);
				}
			}
		}
		
		setup = true;

		// first setup of player ship

		palyerShip = shipsFactory.getPlayerShip();
		palyerShip.setShipWidth(
				((width - (leftRightDistance * 2)) - (spaceBetweenShips * (numOfShips - 1))) / numOfShips);
		palyerShip.setShipHeight(30);
		playerShipX = width / 2 - palyerShip.getShipWidth() / 2;
		playerShipY = height - botomDistance - 10;
		
	}

	// return game score
	public String getscore() {
		return Integer.toString(score - (int) (time * 0.5) - (missileNum * 10));
	}

	public ShipsFactory getShipsFactory() {
		return shipsFactory;
	}

	public void setShipsFactory(ShipsFactory shipsFactory) {
		this.shipsFactory = shipsFactory;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPlayerShipX(int playerShipX) {
		this.playerShipX = playerShipX;
	}

	public int getPlayerShipX() {
		return playerShipX;
	}

	public PlayerShip getPalyerShip() {
		return palyerShip;
	}

	public void setPalyerShip(PlayerShip palyerShip) {
		this.palyerShip = palyerShip;
	}

	public boolean isMissile() {
		return missile;
	}

	public void setMissile(boolean missile) {
		this.missile = missile;
	}

	public void setSetup(boolean setup) {
		this.setup = setup;
	}
}
