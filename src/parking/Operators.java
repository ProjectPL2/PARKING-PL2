package parking;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

public class Operators extends Station{
    
    
    private final Scanner input = new Scanner(System.in);
    
    
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
        try {
            connect = security.getConnection();
            Customer c = new Customer();
            spots.replace(place, Boolean.FALSE);
            c.setId(getCustomerId());
            System.out.print("Enter plate number : ");
            String plateNumber = input.nextLine();
            c.setPlateNumber(plateNumber);
            c.setPlace(place);
            c.setStartDate(Calendar.getInstance());      
            query = "INSERT INTO customers (id_operator,id_customer,plate_number,place,start_dateH,start_dateM) "+
                    "VALUES ('"+operatorId+"','"+getCustomerId()+"','"+plateNumber+"','"+place+"','"+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+
                    "','"+Calendar.getInstance().get(Calendar.MINUTE)+"')";
            st = connect.prepareStatement(query);
            st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            try {
                connect.close();
              
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    
    public int totalParkingHours(Customer c){
        if (c.getEndDate().get(Calendar.MINUTE) >= 30)
            return (c.getEndDate().get(Calendar.HOUR)-c.getStartDate().get(Calendar.HOUR)+1);
        else
            return (c.getEndDate().get(Calendar.HOUR)-c.getStartDate().get(Calendar.HOUR));

    }    
    
    private int getCustomerId(){
        int id = (int)(1+Math.random()*Station.allSpots);      
        try {
            query = "select id_customer from customers where id_customer = '" + id+"'";
            st = connect.prepareStatement(query);
            if(st.execute(query))
                return getCustomerId();
            else
                return id;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
