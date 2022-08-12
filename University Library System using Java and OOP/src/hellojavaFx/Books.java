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


public class Books {
    
    private String ID;
    private String book_Name;
    private String Author_Name;
    private String Available_quantity;    
    private String Issued_quantity;
    
    public int File_write(String s1, String space) throws IOException{

 
        try{     
    File book = new File("Books.csv");
    Scanner sc = new Scanner(book);
    PrintWriter pr = new PrintWriter(new FileWriter(book,true));
    
    if (s1.length()>"main in pythonc".length())
        space="	";
 while(sc.hasNextLine()){
       String s = sc.nextLine();
       if ((s.compareTo(s1))==0)
           return 1;
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
    
    public String delete_object(String s1) throws IOException{
        try{     
        File fr = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Books.txt");
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
            return "\n###Books deleted###\n";
        else
            return "\n###Books not found###\n";
   
    }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
    return " ";
  
    }
    
    static String getNbr(String str){ 
        String str_copy=str;
        List<String> string_list = new ArrayList<String>(Arrays.asList(str.split("		")));
      
        ArrayList<Integer> list = new ArrayList<Integer>();
        str = str.replaceAll("[^\\d]", " "); 
        // Remove leading and trailing spaces
        str = str.trim(); 
        // Replace consecutive spaces with a single space
        str = str.replaceAll(" +", " "); 
        int x;
        str.split(" ");
        List<String> myList = new ArrayList<String>(Arrays.asList(str.split(" ")));
    
        for(String b: myList){
            list.add(Integer.valueOf(b));
        }
        list.remove(0);
               
        if (list.get(0)!=0){
        Integer v;
        v=(list.get(0))-1;
        string_list.remove(3);
        string_list.add(3,v.toString());
         
        v =(list.get(1))+1;
        string_list.remove(4);
        string_list.add(4,v.toString());
        int i=0;
        str="";
        for(i=0;i<string_list.size()-1;i++){
            str=str+string_list.get(i)+"		";
        }
        str=str+string_list.get(i); 
        return str;
        }
        
        return str_copy;
    }
    
    public String check_book(String s1, String ID) throws IOException{
        try{ 
        IssuedBooks issue = new IssuedBooks();
        
        File fr = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Books.txt");
        Scanner sc = new Scanner(fr);
        ArrayList<String> lines=new ArrayList<String>();
        
        int i=0;
        int flag=0;
        boolean noQuantity=false;
        String text="";
        
        while(sc.hasNextLine()){
           String s = sc.nextLine();
           
           if (s.contains(s1) && flag==0 ){ 
               text=s;
                s=getNbr(s);
                System.out.println(s);
                if (text==s)
                    noQuantity=true;
                else{
                    issue.addIssuedbook(s, s1, ID);
                }
                flag=1;
                
                   }   
           lines.add(s);
        }
        if (flag==0){
            return "book not found";
        }

        PrintWriter pw = new PrintWriter(new FileWriter(fr));  

        while(i<lines.size()){
            pw.write(lines.get(i));
            pw.write("\n");
            i++;
        }
        pw.close();
        sc.close();
        
        if (noQuantity)
            return "Book found but no available quantity";       
        if (flag==1)
            return "book found";
    }

    catch(FileNotFoundException e){
    System.out.println(e);
    }
    return "";
  
    }
    
    static String IncrementBook(String str){ 
        String str_copy=str;
        List<String> string_list = new ArrayList<String>(Arrays.asList(str.split("		")));
      
        ArrayList<Integer> list = new ArrayList<Integer>();
        str = str.replaceAll("[^\\d]", " "); 
        // Remove leading and trailing spaces
        str = str.trim(); 
        // Replace consecutive spaces with a single space
        str = str.replaceAll(" +", " "); 
        int x;
        str.split(" ");
        List<String> myList = new ArrayList<String>(Arrays.asList(str.split(" ")));
    
        for(String b: myList){
            list.add(Integer.valueOf(b));
        }
        list.remove(0);
               
        if (list.get(0)!=0){
        Integer v;
        v=(list.get(0))+1;
        string_list.remove(3);
        string_list.add(3,v.toString());
         
        v =(list.get(1))-1;
        string_list.remove(4);
        string_list.add(4,v.toString());
        int i=0;
        str="";
        for(i=0;i<string_list.size()-1;i++){
            str=str+string_list.get(i)+"		";
        }
        str=str+string_list.get(i); 
        return str;
        }
        
        return str_copy;
    }
    
    public String return_book(String name, String studentID) throws IOException{
        
        IssuedBooks s1=new IssuedBooks();
        s1.returnIssuedbook(name,studentID);
        
        try{ 
        IssuedBooks issue = new IssuedBooks();
        
        File fr = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Books.txt");
        Scanner sc = new Scanner(fr);
        ArrayList<String> lines=new ArrayList<String>();
        
        int i=0;
        int flag=0;
        
        while(sc.hasNextLine()){
           String s = sc.nextLine();
           
           if (s.contains(name) && flag==0){
                flag=1;
                s=IncrementBook(s);
           }
   
                    
           lines.add(s);
        }

        PrintWriter pw = new PrintWriter(new FileWriter(fr));  

        while(i<lines.size()){
            pw.write(lines.get(i));
            pw.write("\n");
            i++;
        }
        pw.close();
        sc.close();
        return "book returned successfully ";
        }

    catch(FileNotFoundException e){
    System.out.println(e);
    }
        
        
        return "";
    }
    
    public void viewAllBooks() throws IOException{
        try{     
    File book = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Books.txt");
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
    
    public String search(String name, int ID)throws IOException{
        
         try{     
        File fr = new File("C:\\nu 2021\\spring2022\\csci217\\assignment\\Books.txt");
        Scanner sc = new Scanner(fr);
        String id= Integer.toString(ID);
      
        while(sc.hasNextLine()){
           String s = sc.nextLine();
           
           if (s.contains(name) && s.contains(id))
               return "book found";
           
       sc.close();
    
    }
        }
    catch(FileNotFoundException e){
    System.out.println(e);
    }
        
     return "book not found";   
    }
    }
    

