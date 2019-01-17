package FirstProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TextRD {

	private String txtName;
	
	public TextRD (String txtName) {
		this.txtName = txtName;
	}
	
	// Read file and send list of lines via ArrayList
	public ArrayList<String> readFromFile() {
		
		BufferedReader rd;
		ArrayList<String> arr = new ArrayList<String>();
		
		try {
			rd = new BufferedReader(new FileReader(txtName));
			
			while (true) {
				String str = rd.readLine();
				if (str == null) break;
				arr.add(str);
			}
			rd.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return arr;
	}
	
	// Write into file
	public void wrieIntoFile(String newScore) {
		
		ArrayList<String> arr = readFromFile();
		
		arr.add(newScore);
		
		PrintWriter wrf;
		
		try {
			wrf = new PrintWriter(new FileWriter(txtName));
			
			for (int i = 0; i < arr.size(); i++) {
				if (i == 0) {
					wrf.print(arr.get(i));
				} else {
					wrf.print(System.lineSeparator()+""+arr.get(i));
				}
			}
			
			wrf.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	
}
