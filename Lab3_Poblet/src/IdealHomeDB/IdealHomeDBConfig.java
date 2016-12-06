package IdealHomeDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IdealHomeDBConfig {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Poblet@5510@4035";
	private static final String CONN_STRING = "jdbc:mysql://localhost/idealhome?useSSL=false";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}
	public static void displayException(SQLException ex){
		System.err.println("Error Message: " + ex.getMessage());
		System.err.println("Error Code: " + ex.getErrorCode());
		System.err.println("SQL Status: " + ex.getSQLState());

	}
}
