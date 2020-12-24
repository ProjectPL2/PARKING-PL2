package parking;

import java.util.Calendar;

public class Operators {
    
    private int id;
    private String name;
    protected Calendar startDate;
    protected Calendar endDate;

    public Operators(int id, String name) {
        this.id = id;
        this.name = name;
         
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public void addCustomer(String place , Customer c){
        this.startDate = Calendar.getInstance(); 
        Station.addCustomer(place);
        c.setStartTransactionDate(startDate.get(Calendar.SECOND));
        
    }
    
    public void removeCustomer(String place,Customer c){
        this.endDate = Calendar.getInstance();
        Station.removeCustomer(place);
        c.setEndTransactionDate(endDate.get(Calendar.SECOND));
    }
    
    
    
}
