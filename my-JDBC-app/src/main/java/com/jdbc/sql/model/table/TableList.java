package com.jdbc.sql.model.table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.jdbc.core.JdbcTemplate;

public class TableList {

//	@Autowired
//	private DoConnect doConnect;
	private Connection conn;
	private JdbcTemplate jdbcTemplate;

	private ArrayList<String> tableList;
	private String[] columnList = new String[] { "id", "Tables" };

	public TableList(DoConnect doConnect) {
		// this.doConnect = doConnect;
		jdbcTemplate = doConnect.getJdbcTemplate();
		conn = doConnect.getConn();
	}

	public void newTable(String databaseName, String tableName) {
		jdbcTemplate.update("CREATE TABLE " + databaseName + "." + tableName + "(id int)");
		JOptionPane.showMessageDialog(null, "You have created table: " + tableName);
	}

	public void deleteTable(String databaseName, String tableName) {
		jdbcTemplate.update("DROP TABLE " + databaseName + "." + tableName);
		JOptionPane.showMessageDialog(null, "You have deleted table: " + tableName);
	}

	// Return table list
	private ArrayList<String> getTableList(String databasename) {

		tableList = new ArrayList<String>();

		try {
			String[] types = { "TABLE" };
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet result = meta.getTables(databasename, null, "%", types);

			while (result.next()) {
				tableList.add(result.getString("TABLE_NAME"));
			}
			result.close();
			return tableList;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	// return 2d array of database list, it is used for table
	private String[][] getDBTable(String databasename) {

		ArrayList<String> list = getTableList(databasename);

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

	public JTable getTable(String databasename) {
		JTable table = new JTable(getDBTable(databasename), columnList);
		return table;
	}

	public String[] getColumnList() {
		return columnList;
	}

}
