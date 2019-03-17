package com.videogame.invasion.model;

public class SaveHighScore extends TextRW{
	private String textFile = "HighScore.txt";
	
	public SaveHighScore() {
		setTextName(textFile);
	}
	
	public void saveScore(String score) {
		wrieIntoFile(score);
	}
}
