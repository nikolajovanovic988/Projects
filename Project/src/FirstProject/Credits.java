package FirstProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Credits {
	
	private BufferedReader rd;
	private ArrayList<String> letter = new ArrayList<String>();
	private boolean[] checkLetter; // to check if line is ready to be printed;
	
	public Credits() {
		readFromFile();
	}
	
	private void readFromFile() {
		
		try {
			rd = new BufferedReader(new FileReader("Credits.txt"));
			
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
	}
	
	public void paintComponent (Graphics g) {
		g.setFont(new Font("Arial",Font.PLAIN, 16));
		g.setColor(Color.WHITE);
		print(g);
	}
	
	private void print(Graphics g) {
		
	}
}
