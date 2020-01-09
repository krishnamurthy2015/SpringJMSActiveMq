package com.example.jms.SpringBootJMSTest.Config;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBCPDataSource {
	private static final Logger log = LoggerFactory.getLogger(DBCPDataSource.class);
	 private static BasicDataSource ds = new BasicDataSource();
	
	    static {
	        ds.setUrl("jdbc:h2:file:~/test");
	        ds.setUsername("sa");
	        ds.setPassword("");
	        ds.setMinIdle(5);
	        ds.setMaxIdle(10);
	        ds.setMaxOpenPreparedStatements(100);
	    }
	     
	    public static Connection getConnection() throws SQLException {
	        return ds.getConnection();
	    }
	     
	    private DBCPDataSource(){ }
	
}
