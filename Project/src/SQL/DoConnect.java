package SQL;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DoConnect {

	private DataSource dataSource;
	private Connection conn;
	private JdbcTemplate jdbcTemplate;
	
	public DoConnect() throws SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/beanPackage/connect.xml");
		dataSource = (DataSource)context.getBean("dataSource");
		jdbcTemplate = new JdbcTemplate(dataSource);
		conn = dataSource.getConnection();
		
		((ClassPathXmlApplicationContext) context).close();
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
