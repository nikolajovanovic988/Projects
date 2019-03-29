package com.jdbc.sql.model.table;

public class Table {

	private DatabaseList databaseList;
	private TableList tableList;
	private TablesData tablesData;
	private Select select;

	public DatabaseList getDatabaseList() {
		return databaseList;
	}

	public void setDatabaseList(DatabaseList databaseList) {
		this.databaseList = databaseList;
	}

	public TableList getTableList() {
		return tableList;
	}

	public void setTableList(TableList tableList) {
		this.tableList = tableList;
	}

	public TablesData getTablesData() {
		return tablesData;
	}

	public void setTablesData(TablesData tablesData) {
		this.tablesData = tablesData;
	}

	public Select getSelect() {
		return select;
	}

	public void setSelect(Select select) {
		this.select = select;
	}

}
