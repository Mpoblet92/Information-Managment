package IdealHomeDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import IdealHomeDB.IdealHomeDBConfig;

public class CreateTable {
   public static void creatTabels() throws SQLException {
   Connection connection = IdealHomeDBConfig.getConnection();
   Statement statement = null;
   try{
      System.out.println("Creating database tables!");
      statement = connection.createStatement();
      
      String createTableStaff =
    	      "create table if not exists staff " + "(staffNo varchar(4) NOT NULL, " + 
              "fname varchar(20) NOT NULL," + "lname varchar(20) NOT NULL," +"position varchar(20) NOT NULL," +
    	      "salary numeric NOT NULL," +
               "primary key (staffNo))"; 
      String createTableClient =
    	      "create table if not exists Client " + "(clientNo varchar(10) NOT NULL, " + 
              "fname varchar(20) NOT NULL," +"lname varchar(20) NOT NULL," +"telNo varchar(30) NOT NULL," +
    	      "maxRent int NOT NULL," + 
              "primary key (clientNo))"; 
      String createTablePrivateOwner =
    	      "create table if not exists PrivateOwner " + "(ownerNo varchar(10) NOT NULL, " + 
              "fname varchar(20) NOT NULL," +"lname varchar(20) NOT NULL," +"telNo varchar(30) NOT NULL," + 
              "primary key (ownerNo))"; 
      String createTablePropertyForRent =
    	      "create table if not exists PropertyForRent " + "(propertyNo varchar(10) NOT NULL, " + 
              "Street varchar(30) NOT NULL," +"city varchar(10) NOT NULL," +"postcode varchar(20) NOT NULL," +
    	      "rent int NOT NULL," + "ownerNo varchar(10)," + "staffNo varchar(4),"+
              "primary key (propertyNo),"+
    	      "foreign key (ownerNo) references PrivateOwner(ownerNo) on delete set null  on update cascade,"+
    	      "foreign key (staffNo) references staff(staffNo) on delete set null  on update cascade)"; 
      String createTableViewing =
    	      "create table if not exists Viewing " + "(clientNo varchar(10), " + 
              "propertyNo varchar(10)," +"viewdate varchar(10)," +"comment varchar(50)," + 
              "foreign key(clientNo) references client(clientNo)" +
              " on update cascade," +
              "foreign key(propertyNo) references propertyforrent(propertyNo)" +
              "on update cascade)"; 
      statement.executeUpdate(createTableStaff);
      statement.executeUpdate(createTableClient);
      statement.executeUpdate(createTablePrivateOwner);
      statement.executeUpdate(createTablePropertyForRent);
      statement.executeUpdate(createTableViewing);
      System.out.println("Database Tables successfully created!");
   }catch(SQLException se)
   {
      se.printStackTrace();
   }catch(Exception e)
   {
      e.printStackTrace();
   }finally{
      try{
         if(statement!=null)
        	 statement.close();
      }catch(SQLException se2){
      }
      try{
         if(connection!=null)
            connection.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   	System.out.println("Returning to Main Menu!");
   	System.out.println();
   }
   	
   }
}

