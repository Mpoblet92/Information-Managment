package IdealHomeDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Insert {
	private static Scanner in;
	static String ss = "Success";
	static String ff = "Failure";
	public static void insert() throws SQLException
	{
		Connection connection = IdealHomeDBConfig.getConnection();
		Statement statement = null;
		statement = connection.createStatement();
		    try {
		    		in = new Scanner(System.in);
		    		int x = 10;
		    		Class.forName("com.mysql.jdbc.Driver");
				      while(x != 0)
				      {
				    	  insertMenu();
				    	  x = in.nextInt();
				    	  if(x < 0 || x > 5)
								System.out.println("Must be an option between 0 and 5!\n");
				    	  else
				    	  {
					    	  switch(x)
					    	  {
					    	  	case 1:
					    	  		insertStaff();
					    	  		break;
					    	  	case 2:
					    	  		insertClient();
					    	  		break;
					    	  	case 3:
					    	  		insertPrivateOwner();
					    	  		break;
					    	  	case 4:
					    	  		insertProperty();
					    	  		break;
					    	  	case 5:
					    	  		insertViewing();
					    	  		break;
					    	  	default:
					    	  	{
					    	  		System.out.println("Returning to Main Menu!");
					    	  		break;					    
					    	  	}
					    	  		
					    	  }
				    	  }
				      	
				     }		        
		    }  catch (ClassNotFoundException e) {
			} catch (InputMismatchException e)
		    {
				System.out.println();
				System.out.println("Must be a number between 0 and 5!");
			}
		    finally {
		        if (statement != null) 
		        {
		        	statement.close(); 
		        }
		      }
	}
	private static void insertViewing() {
		String clientNo, propertyNo, viewDate, comment, inserts;
		System.out.println();
		System.out.print("Client number (####): ");
		clientNo = in.next();
		System.out.print("Property number (####): ");
		propertyNo = in.next();
		System.out.print("View Date: ");
		viewDate = in.next();
		System.out.print("Comment: ");
		comment = in.next();
		
		inserts = "INSERT INTO `idealhome`.`viewing` (`clientNo`, `propertyNo`, `viewdate`, `comment`)  VALUES ('"+clientNo+"', '"+propertyNo+"', '"+viewDate+"', '"+comment+"');";
		
		try
		{
			Connection connection = IdealHomeDBConfig.getConnection();
			Statement statement = null;
			statement = connection.createStatement();
			statement.execute(inserts);
			System.out.println(ss);
		}  catch (SQLException e)
		{
			System.out.println(ff + e.getSQLState());

			if(e.getSQLState().equals("23000"))
				System.out.println("Client or Property number doesn't exist!");
			
		}
	}
	private static void insertProperty() {
		String propertyNo, street, city, postCode, rent, ownerNo, staffNo, inserts;
		System.out.println();
		System.out.print("Property number (####): ");
		propertyNo = in.next();
		System.out.print("Street: ");
		street = in.next();
		System.out.print("City: ");
		city = in.next();
		System.out.print("Postcode: ");
		postCode = in.next();
		System.out.print("Rent: ");
		rent = in.next();
		System.out.print("Owner number (####): ");
		ownerNo = in.next();
		System.out.print("Staff number (####): ");
		staffNo = in.next();
		
		inserts = "INSERT INTO `idealhome`.`propertyforrent` (`propertyNo`, `street`, `city`,  `postcode`, `rent`, `ownerNo`, `staffNo`)  VALUES ('"+propertyNo+"', '"+street+"', '"+city+"', '"+postCode+"', '"+rent+"', '"+ownerNo+"', '"+staffNo+"');";
		
		try
		{
			Connection connection = IdealHomeDBConfig.getConnection();
			Statement statement = null;
			statement = connection.createStatement();
			statement.execute(inserts);
			System.out.println(ss);
		}  catch (SQLException e)
		{
			System.out.println(ff + e.getSQLState());
			if(e.getSQLState().equals("23000"))
				System.out.println("Property number already exists!");
		}
	}
	private static void insertPrivateOwner() {
		String ownerNo, fName, lName,  telNo, inserts;
		System.out.println();
		System.out.print("Owner number (####): ");
		ownerNo = in.next();
		System.out.print("First name: ");
		fName = in.next();
		System.out.print("Last name: ");
		lName = in.next();
		System.out.print("Phone number: ");
		telNo = in.next();
		
		inserts = "INSERT INTO `idealhome`.`privateowner` (`ownerNo`, `fname`, `lname`, `telNo`) VALUES ('"+ownerNo+"', '"+fName+"', '"+lName+"', '"+telNo+"');";
		
		try
		{
			Connection connection = IdealHomeDBConfig.getConnection();
			Statement statement = null;
			statement = connection.createStatement();
			statement.execute(inserts);
			System.out.println(ss);
		} catch (SQLException e)
		{
			System.out.println(ff + e.getSQLState());
			if(e.getSQLState().equals("23000"))
			System.out.println("Owner number already exists!");
			
		}
	}
	private static void insertClient() {
		String clientNo, fName, lName, telNo, maxRent, inserts;
		System.out.println();
		System.out.print("Client number (####): ");
		clientNo = in.next();
		System.out.print("First name: ");
		fName = in.next();
		System.out.print("Last name: ");
		lName = in.next();
		System.out.print("Phone Number: ");
		telNo = in.next();
		System.out.print("Max Rent: ");
		maxRent = in.next();
		
		inserts = "INSERT INTO `idealhome`.`client` (`clientNo`, `fname`, `lname`, `telNo`, `maxRent`) VALUES ('"+clientNo+"', '"+fName+"', '"+lName+"', '"+telNo+"', '"+maxRent+"');";
		
		try
		{
			Connection connection = IdealHomeDBConfig.getConnection();
			Statement statement = null;
			statement = connection.createStatement();
			statement.execute(inserts);
			System.out.println(ss);
		} catch (SQLException e)
		{
			System.out.println(ff + e.getSQLState());
			if(e.getSQLState().equals("23000"))
			System.out.println("Client number already exists!");
			
		}
		
	}
	private static void insertStaff() {
		String staffNo, fName, lName, position, salary, inserts;
		System.out.println();
		System.out.print("Staff number (####): ");
		staffNo = in.next();
		System.out.print("First name: ");
		fName = in.next();
		System.out.print("Last name: ");
		lName = in.next();
		System.out.print("Position: ");
		position = in.next();
		System.out.print("Salary: ");
		salary = in.next();
		
		inserts = "INSERT INTO `idealhome`.`staff` (`staffNo`, `fname`, `lname`, `position`, `salary`) VALUES ('"+staffNo+"', '"+fName+"', '"+lName+"', '"+position+"', '"+salary+"');";
		
		try
		{
			Connection connection = IdealHomeDBConfig.getConnection();
			Statement statement = null;
			statement = connection.createStatement();
			statement.execute(inserts);
			System.out.println(ss);
		} catch (SQLException e)
		{
			System.out.println(ff + e.getSQLState());
			if(e.getSQLState().equals("23000"))
			System.out.println("Staff number already exists!");
			
		}
		
		
	}
	private static void insertMenu() {
		System.out.println();
		System.out.println("1: Insert new Staff.");
		System.out.println("2: Insert new Client.");
		System.out.println("3: Insert new Private Owner");
		System.out.println("4: Insert new Property for Rent");
		System.out.println("5: Insert new Viewing");
		System.out.println("0: Return to Main Menu");
		System.out.println();
		System.out.print("Enter number to start that action: ");
	}
}
	
	


