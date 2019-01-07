package FirstProject;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Communication {
	private Connection conn;
	private ArrayList<String> databaseList;
	private ArrayList<String> tableList;
	private boolean isconnected = false;
	
	// Do connect...
	public Communication(String IP, String username, String pass) throws Exception{
		
		try {
			
			String driver = "com.mysql.cj.jdbc.Driver"; // it works without this
			String URL = "jdbc:mysql://"+IP+":3306/?useSSL=false";
			
			Class.forName(driver); // it works without this
			
			conn = DriverManager.getConnection( URL, username, pass);
			isconnected = true;
		} catch (Exception e){
			JOptionPane.showMessageDialog( null, e.getMessage());
			isconnected = false;
		}
	}
	

	
	
	
	public void doSQLFunction(String action, String tableName, String databaseName, 
			String name, String datatype, 
			String condition, String conditionValue, String column, String value,
			String modifyName, String newName, String modifyDatatype,
			String updateColumnName, String updateColumnValue, String updateConditionColumnName, String updateConditionValue) {
		
		
		try {
			
			Statement statement = conn.createStatement();
			PreparedStatement st;
			
			switch (action) {
			
			case "CREATE": // create new database
				statement.executeUpdate("CREATE DATABASE "+ databaseName);
				statement.close();
				JOptionPane.showMessageDialog( null, "You have created new database: "+ databaseName);
				break;
			
			case "DELETE": // delete database
				statement.executeUpdate("DROP DATABASE "+databaseName);
				statement.close();
				JOptionPane.showMessageDialog( null, "You have deleted database: "+ databaseName);
				break;
				
			case "Create Tab.": // create new table
				statement.executeUpdate("CREATE TABLE "+ databaseName +"."+ tableName +"(id int)");
				statement.close();
				JOptionPane.showMessageDialog( null, "You have created table: " + tableName);
				break;
				
			case "Delete Tab.": // delete table
				statement.executeUpdate("DROP TABLE "+ databaseName +"."+ tableName);
				statement.close();
				JOptionPane.showMessageDialog( null, "You have deleted table: " + tableName);
				break;
			
			case "Add col.": // add new column
				if (!getDatabaseList().contains(databaseName) || !getArrayTableList(databaseName).contains(tableName)) {
					JOptionPane.showMessageDialog( null, "Your database name ot table name is wrong");
					return;
				}
				st = conn.prepareStatement("ALTER TABLE "+ databaseName + "."+ tableName +" ADD "+ name +
						" "+ datatype);
				st.executeUpdate();
				st.close();
				JOptionPane.showMessageDialog( null, "You have added a new column : " + name);
				break;
			
			case "Drop col.": // delete column
				if (!getDatabaseList().contains(databaseName) || !getArrayTableList(databaseName).contains(tableName)) {
					JOptionPane.showMessageDialog( null, "Your database name ot table name is wrong");
					return;
				}
				st= conn.prepareStatement("ALTER TABLE "+ databaseName + "."+ tableName +" DROP COLUMN "+ name);
				st.executeUpdate();
				st.close();
				JOptionPane.showMessageDialog( null, "You have deleted a new column : " + name);
				break;
				
			case "Delete": // delete row
				st = conn.prepareStatement("DELETE FROM "+ databaseName +"."+ tableName +" WHERE "
						+ condition +"='"+ conditionValue +"'");
				st.executeUpdate();
				st.close();
				break;
			
			case "Insert row": // insert new row
				st = conn.prepareStatement("INSERT INTO "+ databaseName +"."+ tableName +" ("+ column +
						") VALUES ('"+ value +"')");
				st.executeUpdate();
				st.close();
				break;
			
			case "Modify": // modify column
				if (!newName.equals("")) {
					statement.executeUpdate("ALTER TABLE "+ databaseName +"."+ tableName +" CHANGE "+ modifyName +" "+ newName +" "+ datatype);
					JOptionPane.showMessageDialog( null, "Column name "+ modifyName +" has changed to "+ newName);
				} else {
					statement.executeUpdate("ALTER TABLE "+ databaseName +"."+ tableName +" MODIFY COLUMN "+ modifyName +" "+ modifyDatatype);
					JOptionPane.showMessageDialog( null, "Column datatype has changed to: "+ modifyDatatype);
				}
				statement.close();
				break;
				
			case "Update col.": // update column
				st = conn.prepareStatement("UPDATE "+ databaseName +"."+ tableName +" SET "+ updateColumnName +
						" = '" + updateColumnValue +"' WHERE "+ updateConditionColumnName +" = "+ updateConditionValue);
				st.executeUpdate();
				
				st.close();
				break;
			
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, e.getMessage());
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

}
