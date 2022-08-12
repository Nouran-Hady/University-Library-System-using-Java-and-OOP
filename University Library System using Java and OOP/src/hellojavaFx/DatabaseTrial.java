package hellojavaFx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DatabaseTrial {
	public static void main(String[] args)  {
		String databaseurl = "jdbc:ucanaccess://Database11.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseurl);
			System.out.println("connected to ms database");
			
			String sql = "INSERT INTO Table1 ( username, password) VALUES ('jjjjj','mmmnn')";
			
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate(sql);
			
			if (rows > 0 )
				System.out.println("a new contact has been inserted");
	
			statement.close();
			connection.close();
			
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	}
