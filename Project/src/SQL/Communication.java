package SQL;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;

public class Communication {
	
	
	
	
	private ArrayList<String> databaseList;
	private ArrayList<String> tableList;
	private boolean isconnected;
	
	private DoConnect doConnect;
	private JdbcTemplate jdbcTemplate;
	private Connection conn;

	public Communication() {
		
	}
	public void startConnection() {
		jdbcTemplate = doConnect.getJdbcTemplate();
		conn = doConnect.getConn();
		isconnected = true;
	}
	
	public void doSQLFunction(String action, String tableName, String databaseName, 
			String name, String datatype, 
			String condition, String conditionValue, String column, String value,
			String modifyName, String newName, String modifyDatatype,
			String updateColumnName, String updateColumnValue, String updateConditionColumnName, String updateConditionValue) {
	
		switch (action) {
		
			case "CREATE": // create new database
				
				jdbcTemplate.update("CREATE DATABASE "+ databaseName);
				JOptionPane.showMessageDialog( null, "You have created new database: "+ databaseName);
				
				break;
			
			case "DELETE": // delete database
				
				jdbcTemplate.update("DROP DATABASE "+databaseName);
				JOptionPane.showMessageDialog( null, "You have deleted database: "+ databaseName);
				
				break;
				
			case "Create Tab.": // create new table
				
				jdbcTemplate.update("CREATE TABLE "+ databaseName +"."+ tableName +"(id int)");
				JOptionPane.showMessageDialog( null, "You have created table: " + tableName);
				
				break;
				
			case "Delete Tab.": // delete table
				
				jdbcTemplate.update("DROP TABLE "+ databaseName +"."+ tableName);
				JOptionPane.showMessageDialog( null, "You have deleted table: " + tableName);
				
				break;
			
			case "Add col.": // add new column
				if (!getDatabaseList().contains(databaseName) || !getArrayTableList(databaseName).contains(tableName)) {
					JOptionPane.showMessageDialog( null, "Your database name ot table name is wrong");
					return;
				}
				
				jdbcTemplate.update("ALTER TABLE "+ databaseName + "."+ tableName +" ADD "+ name +" "+ datatype);
				JOptionPane.showMessageDialog( null, "You have added a new column : " + name);
				
				break;
			
			case "Drop col.": // delete column
				if (!getDatabaseList().contains(databaseName) || !getArrayTableList(databaseName).contains(tableName)) {
					JOptionPane.showMessageDialog( null, "Your database name ot table name is wrong");
					return;
				}
				
				jdbcTemplate.update("ALTER TABLE "+ databaseName + "."+ tableName +" DROP COLUMN "+ name);
				JOptionPane.showMessageDialog( null, "You have deleted a new column : " + name);
				
				break;
				
			case "Delete": // delete row
				
				jdbcTemplate.update("DELETE FROM "+ databaseName +"."+ tableName +" WHERE "
						+ condition +"= ?", conditionValue);
				
				break;
			
			case "Insert row": // insert new row
				
				jdbcTemplate.update("INSERT INTO "+ databaseName +"."+ tableName +" ("+ column +
						") VALUES (?)", value);
				
				break;
			
			case "Modify": // modify column
				if (!newName.equals("")) {
					jdbcTemplate.update("ALTER TABLE "+ databaseName +"."+ tableName +" CHANGE "+ modifyName +" "+ newName +" "+ datatype);
					JOptionPane.showMessageDialog( null, "Column name "+ modifyName +" has changed to "+ newName);
				} else {
					jdbcTemplate.update("ALTER TABLE "+ databaseName +"."+ tableName +" MODIFY COLUMN "+ modifyName +" "+ modifyDatatype);
					JOptionPane.showMessageDialog( null, "Column datatype has changed to: "+ modifyDatatype);
				}
				
				break;
				
			case "Update col.": // update column
				
				jdbcTemplate.update("UPDATE "+ databaseName +"."+ tableName +" SET "+ updateColumnName +
						" = ? WHERE "+ updateConditionColumnName +" = ?", updateColumnValue, updateConditionValue);
				
				break;
		
		}
		
	}
	
	// to check if connection is made 
	public boolean isConnected() {
		return isconnected;
	}
	
	// Return database list
	// FIX (return only non system databases)
	public ArrayList<String> getDatabaseList() {
		
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
			JOptionPane.showMessageDialog( null, e.getMessage());
		}
		
		return null;
	}
	
	// Return table list
	public ArrayList<String> getArrayTableList(String databasename) {
			
		tableList = new ArrayList<String>();
			
		try {
			String[] types = {"TABLE"};
		DatabaseMetaData meta = conn.getMetaData();
		ResultSet result = meta.getTables(databasename, null, "%", types);
				
		while (result.next()) {
			tableList.add(result.getString("TABLE_NAME"));
		}
			result.close();
			return tableList;
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e.getMessage());
		}
		return null;
	}
	
	// return selected table row
	public String[] getTableColumnList(String tableName, String databaseName) {
			
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM "+ databaseName +
					"."+ tableName +"");
			ResultSet result = statement.executeQuery();
				
			ResultSetMetaData meta = result.getMetaData();
			int count = meta.getColumnCount();
			String[] columnName = new String[count];
				
			for (int i = 1; i <= count; i++) {
				columnName[i-1] = meta.getColumnName(i);
			}
				
			result.close();
			statement.close();
			return columnName;
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e.getMessage());
		}
		return null;
	}
	
	// Return selected table columns
	public String[][] getTableRowList(String tableName, String databaseName, String[] columnNames) {
			
		String[] col = columnNames;
		int rw = rowNum( tableName, databaseName);//metod that return a num of colums
		String[][] column = new String[rw][col.length];
		
		try {
			
			PreparedStatement statement;
			ResultSet result;
			
			for (int i = 0; i < col.length; i++) {
						
				int r = 0;
				statement = conn.prepareStatement("SELECT "+ col[i] +" FROM "+ databaseName +
						"."+ tableName +"");
				result = statement.executeQuery();
						
				while (result.next()){
					column[r][i] = result.getString(col[i]);
					r++;
				}
						
				result.close();
				statement.close();
			}
			
			return column;
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e.getMessage());
		}
		return null;
	}
	
	// return 2d array of table list or database list, it is used for table
	public String [][] getTableList (ArrayList<String> list, int column){
		String[][] row = new String[list.size()][column];
		for (int i = 1; i < column; i++) {
			for(int j = 0; j < list.size(); j++) {
					
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
	
	// return a number or rows for selected table
	private int rowNum(String tableName, String databaseName) {
		int num = 0;
			
		try {
				
			PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM "+ databaseName +
					"."+ tableName);
			ResultSet result = statement.executeQuery();
				
			while(result.next()) {
				num = result.getInt("COUNT(*)");
			}
				
			result.close();
			statement.close();
			return num;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e.getMessage());
		}
			
		return num;
	}

	public DoConnect getDoConnect() {
		return doConnect;
	}

	public void setDoConnect(DoConnect doConnect) {
		this.doConnect = doConnect;
	}
	
}
