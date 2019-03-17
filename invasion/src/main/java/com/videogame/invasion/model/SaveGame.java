package com.videogame.invasion.model;

import java.io.FileWriter;
import java.io.PrintWriter;

public class SaveGame{

	private String textFile = "Save_Load.txt";

	public SaveGame() {
		
	}
	
	public void setSave(String[][] list) {
		
		PrintWriter wrf;
		
		try {
			wrf = new PrintWriter(new FileWriter(textFile));
			
			for (int i = 0; i < list.length; i++) {
				for (int j = 0; j < list[0].length; j++) {
			
					if (j == list[0].length - 1) {
						wrf.print( list[i][j] +""+ System.lineSeparator());
					} else {
						wrf.print( list[i][j] +" ");
					}
				}
			}
			
			wrf.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
