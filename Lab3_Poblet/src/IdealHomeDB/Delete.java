package IdealHomeDB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete{
	private static Scanner in = new Scanner(System.in);
	static String ss = "Success";
	static String ff = "Failure";
	static Connection conn = null;
	static Statement stmt = null;
	public static void delete() throws SQLException{
		    try 
		    {
		    	int x = 10;
		    	 Class.forName("com.mysql.jdbc.Driver");		         
				
				      while(x != 0)
				      {
				    	  deleteMenu();
				    	  x = in.nextInt();
				    	  if(x < 0 || x > 5)
								System.out.println("Must be an option between 0 and 5!");
				    	  else
				    	  {
					    	  switch(x)
					    	  {
					    	  	case 1:
					    	  		deleteStaff();
					    	  		break;
					    	  	case 2:
					    	  		deleteClient();
					    	  		break;
					    	  	case 3:
					    	  		deletePrivateOwner();
					    	  		break;
					    	  	case 4:
					    	  		deleteProperty();
					    	  		break;
					    	  	case 5:
					    	  		deleteViewing();
					    	  		break;
					    	  	default:
					    	  	{
					    	  		System.out.println("Returning to Main Menu!");
					    	  		break;
					    	  	}
					    	  		
					    	  }
				    	  }
				      
					}
		    }
		    catch (ClassNotFoundException e) 
		    {
			} 
	}
	private static void deleteViewing() {
		String clientNo, propertyNo, deleted;
		System.out.println();
		System.out.print("Enter Client number to be deleted: ");
		clientNo = in.next();
		if(clientNo.equals("null"))
			clientNo = null;
		System.out.println();
		System.out.print("Enter Property number to be deleted: ");
		propertyNo = in.next();
		if(propertyNo.equals("null"))
			propertyNo = null;
		deleted = "DELETE From viewing where clientNo = '"+clientNo+"' AND propertyNo = '"+propertyNo+"';";
	     try {
			conn = IdealHomeDBConfig.getConnection();
			 stmt = conn.createStatement();			      
	         stmt.executeUpdate(deleted);
	         System.out.println(ss);
	     }  catch (SQLException e)
			{
				System.out.println(ff + e.getSQLState());
				if(e.getSQLState().equals("23000"))
				System.out.println();
				
			}   		
	}
	private static void deleteProperty() {
		String propertyNo, deleted;
		System.out.println();
		System.out.print("Enter Property number to be deleted: ");
		propertyNo = in.next();
		deleted = "DELETE From propertyforrent where propertyNo = '"+propertyNo+"';";
	     try {
			conn = IdealHomeDBConfig.getConnection();
			 stmt = conn.createStatement();			      
	         stmt.executeUpdate(deleted);
	         System.out.println(ss);
	     }  catch (SQLException e)
			{
				System.out.println(ff + e.getSQLState());
				if(e.getSQLState().equals("23000"))
				System.out.println("Property is tied to other tables!");
				
			}   		
	}
	private static void deletePrivateOwner() {
		String ownerNo, deleted;
		System.out.println();
		System.out.print("Enter Owner number to be deleted: ");
		ownerNo = in.next();
		deleted = "DELETE From privateowner where ownerNo = '"+ownerNo+"';";
	     try {
			conn = IdealHomeDBConfig.getConnection();
			 stmt = conn.createStatement();			      
	         stmt.executeUpdate(deleted);
	         System.out.println(ss);
	     }  catch (SQLException e)
			{
				System.out.println(ff + e.getSQLState());
				if(e.getSQLState().equals("23000"))
				System.out.println("Owner is tied to other tables!");
				
			}   
	}
	private static void deleteClient() {
		String clientNo, deleted;
		System.out.println();
		System.out.print("Enter Client number to be deleted: ");
		clientNo = in.next();
		deleted = "DELETE From client where clientNo = '"+clientNo+"';";
	     try {
			conn = IdealHomeDBConfig.getConnection();
			 stmt = conn.createStatement();			      
	         stmt.executeUpdate(deleted);
	         System.out.println(ss);
	     }  catch (SQLException e)
			{
				System.out.println(ff + e.getSQLState());
				if(e.getSQLState().equals("23000"))
				System.out.println("Client is tied to other tables!");
				
			}   	
	}
	private static void deleteStaff() {
		
		String staffNo, deleted;
		System.out.println();
		System.out.print("Enter Staff number to be deleted: ");
		staffNo = in.next();
		deleted = "DELETE From staff where staffNo = '"+staffNo+"';";
	     try {
			conn = IdealHomeDBConfig.getConnection();
			 stmt = conn.createStatement();			      
	         stmt.executeUpdate(deleted);
	         System.out.println(ss);
	     }  catch (SQLException e)
			{
				System.out.println(ff + e.getSQLState());
				if(e.getSQLState().equals("23000"))
				System.out.println("Staff is tied to other tables!");
				
			}
	    
	}
	private static void deleteMenu() {
		System.out.println();
		System.out.println("1: Delete Staff.");
		System.out.println("2: Delete Client.");
		System.out.println("3: Delete Private Owner");
		System.out.println("4: Delete Property for Rent");
		System.out.println("5: Delete Viewing");
		System.out.println("0: Return to Main Menu");
		System.out.println();
		System.out.print("Enter number to start that action: ");
		
	}
}
	
	
