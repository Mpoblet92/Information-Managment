package IdealHomeDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException
	{
		Scanner in = new Scanner(System.in);
		int x = 10;

		while(x != 0)
		{
			mainMenu();
			System.out.println();
			System.out.print("Enter a number to start that action: ");
			x = in.nextInt();
			if(x < 0 || x > 6)
				System.out.println("Must be an option between 0 and 6!\n");
			else
			{
				switch(x)
				{
					case 1:
						CreateDB.Create();
						break;
					case 2:
						CreateTable.creatTabels();
						break;
					case 3:
						Insert.insert();
						break;
					case 4:
						Delete.delete();
						break;
					case 5:
						MetaData.meta();
						break;
					case 6:
						View.view();
						break;
					default:
						System.out.println();
						System.out.println("Farewell!");
						in.close();
				}
			}
		}
	}

	private static void mainMenu() {
		System.out.println("1: Create IdealHomeDB");
		System.out.println("2: Create Tables");
		System.out.println("3: Insert Tuples");
		System.out.println("4: Delete Tuples");
		System.out.println("5: View Metadata");
		System.out.println("6: Custom Queries");
		System.out.println("0: Exit!");
	}
}
