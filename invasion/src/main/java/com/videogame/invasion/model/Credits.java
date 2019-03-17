package com.videogame.invasion.model;

import java.util.ArrayList;

public class Credits extends TextRW{
	
	private String textFile = "Credits.txt";
	private ArrayList<String> lines;
	
	public Credits() {
		setTextName(textFile);
	}
	
	public ArrayList<String> getText() {
		lines = readFromFile();
		return lines;
	}
}
