package FirstProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Frame {
	
	private BufferedReader rd;
	private ArrayList<String> letter = new ArrayList<String>();
	private boolean[] checkLetter; // to check if line is ready to be printed;
	private int num = 0; // the num is number of lines that are printing;
	
	private int startX;
	private int startY;
	//private int endX;
	private int endY;
	private int y[]; // this is to keep track for every line that is moving.
	public int move = 0; // as move go up so will the line.
	
	public int height;
	public int width;
	
	// Constructor, it will just read file that will be shown in frame.
	public Frame() {
		readFromFile();
	}
	
	public void setCords() {
		startX = width/2 + 80;
		startY = height/2 + 10;
		// endX = width/2 + 90;
		endY = height/2 - 170;
	}
	
	// Read file where is letter
	public void readFromFile() {
		
		try {
			rd = new BufferedReader(new FileReader("Propratno pismo.txt"));
			
			while (true) {
				String str = rd.readLine();
				if (str == null) break;
				letter.add(str);
			}
			rd.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		checkLetter = new boolean[letter.size()];
		y = new int[letter.size()];
	}
	
	public void paintComponent(Graphics g) {
		printCheck();
		g.setFont(new Font("Arial",Font.PLAIN, 16));
		g.setColor(Color.BLACK);
		print(g);
		g.setColor(new Color(255,254,166));
		drawFame(g);
	}
	
	// Check if line is ready to be printed, and set it true if it is. "15" pixels distance will be from two lines
	private void printCheck() {
		for(int i = num; i < letter.size(); i++) {
			if (move / 20 == i) {
				checkLetter[i] = true;
			}
		}
	}
	
	// Print line according to printCheck. Print one line every 20 pixels.
	private void print(Graphics g) {
		for (int i = 0; i < checkLetter.length; i++) {
			y[i] = move - i*20;
			if (checkLetter[i] == true) {
				g.drawString(letter.get(i), startX + 5, startY - y[i] - 3);
				if ((startY - y[i] - g.getFontMetrics().getAscent() - 1) < endY) {
					checkLetter[i] = false;
				}
			}
		}
	}
	
	// Paint frame where will be my cover letter
	public void drawFame(Graphics g) {
		g.fillRoundRect(width/2 + 60, height/2 - 170, 320, 20,10,10); // top
		g.fillRoundRect(width/2 + 60, height/2 - 170, 20, 180,10,10); // left
		g.fillRoundRect(width/2 + 60, height/2 -10, 320, 20,10,10); // bottom
		g.fillRoundRect(width/2 + 370, height/2 - 170, 20, 180,10,10); // right
		g.setColor(Color.BLACK);
		g.drawRoundRect(width/2 + 60, height/2 - 170, 330, 180, 10 ,10); // inside
		g.drawRoundRect(width/2 + 80, height/2 - 150, 290, 140, 10 ,10); // outside
	}
}
