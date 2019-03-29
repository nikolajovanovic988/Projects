package com.jdbc.sql.model.table;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbc.sql.controller.Controller;
import com.jdbc.sql.view.Frame;

//@Component
public class DoConnect {

//	public static DoConnect instance = new DoConnect();

	//@Autowired
	private DataSource dataSource;

	private Connection conn;
	private JdbcTemplate jdbcTemplate;

	public DoConnect() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/connect.xml");

		dataSource =  (DataSource) context.getBean("dataSource");
		
		((ClassPathXmlApplicationContext) context).close();
	}
	
//	public DoConnect getInstance() {
//		return instance;
//	}

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
		System.out.println("DataSource");
	}

	public Connection getConn() {
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public JdbcTemplate getJdbcTemplate() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

}
