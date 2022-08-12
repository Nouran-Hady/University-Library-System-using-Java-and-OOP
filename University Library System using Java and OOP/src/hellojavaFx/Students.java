/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nouran Hady Shaaban
 * 
 * Student ID	Student name	Student Birthday	Email       Mobile number
 */
package hellojavaFx;


import java.util.*;

import java.io.*;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Students {
    private String ID;    
    private String name;
    private String Birthday;
    private String Email;
    private String Mobile_number;

    public int File_write(ArrayList <String> list) throws IOException{


		String databaseurl = "jdbc:ucanaccess://Database217.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseurl);
			System.out.println("connected to ms database");
			
			String sql = "INSERT INTO Members (ID, Username, Birthday, Email, MobileNumber) VALUES"
					+ "(?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			for (int i =0; i<list.size();i++)
				statement.setString(i+1,list.get(i));
			
			
			int rows = statement.executeUpdate();
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
		
     return 0;   
    }
    
    
    public String delete_object(String s1 ,String name) throws IOException{
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
			return "\n###Member deleted###\n";
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
			return "\n###Member not found###\n";
		}
  
    }
    
    public boolean check_student(String s1) throws IOException{
        try{     
        File fr = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Students.csv");
        Scanner sc = new Scanner(fr);
        
        while(sc.hasNextLine()){
           String s = sc.nextLine();
           if (s.contains(s1))
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