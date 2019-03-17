package com.videogame.invasion.view.play;

public class ShipsFactory {

	private PlayerShip playerShip;
	private EnemyShip enemyShip;
	
	public PlayerShip getPlayerShip() {
		return playerShip;
	}
	public void setPlayerShip(PlayerShip playerShip) {
		this.playerShip = playerShip;
	}
	public EnemyShip getEnemyShip() {
		return enemyShip;
	}
	public void setEnemyShip(EnemyShip enemyShip) {
		this.enemyShip = enemyShip;
	}
	
	
}
