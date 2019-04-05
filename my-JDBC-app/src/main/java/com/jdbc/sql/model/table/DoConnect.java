package com.jdbc.sql.model.table;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//@Component
public class DoConnect {

	//@Autowired
	private DataSource dataSource;

	private Connection conn;
	private JdbcTemplate jdbcTemplate;

	public DoConnect() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/connect.xml");

		dataSource =  (DataSource) context.getBean("dataSource");
		
		((ClassPathXmlApplicationContext) context).close();
	}

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
