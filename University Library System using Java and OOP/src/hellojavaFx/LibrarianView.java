package hellojavaFx;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nouran Hady Shaaban
 */
public class LibrarianView {
    
    public void add_books() throws IOException{
       ArrayList<String>Books=  new ArrayList<String>();
       Books Book= new Books();
       int i=0;
       Scanner input = new Scanner(System.in); //to input a string 
       
       System.out.println("please enter book ID");
       String ID = input.nextLine();
       Books.add(ID);
       
       System.out.println("please enter book Name");
       String name = input.nextLine();
       Books.add(name);
       
       System.out.println("please enter Author Name");
       String Author = input.nextLine();
       Books.add(Author);
       
       System.out.println("please enter Available quantity");
       String Available_quantity = input.nextLine();
       Books.add(Available_quantity);
       
       
       String Issued_quantity = "0";
       Books.add(Issued_quantity);

       int c=0;
       
       while (i<Books.size()){
           c=Book.File_write(Books.get(i),"		");
           if (c==1 && i !=2){
                System.out.println("\n***Book already saved***\n");
               break;
           }
           i++;
       }
       Book.File_write(" ","\n");
       
       if (c!=1)
           System.out.println("\n\b***Book added successfully***\n");
        
    }
    
    public void delete_books(String name,  String ID) throws IOException{
       Students s1=new Students();
       Scanner input = new Scanner(System.in); //to input a string
       System.out.println(s1.delete_object(name, ID));
      
    }
   
    public void issue_books()  throws IOException{
        
       Students student = new Students();
       Books s1=new Books();
       Scanner input = new Scanner(System.in); //to input a string
       
       System.out.println("please enter student ID");
       String studentID = input.nextLine();
       
       boolean found=false;
       found=student.check_student(studentID);
       
       if (found==true){
           
       System.out.println("please enter book name or ID to issue");
       String name = input.nextLine();
       s1.check_book(name,studentID);
       }
       else
           System.out.print("Student is not found and cannot issue a book ");
      
    }
    
    public void return_books() throws IOException{
       Books s1=new Books();
       
       Scanner input = new Scanner(System.in); //to input a string
       
       System.out.println("please enter student ID");
       String studentID = input.nextLine();
        
       System.out.println("please enter book name or ID to return");
       String name = input.nextLine();
       
       s1.return_book(name,studentID);
       
    }
    
    public void view_books() throws IOException{
        Books book = new Books();
        book.viewAllBooks();
    }
    
    public void view_issued_books() throws IOException{
        IssuedBooks issued_book = new IssuedBooks();
        issued_book.viewIssuedBooks();
    }
    
    public int login(String user_name, String password) throws IOException{
        Librarians l1 =new Librarians();
        
        if ( l1.check_login(user_name, password)) 
        	return 0;
        
            
        else
            return 1; 
      
    }
    
    public void search_for_book(String name, int ID)throws IOException{
        Books book = new Books();
        
        String[] args={""};
        book.search(name, ID);
        
    }
           
    public static void main (String[] args)throws IOException{
    }
}
