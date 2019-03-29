package com.jdbc.sql.model.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTable;


public class Select {

	private Connection conn;

	public Select(DoConnect doConnect) {
		System.out.println("TablesData");
		// this.doConnect = doConnect;
		conn = doConnect.getConn();
	}

	// return selected table column
	public String[] getTableColumnList(String columns) {

		ArrayList <String> str = new ArrayList<String>();
		
		StringTokenizer tokenizer = new StringTokenizer(columns,", ");
		while (tokenizer.hasMoreTokens()) {
			str.add(tokenizer.nextToken());
		}
		
		return str.toArray(new String[str.size()]);
	}

	// Return selected table rows
	private String[][] getTableRowList(String databaseName, String tableName, String columns) {

		String[] col = getTableColumnList(columns);
		int cn = columnNum(databaseName, tableName);// method that return a number of columns
		String[][] column = new String[cn][col.length];

		try {

			PreparedStatement statement;
			ResultSet result;

			for (int i = 0; i < col.length; i++) {

				int r = 0;
				statement = conn.prepareStatement("SELECT " + col[i] + " FROM " + databaseName + "." + tableName + "");
				result = statement.executeQuery();

				while (result.next()) {
					column[r][i] = result.getString(col[i]);
					r++;
				}

				result.close();
				statement.close();
			}

			return column;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	// return a number or rows for selected table
	private int columnNum(String databaseName, String tableName) {
		int num = 0;

		try {

			PreparedStatement statement = conn
					.prepareStatement("SELECT COUNT(*) FROM " + databaseName + "." + tableName);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				num = result.getInt("COUNT(*)");
			}

			result.close();
			statement.close();
			return num;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return num;
	}

	public JTable getTable(String databaseName, String tableName, String columns) {
		JTable table = new JTable(getTableRowList(databaseName, tableName, columns), getTableColumnList(columns));
		return table;
	}
}
