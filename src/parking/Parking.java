
package parking;


public class Parking {


    public static void main(String[] args) {
        Operators o = new Operators(1, "ahmed"); 
        o.creatParking(3, 10);
        o.addCustomer("A2");
        o.addCustomer("A3");
        o.addCustomer("B2");
        o.addCustomer("C1");
        o.addCustomer("A5");
        o.addCustomer("A7");
        o.addCustomer("B9");
        o.addCustomer("C5");
        o.getFreeSpots(Station.spots);
    } 
}
