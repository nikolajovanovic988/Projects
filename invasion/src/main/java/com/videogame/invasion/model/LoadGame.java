package com.videogame.invasion.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class LoadGame {

	private String textFile = "Save_Load.txt";

	public LoadGame() {

	}

	public String[][] getLoad() {

		BufferedReader rd;

		String[][] list = new String[4][10];
		int num = 0;
		try {
			rd = new BufferedReader(new FileReader(textFile));

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;

				StringTokenizer tokenizer = new StringTokenizer(line);
				for (int i = 0; tokenizer.hasMoreTokens(); i++) {
					list[num][i] = tokenizer.nextToken();
				}
				num++;
			}

			rd.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return list;
	}
}
