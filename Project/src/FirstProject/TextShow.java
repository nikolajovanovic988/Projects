package FirstProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TextShow extends TextRD {

	private ArrayList<String> letter;
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
	
	private int fontSize;
	private Color color;
	
	// Constructor, it will just read file that will be shown in frame.
	
	public TextShow(String txtName) {
		super (txtName);
		letter = readFromFile();
		checkLetter = new boolean[letter.size()];
		y = new int[letter.size()];
	}
	
	// Set from where will text start and where it ends
	public void setCords(int startX, int startY, int endY, int fontSize, Color color) {
		this.startX = startX;
		this.startY = startY;
		this.endY = endY;
		this.fontSize = fontSize;
		this.color = color;
	}
	
	public void paintComponent(Graphics g) {
		printCheck();
		g.setFont(new Font("Arial",Font.PLAIN, fontSize));
		g.setColor(color);
		print(g);
		
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
}
