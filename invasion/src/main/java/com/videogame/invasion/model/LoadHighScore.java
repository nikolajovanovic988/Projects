package com.videogame.invasion.model;

import java.util.ArrayList;

public class LoadHighScore extends TextRW {
	
	private String textFile = "HighScore.txt";
	private ArrayList<String> lines;

	public LoadHighScore() {
		setTextName(textFile);
	}

	public ArrayList<String> loadScore() {
		lines = readFromFile();
		sort(lines);
		return lines;
	}

	private void sort(ArrayList<String> list) {

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (Integer.parseInt(list.get(i).substring(0, list.get(i).indexOf(" "))) < Integer
						.parseInt(list.get(j).substring(0, list.get(j).indexOf(" ")))) {
					String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
	
}
