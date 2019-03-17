package com.videogame.invasion.view.play;

import java.awt.Graphics;

public interface Ship {

	public void drawShip(Graphics g, int startX, int startY);
	
	public void exploading (Graphics g, int x, int y, int explosionFrameNumber);
	
}
