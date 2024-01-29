package infra;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionFactory {
	
	public static Connection getConnection() {
		try {
			Properties properties = new Properties();
			properties.load(ConnectionFactory.class.getResourceAsStream("/resources/connection.properties"));
			
			String dbUrl = properties.getProperty("db.url");
			String dbUser = properties.getProperty("db.user");
			String dbPassword = properties.getProperty("db.password");
			
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
