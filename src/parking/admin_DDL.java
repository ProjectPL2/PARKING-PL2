package parking;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class admin_DDL extends Station {
   
    private static Connection c;
    private static Statement s;
    
     Scanner input = new Scanner(System.in);
    public void getInsert(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            //System.out.println("Enter ID: ");
            //setOperatorId(input.nextInt());
            System.out.println("Enter name: ");
            setOperatorUsername(input.next());
            System.out.println("Enter Start work shift: ");
            setStartShift(input.nextInt());
            System.out.println("Enter End work shift: ");
            setEndShift(input.nextInt());
            s.execute("insert into operators (id ,name ,startShift ,endShift) values ('1','"+getOperatorUsername()+"','"+ getStartShift()+"','"+ getEndShift()+"')");
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
    
    
    public void getUpdate(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            System.out.println("Enter ID to Update: ");
            int id = input.nextInt();
            System.out.println("Enter new start shift: ");
            setStartShift(input.nextInt());
            System.out.println("Enter new end shift: ");
            setEndShift(input.nextInt());
            s.execute("update PL2 set startShift ='"+getStartShift()+"' where id=('"+id+"')");
            s.execute("update PL2 set endShift ='"+getEndShift()+"' where id=('"+id+"')");
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

    
    public void getDelete(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            System.out.println("Enter ID to Delete: ");
            int id = input.nextInt();
            s.execute("delete from PL2 where id=('"+id+"')");
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
    
    public void viewAllSpots()
    {  
        int size=spots.size();
        
        ArrayList<String> key = new ArrayList<>(spots.keySet()); 
        Collections.sort(key);  
        ArrayList<String> free =new ArrayList<>();
        ArrayList<String> busy =new ArrayList<>();
        
        int flagFree=0,flagBusy=0;
   
        for(int i=0;i<size;i++)
        {
            if(spots.get(key.get(i)) == true)  
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
    public void addSpots(){
        int numberOfFloors,numberOfSpots;
        System.out.println("Enter number of floors");
        numberOfFloors=input.nextInt();
        System.out.println("Enter number of spots");
        numberOfSpots=input.nextInt();
        createParking(numberOfFloors,numberOfSpots);
    }
 
}


