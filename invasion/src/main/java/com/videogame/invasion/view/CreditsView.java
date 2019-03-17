package com.videogame.invasion.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class CreditsView {

	private ArrayList<String> lines;
	private boolean[] checkLine;
	private int num = 0;
	private int y[]; // this is to keep track for every line that is moving.
	public int move = 0; // as move go up so will the line.
	
	private int startX;
	private int startY;
	private int endY;
	private int fontSize;
	private Color color;

	private boolean start = false;

	public void paintComponent(Graphics g) {
		printCheck();
		g.setFont(new Font("Arial", Font.PLAIN, fontSize));
		g.setColor(color);
		print(g);
	}

	// Set from where will text start and where it ends
	public void setCords(int startX, int startY, int endY, int fontSize, Color color) {
		this.startX = startX;
		this.startY = startY;
		this.endY = endY;
		this.fontSize = fontSize;
		this.color = color;
	}

	// Check if line is ready to be printed, and set it true if it is. "20" pixels
	// is the distance between two lines
	private void printCheck() {

		if (checkLine == null) {
			checkLine = new boolean[lines.size()];
			y = new int[lines.size()];
		}

		for (int i = num; i < lines.size(); i++) {
			if (move / 20 == i) {
				checkLine[i] = true;
			}
		}
	}

	// Print line according to printCheck. Print one line every 20 pixels.
	private void print(Graphics g) {
		for (int i = 0; i < checkLine.length; i++) {
			y[i] = move - i * 20;
			if (checkLine[i] == true) {
				g.drawString(lines.get(i), startX + 5, startY - y[i] - 3);
				if ((startY - y[i] - g.getFontMetrics().getAscent() - 1) < endY) {
					checkLine[i] = false;
				}
			}
		}
	}

	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

}
