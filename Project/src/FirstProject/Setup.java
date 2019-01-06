package FirstProject;

import java.awt.Color;
import java.awt.Graphics;

public class Setup {

	public int height;
	public int width;
	public int[] frameCords = new int[4];
	private int squareWidth;
	private int squareHeight; 
	
	public Setup() {
		
	}
	
	public void paintComponent(Graphics g) {
		//background(g);
		//floor(g);
		chair(g);
	
	}
	
	
	// 
	public void background (Graphics g) {
		g.drawLine(0, height/2, width, height/2);
		g.setColor(Color.CYAN);
		g.fillRect(0, height/2, width, height);
	}
	
	public void floor(Graphics g) {
		squareWidth = width / 20;
		squareHeight = (height / 2) / 5;
		g.setColor(Color.DARK_GRAY);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= 21; j++) {
				int[] x = new int [4];
				int[] y = new int [4];
				x[0] = j * squareWidth - i * 10;
				y[0] = height / 2 + ((i * squareHeight) + squareHeight/2);
				x[1] = x[0] + squareWidth/2 + 5;
				y[1] = y[0] - squareHeight/2;
				x[2] = x[1] + squareWidth/2 - 5;
				y[2] = y[1] + squareHeight/2;
				x[3] = x[2] - squareWidth/2 - 5;
				y[3] = y[2] + squareHeight/2;
				g.fillPolygon(x , y, 4);
			}
		}
	}
	
	// Draw chair in middle of room
	public void chair (Graphics g) {
		
		// Back part
		g.setColor(new Color(140,101,41));
		g.fillRect(width/2 - 45, height/2 -40, 50, 8); // top middle rect 
		g.fillRect(width/2 - 45, height/2 -20, 50, 8); // bottom middle rect
		g.setColor(new Color(90,51,3));
		g.drawRect(width/2 - 45, height/2 -40, 50, 8); // top middle rect 
		g.drawRect(width/2 - 45, height/2 -20, 50, 8); // bottom middle rect
		
		g.setColor(new Color(140,101,41));
		g.fillRoundRect(width/2 - 45, height/2 -50, 8, 80, 10, 10); // left rect
		g.fillRoundRect(width/2 + 5, height/2 -50, 8, 80, 10, 10); // right rect
		g.setColor(new Color(90,51,3));
		g.drawRoundRect(width/2 - 45, height/2 -50, 8, 80, 10, 10); // left rect
		g.drawRoundRect(width/2 + 5, height/2 -50, 8, 80, 10, 10); // right rect
		
		// Legs
		//back
		g.setColor(new Color(140,101,41));
		g.fillRect(width/2 - 45, height/2 + 25, 8, 55); // left
		g.fillRect(width/2 + 5, height/2 + 25, 8, 55); // left
		g.setColor(new Color(90,51,3));
		g.drawRect(width/2 - 45, height/2 + 25, 8, 55); // right
		g.drawRect(width/2 + 5, height/2 + 25, 8, 55); // right
		//front
		g.setColor(new Color(140,101,41));
		g.fillRect(width/2 - 40, height/2 + 60, 8, 55); // left
		g.fillRect(width/2 + 10, height/2 + 60, 8, 55); // left
		g.setColor(new Color(90,51,3));
		g.drawRect(width/2 - 40, height/2 + 60, 8, 55); // right
		g.drawRect(width/2 + 10, height/2 + 60, 8, 55); // right
		
		// Sitting part
		int[] x = new int[4];
		int[] y = new int[4];
		x[0] = width/2 - 45;
		y[0] = height/2 +25;
		x[1] = x[0] + 58;
		y[1] = y[0];
		x[2] = x[1] + 5;
		y[2] = y[1] + 35;
		x[3] = x[2] - 58;
		y[3] = y[2] + 0;
		
		g.setColor(new Color(140,101,41));
		g.fillPolygon(x, y, 4); // Siting board
		g.setColor(new Color(90,51,3));
		g.drawPolygon(x, y, 4); // Siting board
		
		g.setColor(new Color(140,101,41));
		g.fillRect(width/2 - 40, height/2 + 60, 58, 8); // height of sitting board
		g.setColor(new Color(90,51,3));
		g.drawRect(width/2 - 40, height/2 + 60, 58, 8); // height of sitting board
		
		x[0] = width/2  - 45;
		y[0] = height/2 + 25;
		x[1] = x[0] + 5;
		y[1] = y[0] + 40;
		x[2] = x[1];
		y[2] = y[1] + 8;
		x[3] = x[0];
		y[3] = y[0] + 8;
		
		g.drawPolygon(x, y, 4); // width of sitting board
	}
	
}
