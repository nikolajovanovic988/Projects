package com.videogame.invasion.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TextRW {

	private String textName;

	public void setTextName(String textName) {
		this.textName = textName;
	}

	// Read file and send list of lines as ArrayList
	public ArrayList<String> readFromFile() {

		BufferedReader rd;
		ArrayList<String> arr = new ArrayList<String>();

		try {
			rd = new BufferedReader(new FileReader(textName));

			while (true) {
				String str = rd.readLine();
				if (str == null)
					break;
				arr.add(str);
			}
			rd.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		return arr;
	}

	// Write into file
	public void wrieIntoFile(String newLine) {

		ArrayList<String> arr = readFromFile();

		arr.add(newLine);

		PrintWriter wrf;

		try {
			wrf = new PrintWriter(new FileWriter(textName));

			for (int i = 0; i < arr.size(); i++) {
				if (i == 0) {
					wrf.print(arr.get(i));
				} else {
					wrf.print(System.lineSeparator() + "" + arr.get(i));
				}
			}

			wrf.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
