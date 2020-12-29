package parking;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Operators extends Station{
    
    private final Scanner input = new Scanner(System.in);

    
    public Operators(int id, String name) {
        this.operatorId = id;
        this.operatorUsername = name;
         
    }

     public void setId(int id)
    {
        operatorId=id;
    }
    public int getId()
    {
        return operatorId;
    }
     public void setName(String name)
    {
        operatorUsername=name;
    }
    public String getName()
    {
        return operatorUsername;
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
    
    public void addCustomer(String place){
        Customer c = new Customer();
        Station.spots.replace(place, Boolean.FALSE);
        System.out.print("Enter plate number : ");
        String plateNumber = input.nextLine();
        c.setPlateNumber(plateNumber);
        c.setPlace(place);
        c.setStartDate(Calendar.getInstance());
        c.add();
    }
    
    public void removeCustomer(String place,Customer c){
        Station.spots.replace(place, Boolean.TRUE);
        c.setEndDate(Calendar.getInstance()); 
    }
    
    public int totalParkingHours(Customer c){
        if (c.getEndDate().get(Calendar.MINUTE) >= 30)
            return (c.getEndDate().get(Calendar.HOUR)-c.getStartDate().get(Calendar.HOUR)+1);
        else
            return (c.getEndDate().get(Calendar.HOUR)-c.getStartDate().get(Calendar.HOUR));
    }
    
}
