package com.jdbc.sql.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DoConnect {

	@Autowired
	private DataSource dataSource;
	
	private Connection conn;
	private JdbcTemplate jdbcTemplate;

//	public DoConnect() {
//		try {
//			conn = dataSource.getConnection();
//			jdbcTemplate = new JdbcTemplate(dataSource);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConn() {
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public JdbcTemplate getJdbcTemplate() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

}
