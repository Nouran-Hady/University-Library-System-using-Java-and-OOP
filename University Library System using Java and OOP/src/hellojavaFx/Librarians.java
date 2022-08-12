/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nouran Hady Shaaban
 */
package hellojavaFx;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Librarians {
    private String ID;
    private String Name;
    private String Librarian_Password;

    public int File_write(ArrayList <String> list) throws IOException{

    	String databaseurl = "jdbc:ucanaccess://Database217.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseurl);
			System.out.println("connected to ms database");
			
			String sql = "INSERT INTO Librarian (ID, Username, Password) VALUES"
					+ "(?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(0,list.get(0));
			statement.setString(1,list.get(1));
			statement.setString(2,list.get(2));
			
			int rows = statement.executeUpdate();
			if (rows > 0 )
				System.out.println("a new contact has been inserted");
			statement.close();
			connection.close();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     return 0;   
    }
    
    public String delete_object(String s1, String name) throws IOException{
    	
    	String databaseurl = "jdbc:ucanaccess://Database217.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseurl);
			System.out.println("connected to ms database");

			String sql = "DELETE FROM Librarian where Username = '"+name+"'";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			int rows = statement.executeUpdate();
			if (rows > 0 )
				System.out.println("a contact has been deleted");
			statement.close();
			connection.close();
			return "\n###Librarians deleted###\n";
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
			return "\n###Librarians not found###\n";
		}
  
    }
    
    public boolean check_login(String user_name, String password)throws IOException{
        try{     
        File fr = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Librarians.csv");
        Scanner sc = new Scanner(fr);
      
        while(sc.hasNextLine()){
           String s = sc.nextLine();
           
           if (s.contains(user_name) && s.contains(user_name) )
               return true;
           }
       sc.close();
    
    
        }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
        
     return false;   
    }
    
}
