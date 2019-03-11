package invasion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Save  {
	
	private String textName;
	
	public Save() {
		
	}
	
	public void setTextName(String textName) {
		this.textName = textName;
	}
	
	// write to txt file
	public void setSave(String[][] list) {
		
		PrintWriter wrf;
		
		try {
			wrf = new PrintWriter(new FileWriter(textName));
			
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
	
	//read from txt file
	public String[][] getSave() {
		
		BufferedReader rd;
		
		String[][] list = new String[4][10];
		int num = 0;
		try {
			rd = new BufferedReader(new FileReader(textName));
			
			while(true) {
				String line = rd.readLine();
				if (line == null) break;
				
				StringTokenizer tokenizer = new StringTokenizer(line);
				for(int i = 0; tokenizer.hasMoreTokens(); i++) {
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
