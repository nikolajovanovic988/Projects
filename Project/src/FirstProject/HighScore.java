package FirstProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class HighScore extends JPanel {
	
	private JTable table;
	private JPanel tPanel = new JPanel();
	
	private String[] columnNames = { "Id", "Score", "Name" };
	private String[][] data = new String[5][5];
	
	public HighScore() {
		
		
		
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
	    
	    JOptionPane.showMessageDialog(null, new JScrollPane(table));
	}
}
