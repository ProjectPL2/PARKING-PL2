package parking;


public class Parking {

    
    public static void main(String[] args){
        
               admin_DDL d=new admin_DDL();
               Operators o =new Operators();
               Customer c=new Customer();
               d.addSpots();
               Station.createDb();
               o.addCustomer("A1");
               d.getInsert();
               c.insert(o, c, d);
              
               
               
    }
}
