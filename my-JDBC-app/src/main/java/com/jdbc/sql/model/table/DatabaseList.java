package com.jdbc.sql.model.table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseList {

//	@Autowire
//	private DoConnect doConnect;
	private JdbcTemplate jdbcTemplate;
	private Connection conn;

	private ArrayList<String> databaseList;
	private String[] columnList = new String[] { "id", "Tables" };

	public DatabaseList(DoConnect doConnect) {
		// this.doConnect = doConnect;
		jdbcTemplate = doConnect.getJdbcTemplate();
		conn = doConnect.getConn();
	}

	public void newDatabase(String databaseName) {
		jdbcTemplate.update("CREATE DATABASE " + databaseName);
		JOptionPane.showMessageDialog(null, "You have created new database: " + databaseName);
	}

	public void deleteDatabase(String databaseName) {
		jdbcTemplate.update("DROP DATABASE " + databaseName);
		JOptionPane.showMessageDialog(null, "You have deleted database: " + databaseName);
	}

	// Return database list
	// FIX (return only non system databases)
	private ArrayList<String> getDatabaseList() {

		databaseList = new ArrayList<String>();

		try {

			DatabaseMetaData meta = conn.getMetaData();
			ResultSet result = meta.getCatalogs();

			while (result.next()) {
				databaseList.add(result.getString("TABLE_CAT"));
			}

			result.close();
			return databaseList;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return null;
	}

	// return 2d array of database list, it is used for table
	private String[][] getDBTable() {

		ArrayList<String> list = getDatabaseList();

		String[][] row = new String[list.size()][columnList.length];
		for (int i = 1; i < columnList.length; i++) {
			for (int j = 0; j < list.size(); j++) {

				row[j][i] = list.get(j);
			}
		}

		int num = 1;
		for (int i = 0; i < list.size(); i++) {
			row[i][0] = Integer.toString(num);
			num++;
		}

		return row;
	}

	public JTable getTable() {
		JTable table = new JTable(getDBTable(), columnList);
		return table;
	}

	public String[] getColumnList() {
		return columnList;
	}
	
}
