package hellojavaFx;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Admins {
    private String ID;
    private String Admin_Name;
    private String Admin_Password;
    
    public int File_write(ArrayList <String> list) throws IOException{  

    		String databaseurl = "jdbc:ucanaccess://Database217.accdb";
    		try {
    			Connection connection = DriverManager.getConnection(databaseurl);
    			System.out.println("connected to ms database");
    			
    			String sql = "INSERT INTO Admins (ID, Username, Password) VALUES"
    					+ "(?,?,?)";
    			
    			PreparedStatement statement = connection.prepareStatement(sql);
    			
    			statement.setString(1,list.get(0));
    			statement.setString(2,list.get(1));
    			statement.setString(3,list.get(2));
    			
    			int rows = statement.executeUpdate();
//    			System.out.println(rows);
    			if (rows > 0 )
    				System.out.println("a new contact has been inserted");
    			statement.close();
    			connection.close();
    		} 
    		
    		catch (SQLException e) {
    			// TODO Auto-generated catch block

    			System.out.print(e.getMessage());
    		}
    		
	    
	    return 0;
        }
	  
    
    public boolean check_login(String user_name, String password)throws IOException, SQLException{
    	
    	String databaseurl = "jdbc:ucanaccess://Database217.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseurl);
			System.out.println("connected to ms database");
    	Statement statement = connection.createStatement();
    	
		ResultSet resultSet = statement.executeQuery ("select Username from Admins where Username  = '"+user_name+"'");
    	
		if (user_name.equals(resultSet.getString(1))) {
			statement.close();
			return true;
		}


		
		statement.close();
        }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.print(e.getMessage());
			return false;
		}
        
     return false;   
    }
    
    public String delete_object(String ID, String name) throws IOException{
    	String databaseurl = "jdbc:ucanaccess://Database217.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseurl);
			System.out.println("\nconnected to ms database");

			String sql = "DELETE FROM Admins where Username = '"+name+"'";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			int rows = statement.executeUpdate();
			if (rows > 0 )
				System.out.println("a contact has been deleted");
			statement.close();
			connection.close();
			return "\n###Admins deleted###\n";
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
			return "\n###Admins not found###\n";
		}

  
    }

}
