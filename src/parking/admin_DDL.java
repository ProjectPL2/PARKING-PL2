package parking;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class admin_DDL extends Station {
    int id;
    String Name;
    int startShift;
    int endShift;
    static Connection c;
    static Statement s;
    
    
    void getInsert(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter ID: ");
            id = input.nextInt();
            System.out.println("Enter name: ");
            Name = input.next();
            System.out.println("Enter Start work shift: ");
            startShift = input.nextInt();
            System.out.println("Enter End work shift: ");
            endShift = input.nextInt();
            s.execute("insert into PL2 (id ,name ,startShift ,endShift) values ('"+id+"','"+Name+"','"+startShift+"','"+endShift+"')");
            System.out.println("INSERTED");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
        try{
            c.close();
            s.close();
            }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
    
    
    void getUpdate(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            Scanner input=new Scanner(System.in);
            System.out.println("Enter ID to Update: ");
            int input1 = input.nextInt();
            System.out.println("Enter new start shift: ");
            startShift =input.nextInt();
            System.out.println("Enter new end shift: ");
            endShift =input.nextInt();
            s.execute("update PL2 set startShift ='"+startShift+"' where id=('"+input1+"')");
            s.execute("update PL2 set endShift ='"+endShift+"' where id=('"+input1+"')");
            System.out.println("UPDATED");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                c.close();
                s.close();
                }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }  
    }

    
    void getDelete(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            Scanner input=new Scanner(System.in);
            System.out.println("Enter ID to Delete: ");
            int input1 = input.nextInt();
            s.execute("delete from PL2 where id=('"+input1+"')");
            System.out.println("DELETED");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
        finally{
            try{
                c.close();
                s.close();
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void getAllSpots()
    {  
        int size=Station.spots.size();
        
        ArrayList<String> key = new ArrayList<>(Station.spots.keySet()); 
        Collections.sort(key);  
        ArrayList<Boolean> value= new ArrayList<>(Station.spots.values());

        ArrayList<String> free =new ArrayList<>();
        ArrayList<String> busy =new ArrayList<>();
        
        int flagFree=0,flagBusy=0;
   
        for(int i=0;i<size;i++)
        {
            if(Station.spots.get(key.get(i)) == true)  
            {
                 free.add(key.get(i));  
                 flagFree=1;
            }   
            else
            {              
                busy.add(key.get(i));
                flagBusy=1;
            }
        }
        
        if(flagFree==0)
            System.out.println("there are no free spots");
        else
        {
            System.out.println("the free spots are :");
            for (int i = 0; i < free.size(); i++)  
            {
                System.out.print(free.get(i) + " ");
            }
           
        }
        System.out.println("\n------------------------------------");
        if(flagBusy==0)   
            System.out.println("there are no busy spots");
        else
        {
            System.out.println("the busy spots are :");
            for (int i = 0; i < busy.size(); i++)  
            {
                System.out.print(busy.get(i) + " ");
            }
           System.out.print("\n");
        }
                      
    }
 
}


