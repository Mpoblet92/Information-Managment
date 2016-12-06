package IdealHomeDB;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
public class MetaData{
	public static void meta() throws SQLException{
		String catalog = null;
		String patternScheme = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] type = null;
		Connection connector = null;
		ResultSet Results = null;
		ResultSet ResultsName = null;
		try {
		    	Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("Establishing database connection!");
			    System.out.println();
			    connector = IdealHomeDBConfig.getConnection();
			    DatabaseMetaData databaseMetaData = connector.getMetaData();
			    System.out.println("Tables List");
				System.out.println("--------------");
				ResultsName = databaseMetaData.getTables(catalog, patternScheme, tableNamePattern,type);
				Results = databaseMetaData.getColumns(catalog, patternScheme, "staff", columnNamePattern);
				ResultsName.first();
				System.out.println(ResultsName.getString("TABLE_NAME") + ":");
				ResultsName.next();
				while (Results.next()) 
				{
					System.out.print(Results.getString("COLUMN_NAME")+" ");
				}	
				System.out.println();
				System.out.println();
				System.out.println(ResultsName.getString("TABLE_NAME") + ":");
				ResultsName.next();
				Results = databaseMetaData.getColumns(catalog, patternScheme, "propertyforrent",columnNamePattern);
				while (Results.next()) 
				{
					System.out.print(Results.getString("COLUMN_NAME")+" ");
				}
				System.out.println();
				System.out.println();
				System.out.println(ResultsName.getString("TABLE_NAME") + ":");
				ResultsName.next();
				Results = databaseMetaData.getColumns(catalog, patternScheme, "client",columnNamePattern);
				while (Results.next()) 
				{
					System.out.print(Results.getString("COLUMN_NAME")+" ");
				}
				System.out.println();
				System.out.println();
				System.out.println(ResultsName.getString("TABLE_NAME") + ":");
				ResultsName.next();
				Results = databaseMetaData.getColumns(catalog, patternScheme, "privateowner",columnNamePattern);
				while (Results.next()) 
				{
					System.out.print(Results.getString("COLUMN_NAME")+" ");
				}
				System.out.println();
				System.out.println();
				System.out.println(ResultsName.getString("TABLE_NAME") + ":");
				ResultsName.next();
				Results = databaseMetaData.getColumns(catalog, patternScheme, "viewing",columnNamePattern);
				while (Results.next()) 
				{
					System.out.print(Results.getString("COLUMN_NAME")+" ");
				}
				System.out.println();
				System.out.println();
				System.out.println("-----------end------------");
				ResultsName.close();
				System.out.println();
		    }catch(ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
	}
}
	
	
