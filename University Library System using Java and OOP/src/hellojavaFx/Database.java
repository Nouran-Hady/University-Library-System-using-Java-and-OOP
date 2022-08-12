package hellojavaFx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Database {
	

	public static void main(String[] args)  {
		
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("201903");
//		list.add("noura");
//		list.add("kjkjkk");
		
		String databaseurl = "jdbc:ucanaccess://Database217.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseurl);
			System.out.println("connected to ms database");
			
			
//			SELECT column_name(s)
//			FROM table_name
//			WHERE EXISTS
//			(SELECT column_name FROM table_name WHERE condition);
			
//			String sql ="SELECT Username FROM Admins"
//			Statement statement = connection.createStatement();
////					+ "WHERE EXISTS (SELECT Username FROM Admins WHERE Username = 'koko' )";
//			ResultSet resultSet = statement.executeQuery("select * from Admins");
//			 String all = resultSet.getString("Username");
////			String all = resultSet.getString("*");
//			System.out.println(all);
			
//			String sql = "INSERT INTO Admins (ID, Username, Password) VALUES"
//					+ "(?,?,?)";
			String sql = "DELETE FROM Admins where Username = 'hjbcja'";
//			
//			statement.setString(1,list.get(0));
//			statement.setString(2,list.get(1));
//			statement.setString(3,list.get(2));
			PreparedStatement statement = connection.prepareStatement(sql);
			int rows = statement.executeUpdate(sql);
//			System.out.println(rows);
			if (rows > 0 )
				System.out.println("a new contact has been inserted");
			statement.close();
			connection.close();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}
		
//		String databaseurl = "jdbc:ucanaccess://Database217.accdb";
//		try {
//			Connection connection = DriverManager.getConnection(databaseurl);
//			System.out.println("connected to ms database");
//			
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery ("select Username,Password from Admins where Username  = '"+kk+"'");
//					// Iterate through the result and print the student names
//			while (resultSet.next())
//				System.out.println(resultSet.getString(1)+resultSet.getString(2));
//
//			
//			statement.close();
//			connection.close();
			
//			String sql = "INSERT INTO Table1 (fullname) VALUES"
//					+ "(?)";
			
//			myStmt = myConn.prepareStatement(sql);
//			Statement statement = connection.createStatement();
			
//			String sql = "INSERT INTO Admins (Username, Password) VALUES"
//					+ "('jjjjj','mmmnn')";
			
			
			
//			statement.setString(0,list.get(0));
			
			
//			Statement statement = connection.prepareStatement("SELECT * from Admins");
//			statement.setString(1,kk);
			
			
//			 String sql = "SELECT * FROM Admins"
//			 		+ "WHERE Username='nouran hady';";
//			 Statement statement = connection.prepareStatement(sql);
//			 
////			 PreparedStatement stmt=connection.prepareStatement("delete from Admins where id=?");  
////			 stmt.setInt(1,101);  
//			   
////			 int i=statement.executeUpdate(sql);  
////			 System.out.println(i+" records deleted"); 
////			 String sql = "SELECT * FROM Admins";
////			 String kk = scanner.nextLine(); 
//			 
//			 ResultSet queryresult = statement.executeQuery();
//			 if (password.equals(queryresult.getString("password")))
//				 System.out.print("logged in");
//			 
//			 while(queryresult.next()) {
//				 
//					 System.out.print(queryresult);
//				 
////			 }
//			
//			int rows = statement.executeUpdate(sql);
//			
//			if (rows > 0 )
//				System.out.println("a new contact has been inserted");
//			statement.close();
//			connection.close();
		
		
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.print(e.getMessage());
//		}
		
	}

}
