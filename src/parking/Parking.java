package parking;


public class Parking {

    
    public static void main(String[] args) throws InterruptedException {
               
        Station.creatParking(3, 5);
<<<<<<< HEAD
        admin_DDL.getAllSpots();
        Customer c=new Customer();
        new Operators(){}.addCustomer("A1");
        new Operators(){}.addCustomer("A3");
        new Operators(){}.addCustomer("B1");
        new Operators(){}.getFreeSpots();
}
=======
        
      /*   Operators o=new Operators();
        o.addCustomer("A1");
        o.addCustomer("A2");
        o.addCustomer("A3");
        admin_DDL.getAllSpots();*/
      
      Station.createDb();

    }
>>>>>>> 0d297696ee1a9be512b6cb4de30487bf561a1a9c
}
