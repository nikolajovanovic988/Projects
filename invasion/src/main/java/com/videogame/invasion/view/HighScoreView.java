package com.videogame.invasion.view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class HighScoreView {

	private JTable table;

	private String[] columnNames = { "Id", "Score", "Name" };
	private String[][] data;
	private ArrayList<String> lines;

	public HighScoreView() {

	}

	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}

	public void showHighScore() {

		setTable();
		showTable();

	}

	private void setTable() {

		data = new String[lines.size()][3];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {

				if (j == 0) {
					data[i][j] = Integer.toString(i + 1);
				} else if (j == 1) {
					data[i][j] = lines.get(i).substring(0, lines.get(i).indexOf(" "));
				} else {
					data[i][j] = lines.get(i).substring(lines.get(i).indexOf(" "));
				}
			}
		}
	}

	private void showTable() {
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(380, 200));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < columnNames.length; i++) {
			if (i < columnModel.getColumnCount()) {
				columnModel.getColumn(i).setMaxWidth(200);
				columnModel.getColumn(i).setMinWidth(120);
			} else
				break;
		}

		JScrollPane spane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JOptionPane.showMessageDialog(null, spane);
	}
}
