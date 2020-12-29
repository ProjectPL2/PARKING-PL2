
package parking;

public interface MyInterface {
     public void getFreeSpots();
     public void addCustomer(String place);
     public void removeCustomer(String place,Customer c);
     public int totalParkingHours(Customer c);
     public void Payment(Customer c, double payed);
     void getInsert();
     void getUpdate();
     
}
