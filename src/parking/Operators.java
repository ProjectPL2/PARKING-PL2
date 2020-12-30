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
            String plateNumber = input.next();
            c.setPlateNumber(plateNumber);
            c.setPlace(place);
            c.setStartDate(Calendar.getInstance());
            System.out.println("1");
            query = "insert into customers (id_operator,id_customer,plate_number,place,start_dateH,start_dateM) "+
                    "values ('"+operatorId+"','"+c.getId()+"','"+plateNumber+"','"+place+"','"
                    +Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+"','"+Calendar.getInstance().get(Calendar.MINUTE)+"')";
            System.out.println("2");
            st = connect.prepareStatement(query);
            System.out.println("3");
            st.executeQuery(query);
            System.out.println("4");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            try {
                connect.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void removeCustomer(Customer c){
        c.setEndDate(Calendar.getInstance());
        try {
            connect = security.getConnection();
            query = "select place from customers where id_customer = "+c.getId();
            st = connect.prepareStatement(query);
            r=st.executeQuery(query);
            String place = r.getString("place");
            spots.replace(place, Boolean.TRUE);
            query = "update customers set end_dateH = '"+
                    Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+"',end_dateM = '"
                    +Calendar.getInstance().get(Calendar.MINUTE)+"',cost = '"+c.getCost()+
                    "where id_customer = "+c.getId();
            st.execute(query);
            query="update totalspots set state ='true'";
            st.execute(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                connect.close();
                st.close();
                r.close();
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
        ArrayList<Integer> ids = new ArrayList<>();
        int id = (int)(1+Math.random()*Station.allSpots); 
        try {
            connect = security.getConnection();
            query = "select id_customer from customers where cost = 0";
            st = connect.prepareStatement(query); 
            r = st.executeQuery(query);
            while (r.next()) {                
                ids.add(r.getInt("id_customer"));
            }
            while (ids.contains(id)) {
                id = (int)(1+Math.random()*Station.allSpots); 
            }
            return id;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            try {
                connect.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
