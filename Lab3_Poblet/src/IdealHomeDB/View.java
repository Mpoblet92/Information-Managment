package IdealHomeDB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
public class View{
	private static Scanner in;
	public static void view() throws SQLException{
		Connection conn = null;
		Statement statement = null;
		String command = null;
		    try {
		    	 Class.forName("com.mysql.jdbc.Driver");
			      conn = IdealHomeDBConfig.getConnection();
			      in = new Scanner (System.in);
			      System.out.println();
			      System.out.println("Enter your Query:");
			      command = in.nextLine();
			      System.out.println();
			      System.out.println("Resutls:");
			      statement = conn.createStatement();
			      String query = command;
		        ResultSet rs = statement.executeQuery(query);
		        ResultSetMetaData rsmd = rs.getMetaData();
		        for(int c = 1; c<rsmd.getColumnCount();c++)
	        		System.out.print(rsmd.getColumnName(c) + " ");
		        System.out.println();
		        while (rs.next()) {
		        	int col = rsmd.getColumnCount();
		        	for(int i = 1; i<col; i++)
		        		System.out.print(rs.getString(i) + " ");
					System.out.println();
		        }
		        System.out.println();
		        System.out.println("-------------end---------------\n\n");
		    }  catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		       }
			}
	
	
