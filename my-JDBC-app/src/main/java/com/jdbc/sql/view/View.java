package com.jdbc.sql.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

public class View extends JPanel implements ActionListener {

	public JButton ok;
	public JButton createDB;
	public JButton deleteDB;
	public JButton getDBList;
	public JTextField databaseField;
	public JLabel databaseLabel;

	public JButton connect;

	public JPanel connectPanel = new JPanel(); // top panel
	public JPanel tablePanel = new JPanel(); // middle panel
	public JPanel selectPanel = new JPanel(); // bottom panel

	public JPanel leftTablePanel = new JPanel(); // middle left panel
	public JPanel panel1 = new JPanel();
	public JButton selectTable, createTable, deleteTable;
	public JTextField tableField;
	public JPanel panel2 = new JPanel();
	public JButton add, drop;
	public JComboBox<String> dataTypeAdd;
	public JTextField columnField;
	public JPanel panel3 = new JPanel();
	public JButton modify;
	public JTextField modifyField, modifyFieldNew;
	public JComboBox<String> dataTypeModify;
	public JPanel panel4 = new JPanel();
	public JTextField columnNameUpdate, columnValue;
	public JPanel panel5 = new JPanel();
	public JButton update;
	public JTextField conditionNameUpdate, conditionValue;
	public JPanel panel6 = new JPanel();
	public JTextField rowCondition, rowValue;
	public JButton deleteRow;
	public JButton insert;

	public JPanel rightTablePanel = new JPanel(); // middle right panel
	public JTable table;

	public JPanel select1 = new JPanel();
	public JButton getDB, getTableList, showTable;
	public JTextField getTableDBListField, showTableField;
	public JPanel select2 = new JPanel();
	public JButton getTable;
	public JTextField colimnListSelect;

	public String[] column; // get list of column names
	public String[][] row; // get 2d list of table data
	public String[] columnDatabase = new String[] { "id", "Databases" }; // setup for begining
	public String[] columnTables = new String[] { "id", "Tables" }; // setup for begining

	public static String IP;
	public static String username;
	public static String pass;

	// public Communication conn;
	public ArrayList<String> databaseList;
	public ArrayList<String> tableList;

	public View() {

		setBackground(Color.GRAY);
		setLayout(new FlowLayout());

		setDatabasePanel();
		tablePanel();
		selectPanel();

		add(connectPanel, BorderLayout.PAGE_START);
		add(tablePanel, BorderLayout.CENTER);
		add(selectPanel, BorderLayout.PAGE_END);

	}

	// first panel, -- chose, create and delete database -
	public void setDatabasePanel() {

		connect = new JButton("Connect");
		connect.addActionListener(this);
		ok = new JButton("OK");
		ok.setEnabled(false);
		createDB = new JButton("CREATE");
		createDB.setEnabled(false);
		deleteDB = new JButton("DELETE");
		deleteDB.setEnabled(false);
		getDBList = new JButton("Get DB list");
		getDBList.setEnabled(false);
		databaseField = new JTextField(15);
		databaseField.setToolTipText("Database field");
		databaseField.setEnabled(false);
		databaseLabel = new JLabel("Chose database:");

		ok.addActionListener(this);
		databaseField.addActionListener(this);
		createDB.addActionListener(this);
		deleteDB.addActionListener(this);
		getDBList.addActionListener(this);

		connectPanel.add(connect);
		connectPanel.add(databaseLabel);
		connectPanel.add(databaseField);
		connectPanel.add(ok);
		connectPanel.add(createDB);
		connectPanel.add(deleteDB);
		connectPanel.add(getDBList);

	}

	// second panel, -- work whit tables, show table, and show lists --
	public void tablePanel() {

		leftTablePanel.setLayout(new GridLayout(6, 1, 2, 2));

		panel4.setBackground(Color.GRAY);
		panel5.setBackground(Color.GRAY);
		leftTablePanel.setBackground(Color.GRAY);

		leftTablePanel.add(panel1);
		leftTablePanel.add(panel2);
		leftTablePanel.add(panel3);
		leftTablePanel.add(panel4);
		leftTablePanel.add(panel5);
		leftTablePanel.add(panel6);

		panelOne();
		panelTwo();
		panelThree();
		panelFour();
		panelFive();
		panelSix();

		setTable(new String[][] { { "1", "" } }, new String[] { "id", "Name" });

		tablePanel.add(leftTablePanel);
		tablePanel.add(rightTablePanel);

	}

	public void selectPanel() {

		selectPanel.setLayout(new GridLayout(6, 1, 5, 5));
		selectPanel.add(select1);
		selectPanel.add(select2);

		selectOne();
		selectTwo();

	}

	// DB and Table lists -- Select panel
	public void selectOne() {

		getDB = new JButton("Get DB list");
		getTableList = new JButton("Get table list");
		showTable = new JButton("Show table");

		getDB.addActionListener(this);
		getTableList.addActionListener(this);
		showTable.addActionListener(this);
		getDB.setEnabled(false);
		getTableList.setEnabled(false);
		showTable.setEnabled(false);

		getTableDBListField = new JTextField(6);
		showTableField = new JTextField(6);

		getTableDBListField.addActionListener(this);
		showTableField.addActionListener(this);
		getTableDBListField.setEnabled(false);
		showTableField.setEnabled(false);

		select1.add(getDB);
		select1.add(new JLabel("Enter DB name:"));
		select1.add(getTableDBListField);
		select1.add(getTableList);
		select1.add(new JLabel("Enter table name"));
		select1.add(showTableField);
		select1.add(showTable);

	}

	// Select columns -- Select Panel
	public void selectTwo() {

		getTable = new JButton("Get table");
		colimnListSelect = new JTextField(30);
		colimnListSelect.setToolTipText("Enter column names you want to see");

		getTable.addActionListener(this);
		colimnListSelect.addActionListener(this);
		getTable.setEnabled(false);
		colimnListSelect.setEnabled(false);

		select2.add(new JLabel("Enter name of colums you want to be displayed"));
		select2.add(colimnListSelect);
		select2.add(getTable);

	}

	// Table panel -- Left table panel
	public void panelOne() {

		tableField = new JTextField(8);
		tableField.setToolTipText("Table field");
		selectTable = new JButton("Select");
		createTable = new JButton("Create Tab.");
		deleteTable = new JButton("Delete Tab.");

		tableField.addActionListener(this);
		selectTable.addActionListener(this);
		createTable.addActionListener(this);
		deleteTable.addActionListener(this);
		tableField.setEnabled(false);
		selectTable.setEnabled(false);
		createTable.setEnabled(false);
		deleteTable.setEnabled(false);

		panel1.add(tableField);
		panel1.add(selectTable);
		panel1.add(createTable);
		panel1.add(deleteTable);

	}

	// Column panel -- Left table panel
	public void panelTwo() {
		columnField = new JTextField(8);
		columnField.setToolTipText("Column field");
		add = new JButton("Add col.");
		drop = new JButton("Drop col.");

		dataTypeAdd = new JComboBox<String>();
		dataTypeAdd.addItem("varchar(255)");
		dataTypeAdd.addItem("int");
		dataTypeAdd.addItem("date");

		columnField.addActionListener(this);
		add.addActionListener(this);
		dataTypeAdd.addActionListener(this);
		drop.addActionListener(this);
		columnField.setEnabled(false);
		add.setEnabled(false);
		dataTypeAdd.setEnabled(false);
		drop.setEnabled(false);

		panel2.add(columnField);
		panel2.add(dataTypeAdd);
		panel2.add(add);
		panel2.add(drop);

	}

	// Modify column panel -- Left table panel
	public void panelThree() {

		modify = new JButton("Modify");
		modifyField = new JTextField(5);
		modifyField.setToolTipText("Enter column name you want to modify");
		modifyFieldNew = new JTextField(5);
		modifyFieldNew.setToolTipText("Enter new name for column");

		dataTypeModify = new JComboBox<String>();
		dataTypeModify.addItem("varchar(255)");
		dataTypeModify.addItem("int");
		dataTypeModify.addItem("date");

		modify.addActionListener(this);
		modify.setEnabled(false);
		modifyField.setEnabled(false);
		modifyFieldNew.setEnabled(false);
		dataTypeModify.setEnabled(false);

		panel3.add(new JLabel("Change"));
		panel3.add(modifyField);
		panel3.add(new JLabel("To"));
		panel3.add(modifyFieldNew);

		panel3.add(dataTypeModify);
		panel3.add(modify);
	}

	// Update panel, change value -- Left table panel
	public void panelFour() {

		columnNameUpdate = new JTextField(6);
		columnNameUpdate.setToolTipText("Enter column name you want to modify");
		columnValue = new JTextField(6);
		columnValue.setToolTipText("Enter value you want to put");

		columnNameUpdate.setEnabled(false);
		columnValue.setEnabled(false);

		panel4.add(new JLabel("Set column"));
		panel4.add(columnNameUpdate);
		panel4.add(new JLabel(", value for column"));
		panel4.add(columnValue);

	}

	// Update panel, change value -- Left table panel
	public void panelFive() {

		conditionNameUpdate = new JTextField(6);
		conditionNameUpdate.setToolTipText("Enter column name for condition ");
		conditionValue = new JTextField(6);
		conditionValue.setToolTipText("Enter condition");

		update = new JButton("Update col.");

		update.addActionListener(this);
		update.setEnabled(false);
		conditionNameUpdate.setEnabled(false);
		conditionValue.setEnabled(false);

		panel5.add(new JLabel("Where"));
		panel5.add(conditionNameUpdate);
		panel5.add(new JLabel("is:"));
		panel5.add(conditionValue);
		panel5.add(update);
	}

	// Row panel -- Left table panel
	public void panelSix() {

		deleteRow = new JButton("Delete");
		insert = new JButton("Insert row");

		rowCondition = new JTextField(6);
		rowCondition.setToolTipText("Enter column name");
		rowValue = new JTextField(6);
		rowValue.setToolTipText("Enter value of column");

		deleteRow.addActionListener(this);
		insert.addActionListener(this);
		deleteRow.setEnabled(false);
		insert.setEnabled(false);
		rowCondition.setEnabled(false);
		rowValue.setEnabled(false);

		panel6.add(new JLabel("Where"));
		panel6.add(rowCondition);
		panel6.add(new JLabel("is:"));
		panel6.add(rowValue);
		panel6.add(deleteRow);
		panel6.add(insert);

	}

	public void setTable(String[][] data, String[] columnNames) {

		if (table != null)
			rightTablePanel.removeAll();

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

		rightTablePanel.add(spane);
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
