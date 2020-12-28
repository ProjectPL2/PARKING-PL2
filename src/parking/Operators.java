package parking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Operators {
    private int operator_id;
    private String operator_name;
    protected Calendar startDate;
    protected Calendar endDate;

    public Operators(int id, String name) {
        this.operator_id = id;
        this.operator_name = name;
         
    }

     public void setId(int id)
    {
        operator_id=id;
    }
    public int getId()
    {
        return operator_id;
    }
     public void setName(String name)
    {
        operator_name=name;
    }
    public String getName()
    {
        return operator_name;
    }
    
    public void getFreeSpots(HashMap spots)
    {
        int size=spots.size();
        
        ArrayList<String> key = new ArrayList<>(spots.keySet()); 
        ArrayList<Boolean> value= new ArrayList<>(spots.values());

        ArrayList<String> free =new ArrayList<>();
        
        int flag =0; //to check if there are free spots or not
        for(int i=0;i<size;i++)
        {
            if(value.get(i) == true)
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
    
    public void addCustomer(String place , Customer c){
        this.startDate = Calendar.getInstance(); 
        Station.addCustomer(place);
        c.setTransactionDate(startDate);               
    }
    
    public void removeCustomer(String place,Customer c){
        this.endDate = Calendar.getInstance();
        Station.removeCustomer(place);
    }
    
    public int totalParkingHours(){
        if (endDate.get(Calendar.MINUTE) >= 30)
            return (this.endDate.get(Calendar.HOUR)-this.startDate.get(Calendar.HOUR)+1);
        else
            return (this.endDate.get(Calendar.HOUR)-this.startDate.get(Calendar.HOUR));
    }
    
}
