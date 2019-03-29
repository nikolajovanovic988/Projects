package com.jdbc.sql.model.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.jdbc.core.JdbcTemplate;

public class TablesData {

//	@Autowired
//	private DoConnect doConnect;
	private Connection conn;
	private JdbcTemplate jdbcTemplate;

	public TablesData(DoConnect doConnect) {
		// this.doConnect = doConnect;
		jdbcTemplate = doConnect.getJdbcTemplate();
		conn = doConnect.getConn();
	}

	public void addColumn(String databaseName, String tableName, String name, String datatype) {
		jdbcTemplate.update("ALTER TABLE " + databaseName + "." + tableName + " ADD " + name + " " + datatype);
		JOptionPane.showMessageDialog(null, "You have added a new column : " + name);
	}

	public void updateColumn(String databaseName, String tableName, String updateColumnName,
			String updateConditionColumnName, String updateColumnValue, String updateConditionValue) {
		jdbcTemplate.update("UPDATE " + databaseName + "." + tableName + " SET " + updateColumnName + " = ? WHERE "
				+ updateConditionColumnName + " = ?", updateColumnValue, updateConditionValue);

	}

	public void deleteColumn(String databaseName, String tableName, String name) {
		jdbcTemplate.update("ALTER TABLE " + databaseName + "." + tableName + " DROP COLUMN " + name);
		JOptionPane.showMessageDialog(null, "You have deleted a new column : " + name);
	}

	public void insertRow(String databaseName, String tableName, String column, String value) {
		jdbcTemplate.update("INSERT INTO " + databaseName + "." + tableName + " (" + column + ") VALUES (?)", value);
	}

	public void deleteRow(String databaseName, String tableName, String condition, String conditionValue) {
		jdbcTemplate.update("DELETE FROM " + databaseName + "." + tableName + " WHERE " + condition + "= ?",
				conditionValue);
	}

	public void modify(String databaseName, String tableName, String modifyName, String newName, String datatype,
			String modifyDatatype) {
		if (!newName.equals("")) {
			jdbcTemplate.update("ALTER TABLE " + databaseName + "." + tableName + " CHANGE " + modifyName + " "
					+ newName + " " + datatype);
			JOptionPane.showMessageDialog(null, "Column name " + modifyName + " has changed to " + newName);
		} else {
			jdbcTemplate.update("ALTER TABLE " + databaseName + "." + tableName + " MODIFY COLUMN " + modifyName + " "
					+ modifyDatatype);
			JOptionPane.showMessageDialog(null, "Column datatype has changed to: " + modifyDatatype);
		}
	}

	// return selected table column
	public String[] getTableColumnList(String databaseName, String tableName) {

		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + databaseName + "." + tableName + "");
			ResultSet result = statement.executeQuery();

			ResultSetMetaData meta = result.getMetaData();
			int count = meta.getColumnCount();
			String[] columnName = new String[count];

			for (int i = 1; i <= count; i++) {
				columnName[i - 1] = meta.getColumnName(i);
			}

			result.close();
			statement.close();
			return columnName;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	// Return selected table rows
	public String[][] getTableRowList(String databaseName, String tableName) {

		String[] col = getTableColumnList(databaseName, tableName);
		int  cn = columnNum(databaseName, tableName);// method that return a number of columns
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
	
	public JTable getTable(String databaseName, String tableName) {
		String[] column = getTableColumnList(databaseName, tableName);
		JTable table = new JTable(getTableRowList(databaseName, tableName),column);
		return table;
	}
}
