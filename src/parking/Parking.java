package parking;

public class Parking {

    
    public static void main(String[] args) throws InterruptedException {
               
        Station.creatParking(3, 5);
        
      /*   Operators o=new Operators();
        o.addCustomer("A1");
        o.addCustomer("A2");
        o.addCustomer("A3");
        admin_DDL.getAllSpots();*/
      
      Station.createDb();

    }
}
