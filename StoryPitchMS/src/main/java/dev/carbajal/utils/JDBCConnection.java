package dev.carbajal.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

private static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			
			if (conn == null) {
				
				Class.forName("org.postgresql.Driver");
				
				Properties props = new Properties();
				InputStream input = JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties");
				
				props.load(input);
				
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				String currentSchema = props.getProperty("currentSchema");
				
				conn = DriverManager.getConnection(url, username, password);
				conn.setSchema(currentSchema);
				
				return conn;
			}
			
		} catch (SQLException | IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
}
