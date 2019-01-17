package FirstProject;

import java.awt.*;

public class Ship {
	
	public int shipWidth;
	public int shipHeight;
	private boolean status = true;
	private boolean explosion = false;
	
	
	public Ship () {
		
	}
	
	public void setShipWidth(int shipWidth) {
		this.shipWidth = shipWidth;
	}
	
	public int getShipWidth() {
		return shipWidth;
	}
	
	public void setShipHeight(int shipHeight) {
		this.shipHeight = shipHeight;
	}
	
	public int getShipHeight() {
		return shipHeight;
	}
	
	// setStatus is to set ship to be destroyed
	public void setStatus(boolean status) {
		this.status = status;
	}
	// will return false if ship is destroyed
	public boolean getStatus() {
		return status;
	}
	// return true if explosion is happening
	public boolean getExplosion() {
		return explosion;
	}
	// if true explosion is happening 
	public void setExplosion(boolean explosion) {
		this.explosion = explosion;
	}
	// draw explosion
	public void  exploading (Graphics g, int x, int y, int explosionFrameNumber) {
		g.setColor(Color.YELLOW);
        g.fillOval(x - 4*explosionFrameNumber,
                y - 2*explosionFrameNumber,
                8*explosionFrameNumber,
                4*explosionFrameNumber);
        g.setColor(Color.RED);
        g.fillOval(x - 2*explosionFrameNumber,
                y - explosionFrameNumber/2,
                4*explosionFrameNumber,
                explosionFrameNumber);
	}
	
	// Draw ship faced down.
	public void drawShip(Graphics g, int startX, int startY) {
		
		int[] x = new int[22];
		int[] y = new int[22];
		
		x[0] = startX;
		y[0] = startY;
		x[1] = x[0] + (int)(shipWidth * 0.1);
		y[1] = y[0] - (int)(shipHeight * 0.1);
		x[2] = x[1] + (int)(shipWidth * 0.25);
		y[2] = y[1] + (int)(shipHeight * 0.1);
		x[3] = x[2];
		y[3] = y[2] - (int)(shipHeight * 0.05);	
		x[4] = x[3] + (int)(shipWidth * 0.05) ;
		y[4] = y[3] - (int)(shipHeight * 0.2);
		x[5] = x[4];
		y[5] = y[4] - (int)(shipHeight * 0.1);
		x[6] = x[5] + (int)(shipWidth * 0.19);
		y[6] = y[5];
		x[7] = x[6];
		y[7] = y[6] + (int)(shipHeight * 0.1);
		x[8] = x[7] + (int)(shipWidth * 0.05);
		y[8] = y[7] + (int)(shipHeight * 0.2);
		x[9] = x[8];
		y[9] = y[8] + (int)(shipHeight * 0.05);	
		x[10] = x[9] + (int)(shipWidth * 0.25);
		y[10] = y[9] - (int)(shipHeight * 0.1);
		x[11] = x[10] + (int)(shipWidth * 0.1);
		y[11] =	y[10] + (int)(shipHeight * 0.1);
		x[12] = x[11] - (int)(shipWidth * 0.15);
		y[12] = y[11] + (int)(shipHeight * 0.2);
		x[13] = x[12] - (int)(shipWidth * 0.2);
		y[13] =	y[12];
		x[14] = x[13];
		y[14] = y[13] + (int)(shipHeight * 0.15);
		x[15] = x[14] - (int)(shipWidth * 0.02);
		y[15] = y[14] + (int)(shipHeight * 0.15);
		x[16] = x[15] - (int)(shipWidth * 0.1);
		y[16] = y[15] + (int)(shipHeight * 0.15);
		x[17] = x[16] - (int)(shipWidth * 0.06);
		y[17] =	y[16];
		x[18] = x[17] - (int)(shipWidth * 0.1);
		y[18] = y[17] - (int)(shipHeight * 0.15);
		x[19] = x[18] - (int)(shipWidth * 0.02);
		y[19] = y[18] - (int)(shipHeight * 0.15);
		x[20] = x[19];
		y[20] = y[19] - (int)(shipHeight * 0.15);
		x[21] = x[20] - (int)(shipWidth * 0.2);
		y[21] =	y[20];	
		g.setColor(Color.GREEN);
		g.fillPolygon(x,y,22);
		
		
		g.setColor(Color.BLACK);
		
		// Engine
		g.drawLine(x[3], y[3], x[8], y[8]);
		g.drawLine(x[4], y[4], x[7], y[7]);
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.02), x[7], y[7]- (int)(shipHeight * 0.02));
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.04), x[7], y[7]- (int)(shipHeight * 0.04));
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.06), x[7], y[7]- (int)(shipHeight * 0.06));
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.08), x[7], y[7]- (int)(shipHeight * 0.08));
		
		
		int [] c = new int[5];
		int [] u = new int[5];
		// Right wing
		c[0] = x[20];
		u[0] = y[20] - (int)(shipHeight * 0.05);
		c[1] = x[21];
		u[1] = y[21] - (int)(shipHeight * 0.05);
		c[2] = x[0] + (int)(shipWidth * 0.05);
		u[2] = y[0];
		c[3] = x[1];
		u[3] = y[1] + (int)(shipHeight * 0.05);	
		c[4] = x[2];
		u[4] = y[2] + (int)(shipHeight * 0.05);
		
		g.drawPolygon(c, u, 5);
		g.drawLine(x[20], y[20], x[2], y[2]);
		
		c = new int[5];
		u = new int[5];
		// Left wing
		c[0] = x[9];
		u[0] = y[9] + (int)(shipHeight * 0.05);
		c[1] = x[10];
		u[1] = y[10] + (int)(shipHeight * 0.05);
		c[2] = x[11] - (int)(shipWidth * 0.05);
		u[2] = y[11];
		c[3] = x[12];
		u[3] = y[12] - (int)(shipHeight * 0.05);	
		c[4] = x[13];
		u[4] = y[13] - (int)(shipHeight * 0.05);
		
		g.drawPolygon(c, u, 5);
		g.drawLine(x[9], y[9], x[13], y[13]);
		
		// Head
		c = new int[8];
		u = new int[8];
		
		c[0] = x[14];
		u[0] = y[14];
		c[1] = x[14] - (int)(shipWidth * 0.0075);
		u[1] = y[14] + (int)(shipHeight * 0.075);
		c[2] = x[16] - (int)(shipWidth * 0.0075);
		u[2] = y[13] + (int)(shipHeight * 0.075);
		c[3] = x[17] + (int)(shipWidth * 0.0075);
		u[3] = y[13] + (int)(shipHeight * 0.075);	
		c[4] = x[19] + (int)(shipWidth * 0.0075);
		u[4] = y[19] + (int)(shipHeight * 0.075);
		c[5] = x[19];
		u[5] = y[19];
		c[6] = x[17];
		u[6] = y[13];
		c[7] = x[16];
		u[7] = y[13];
		g.drawPolygon(c, u, 8);
		g.drawLine(x[15], y[15], x[18], y[18]);
	}
	
	// Draw ship faced up
	public void drawPlayerShip(Graphics g, int startX, int startY) {
		
		//int oneX = (int) (shipWidth * 0.01); // one % of ship width
		//int oneY = (int) (shipHeight * 0.01); // one % of ship height
		
		
		int[] x = new int[22];
		int[] y = new int[22];
		
		x[0] = startX;
		y[0] = startY;
		x[1] = x[0] + (int)(shipWidth * 0.1);
		y[1] = y[0] + (int)(shipHeight * 0.1);
		x[2] = x[1] + (int)(shipWidth * 0.25);
		y[2] = y[1] - (int)(shipHeight * 0.1);
		x[3] = x[2];
		y[3] = y[2] + (int)(shipHeight * 0.05);	
		x[4] = x[3] + (int)(shipWidth * 0.05) ;
		y[4] = y[3] + (int)(shipHeight * 0.2);
		x[5] = x[4];
		y[5] = y[4] + (int)(shipHeight * 0.1);
		x[6] = x[5] + (int)(shipWidth * 0.19);
		y[6] = y[5];
		x[7] = x[6];
		y[7] = y[6] - (int)(shipHeight * 0.1);
		x[8] = x[7] + (int)(shipWidth * 0.05);
		y[8] = y[7] - (int)(shipHeight * 0.2);
		x[9] = x[8];
		y[9] = y[8] - (int)(shipHeight * 0.05);	
		x[10] = x[9] + (int)(shipWidth * 0.25);
		y[10] = y[9] + (int)(shipHeight * 0.1);
		x[11] = x[10] + (int)(shipWidth * 0.1);
		y[11] =	y[10] - (int)(shipHeight * 0.1);
		x[12] = x[11] - (int)(shipWidth * 0.15);
		y[12] = y[11] - (int)(shipHeight * 0.2);
		x[13] = x[12] - (int)(shipWidth * 0.2);
		y[13] =	y[12];
		x[14] = x[13];
		y[14] = y[13] - (int)(shipHeight * 0.15);
		x[15] = x[14] - (int)(shipWidth * 0.02);
		y[15] = y[14] - (int)(shipHeight * 0.15);
		x[16] = x[15] - (int)(shipWidth * 0.1);
		y[16] = y[15] - (int)(shipHeight * 0.15);
		x[17] = x[16] - (int)(shipWidth * 0.06);
		y[17] =	y[16];
		x[18] = x[17] - (int)(shipWidth * 0.1);
		y[18] = y[17] + (int)(shipHeight * 0.15);
		x[19] = x[18] - (int)(shipWidth * 0.02);
		y[19] = y[18] + (int)(shipHeight * 0.15);
		x[20] = x[19];
		y[20] = y[19] + (int)(shipHeight * 0.15);
		x[21] = x[20] - (int)(shipWidth * 0.2);
		y[21] =	y[20];	
		g.setColor(Color.BLUE);
		g.fillPolygon(x,y,22);
		
		g.setColor(Color.BLACK);
		
		// Engine
		g.drawLine(x[3], y[3], x[8], y[8]);
		g.drawLine(x[4], y[4], x[7], y[7]);
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.02), x[7], y[7]- (int)(shipHeight * 0.02));
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.04), x[7], y[7]- (int)(shipHeight * 0.04));
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.06), x[7], y[7]- (int)(shipHeight * 0.06));
		g.drawLine(x[4], y[4] - (int)(shipHeight * 0.08), x[7], y[7]- (int)(shipHeight * 0.08));
		
		
		int [] c = new int[5];
		int [] u = new int[5];
		// Right wing
		c[0] = x[20];
		u[0] = y[20] + (int)(shipHeight * 0.05);
		c[1] = x[21];
		u[1] = y[21] + (int)(shipHeight * 0.05);
		c[2] = x[0] + (int)(shipWidth * 0.05);
		u[2] = y[0];
		c[3] = x[1];
		u[3] = y[1] - (int)(shipHeight * 0.05);	
		c[4] = x[2];
		u[4] = y[2] - (int)(shipHeight * 0.05);
		
		g.drawPolygon(c, u, 5);
		g.drawLine(x[20], y[20], x[2], y[2]);
		
		c = new int[5];
		u = new int[5];
		// Left wing
		c[0] = x[9];
		u[0] = y[9] - (int)(shipHeight * 0.05);
		c[1] = x[10];
		u[1] = y[10] - (int)(shipHeight * 0.05);
		c[2] = x[11] - (int)(shipWidth * 0.05);
		u[2] = y[11];
		c[3] = x[12];
		u[3] = y[12] + (int)(shipHeight * 0.05);	
		c[4] = x[13];
		u[4] = y[13] + (int)(shipHeight * 0.05);
		
		g.drawPolygon(c, u, 5);
		g.drawLine(x[9], y[9], x[13], y[13]);
		
		// Head
		c = new int[8];
		u = new int[8];
		
		c[0] = x[14];
		u[0] = y[14];
		c[1] = x[14] - (int)(shipWidth * 0.0075);
		u[1] = y[14] + (int)(shipHeight * 0.075);
		c[2] = x[16] - (int)(shipWidth * 0.0075);
		u[2] = y[13] + (int)(shipHeight * 0.075);
		c[3] = x[17] + (int)(shipWidth * 0.0075);
		u[3] = y[13] + (int)(shipHeight * 0.075);	
		c[4] = x[19] + (int)(shipWidth * 0.0075);
		u[4] = y[19] + (int)(shipHeight * 0.075);
		c[5] = x[19];
		u[5] = y[19];
		c[6] = x[17];
		u[6] = y[13];
		c[7] = x[16];
		u[7] = y[13];
		g.drawPolygon(c, u, 8);
		g.drawLine(x[15], y[15], x[18], y[18]);
	}
}
