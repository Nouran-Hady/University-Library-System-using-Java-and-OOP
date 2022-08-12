package hellojavaFx;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class IssuedBooks {
    private String Procedure_ID;
    private String ID;
    private String Student_ID;
    private boolean Returned;
    
public int File_write(String s1, String space) throws IOException{

    try{     
    File issued_book = new File("Issued Books.csv");
    Scanner sc = new Scanner(issued_book);
    PrintWriter pr = new PrintWriter(new FileWriter(issued_book,true));
 while(sc.hasNextLine()){
       String s = sc.nextLine();
       if (s.contains(s1)){
           return 1;
       }
    }
     pr.append(s1);
     pr.append(space);

     
    pr.close();
    sc.close();
    }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
     return 0;   
    }
    
    public void addIssuedbook(String str,String bookID ,String ID)throws IOException{
    try{   
        
    File issued_book = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Issued Books.txt");
    Scanner sc = new Scanner(issued_book);
    PrintWriter pr = new PrintWriter(new FileWriter(issued_book,true));
    String s;
    Integer count=0;
    
    while(sc.hasNextLine()){
       s = sc.nextLine();
      count++;
    }
    String line="\n    "+count.toString()+"		"+bookID+"		"+ID+"		"+"False";
     pr.append(line);
     
    pr.close();
    sc.close();
    }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
    }
    
    public void returnIssuedbook(String name, String studentID) throws IOException{
    try{   
        
    File issued_book = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Issued Books.txt");
    Scanner sc = new Scanner(issued_book);
    ArrayList<String> lines=new ArrayList<String>();
    
    String s;
    int i=0;
    Integer count=0;
    
    while(sc.hasNextLine()){
       s = sc.nextLine();
       List<String> string_list = new ArrayList<String>(Arrays.asList(s.split("		")));
       if (s.contains(name) && s.contains(studentID) && string_list.get(3) !="True" ){
            
            string_list.remove(3);
            string_list.add(3,"True");
            s="";
            
            for(i=0;i<string_list.size();i++)
                     s=s+string_list.get(i)+"		";
            System.out.println(s);
       }
       lines.add(s);
    }
    
    PrintWriter pw = new PrintWriter(new FileWriter(issued_book));  
    
    i=0;
        while(i<lines.size()){
            pw.append(lines.get(i));
            pw.append("\n");
            i++;
        }
    
    pw.close();
    sc.close();
    }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
    }
    
    public String delete_object(String s1) throws IOException{
        try{     
        File fr = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Issued Books.txt");
        Scanner sc = new Scanner(fr);
        
        ArrayList<String> line=new ArrayList<String>();
        int i=0;
        int flag=0;


        while(sc.hasNextLine()){
           String s = sc.nextLine();
           
           if (s.contains(s1)){
               flag=1;
               continue;
           }
           else
               line.add(s);
  
        }
        PrintWriter pw = new PrintWriter(new FileWriter(fr));
        while(i<line.size()){
            pw.append(line.get(i));
            pw.append("\n");
            i++;
        }
        
        pw.close();
        sc.close();
    
        if (flag==1)
            return "\n###Student deleted###\n";
        else
            return "\n###Student not found###\n";
   
    }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
    return " ";
  
    }
    
    public void viewIssuedBooks() throws IOException{
        try{     
    File book = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Issued Books.txt");
    Scanner sc = new Scanner(book);
 while(sc.hasNextLine()){
       String s = sc.nextLine();
      System.out.println(s);
    }
    sc.close();
    }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
    }
    
    
}

