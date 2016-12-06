package IdealHomeDB;

import java.sql.*;

public class CreateDB {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/?useSSL=false";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "Poblet@5510@4035";
   
   public static void Create() {
   Connection connection = null;
   Statement statement = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Establishing database connection!");
      connection = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Database Being Created!");
      statement = connection.createStatement();
      String sqlDb = "CREATE DATABASE idealhome";
      statement.executeUpdate(sqlDb);
      System.out.println("Database was successfully created!");
   }catch(SQLException se){
     //se.printStackTrace();
	 System.out.println("Database Already Exists!");
   }catch(Exception e){
     // e.printStackTrace();
   }finally{
      try{
         if(statement!=null)
        	 statement.close();
      }catch(SQLException e2){
      }
      try{
         if(connection!=null)
        	 connection.close();
      }catch(SQLException se){
        // se.printStackTrace();
      }
   }
   System.out.println("Returning to Main Menu!");
   System.out.println();
}
   
}

