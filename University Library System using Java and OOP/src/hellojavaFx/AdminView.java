/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nouran Hady Shaaban
 */

/* o Add/remove Students
o Add/remove librarian 
o Add/remove other admins*/
package hellojavaFx;


import java.util.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class AdminView {
    
   public String add_students(String ID, String name, String BirthDay, 
		   String Email, String Mobile_number )throws IOException{
       ArrayList<String>student=  new ArrayList<String>();
       Students student1= new Students();
       int i=0;
     
       student.add(ID);
      
       student.add(name);
      
       student.add(BirthDay);

       student.add(Email);
       
       
       student.add(Mobile_number);
       int c=0;
     
       c=student1.File_write(student);
       
       if (c == 1) 
    	   return "***Member already saved***";
//        	   return c+" "+i+" in add student";
   
       if (c!=1)
           return "\n***Member added successfully***\n";
      return "";
   }
   
   public String add_librarian(String ID, String name, String password)throws IOException{
       ArrayList<String>librarians=  new ArrayList<String>();
       Librarians Librarian= new Librarians();
       int i=0;
       
       librarians.add(ID);
       
       librarians.add(name);
       
       librarians.add(password);

       int c=0;
       c=Librarian.File_write(librarians);
       if (c==1 && i !=2)
            return "***librarian already saved***";
         
       else
    	   return "***librarian added successfully***";
   }
   
    public String add_other_admins(String ID, String name, String password)throws IOException{
       ArrayList<String>admins=  new ArrayList<String>();
       Admins Admin= new Admins();
       int i=0;
       
       admins.add(ID);
       
       admins.add(name);
       
       admins.add(password);

       int c=0;
       c=Admin.File_write(admins);
       
       if (c==1 && i !=2)
        	   return "***Admin already saved***";
       
       else
    	   	return "***Admin added successfully***";
        
    }
    
    public String remove_students(String ID, String Name)throws IOException{
    	
       Students s1=new Students();
       return s1.delete_object(ID, Name);
      
    }
    public String remove_librarian(String ID, String Name)throws IOException{
       Librarians s1=new Librarians();
       
      return s1.delete_object(ID, Name);
      
    }
    
    public String remove_other_admins(String ID, String Name)throws IOException{
    	
       Admins s1=new Admins();
       
       return s1.delete_object(ID, Name);
      
      
    }
    public int login(String user_name, String password) throws IOException, SQLException{
        Admins l1 =new Admins();
        
        if ( l1.check_login(user_name, password)) {
        	return 0;
        }
            
        else
            return 0; 
    }
      
    public static void main(String[] args)throws IOException{
    	
    }
}
