package parking;


public class Parking {

    
    public static void main(String[] args) throws InterruptedException {
               
        Station.creatParking(3, 5);
        admin_DDL.getAllSpots();
        Customer c=new Customer();
        new Operators(){}.addCustomer("A1");
        new Operators(){}.addCustomer("A3");
        new Operators(){}.addCustomer("B1");
        new Operators(){}.getFreeSpots();
}
}
