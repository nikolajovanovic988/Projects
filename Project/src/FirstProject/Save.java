package FirstProject;

import java.util.ArrayList;

public class Save extends TextRD {

	private ArrayList<String> load;
	
	public Save(String textName) {
		super(textName);
	}
	
	public void setSave() {
		
	}
	
	public void getSave() {
		load = readFromFile();
		
	}
}
