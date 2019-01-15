package FirstProject;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class HighScore extends TextRD {
	

	private JTable table;
	
	private String[] columnNames = { "Id", "Score", "Name" };
	private String[][] data;
	private ArrayList<String> lines = new ArrayList<String>();
	
	public HighScore(String txtName) {
		super(txtName);
	}
	
	public void setScore(String score) {
		wrieIntoFile(score);
	}
	
	public void showHighScore() {
		
		lines = readFromFile();
		
		setTable();
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(380,200));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		TableColumnModel columnModel = table.getColumnModel();
	    for (int i = 0; i < columnNames.length; i++) {
	        if (i < columnModel.getColumnCount()) {
	        	columnModel.getColumn(i).setMaxWidth(200);
	        	columnModel.getColumn(i).setMinWidth(120);
	        }
	        else break;
	    }
	    
		JScrollPane spane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    JOptionPane.showMessageDialog(null, spane);
	}
	
	private void setTable() {
		
		data = new String[lines.size()][3];
		
		sort(lines);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				
				if (j == 0) {
					data[i][j] = Integer.toString(i+1);
				} else if (j == 1){
					data[i][j] = lines.get(i).substring(0, lines.get(i).indexOf(" "));
				} else {
					data[i][j] = lines.get(i).substring(lines.get(i).indexOf(" "));
				}
			}
		}
		
	}
	
	private void sort(ArrayList<String> list) {
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				 
				if (Integer.parseInt(list.get(i).substring(0, list.get(i).indexOf(" "))) < Integer.parseInt(list.get(j).substring(0, list.get(j).indexOf(" ")))) {
					String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
			
		}
	}
	
}
