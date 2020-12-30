package parking;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

public class Operators extends Station{
    
    
    private final Scanner input = new Scanner(System.in);
    static Connection con;
    static Statement s;
    
    
    public void getFreeSpots(){
        int size=spots.size();
        
        ArrayList<String> key = new ArrayList<>(spots.keySet()); 
        Collections.sort(key); 
        ArrayList<String> free =new ArrayList<>();
        
        int flag =0; //to check if there are free spots or not
        for(int i=0;i<size;i++)
        {
            if(spots.get(key.get(i)) == true)
            {
                flag=1;
                free.add(key.get(i));
            }        
        }
        
        if(flag==0)
            System.out.println("sorry there is no free spot");
        else
        {
            System.out.println("the free spots are :");
            for (int i = 0; i < free.size(); i++)  
            {
                System.out.print(free.get(i) + " ");
            }
              
           System.out.println("\nwhat do you think of the place (\"" + free.get(0) +"\")? " + "I think it's better");
        }      
           
    }
    
    public void addCustomer(String place){
        Customer c = new Customer();
        spots.replace(place, Boolean.FALSE);
       System.out.print("Enter plate number : ");
        String plateNumber = input.nextLine();
        c.setPlateNumber(plateNumber);
        c.setPlace(place);
        c.setStartDate(Calendar.getInstance());
        try {
            con = security.getConnection();
            s = con.createStatement();
            s.executeUpdate("INSERT INTO info (PLATENUMBER,STARTDATEH,STARTDATEM,PLACE)"+
                    "VALUES ('"+plateNumber+"','"+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+
                    "','"+Calendar.getInstance().get(Calendar.MINUTE)+"','"+place+")");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeCustomer(String place,Customer c){
        spots.replace(place, Boolean.TRUE);
        c.setEndDate(Calendar.getInstance()); 
        try {
            con = security.getConnection();
            s = con.createStatement();
            s.executeUpdate("UPDATE info SET ENDDATEH = "+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+
                            ",ENDDATEM="+ Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+" WHERE id = 1 ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
              
    }
    
    public int totalParkingHours(Customer c){
        if (c.getEndDate().get(Calendar.MINUTE) >= 30)
            return (c.getEndDate().get(Calendar.HOUR)-c.getStartDate().get(Calendar.HOUR)+1);
        else
            return (c.getEndDate().get(Calendar.HOUR)-c.getStartDate().get(Calendar.HOUR));

    }
 

 
   
    
}
