package parking;

import java.util.Calendar;


public class Customer {
    private int id;
    private String plateNumber;
    private int StartTransactionDate;
    private int endTransactionDate;
    private int totalHours;
    
    public Customer(int id, String plateNumber) {
        this.id = id;
        this.plateNumber = plateNumber;
    }

    public int getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getStartTransactionDate() {
        return StartTransactionDate;
    }

    public int getEndTransactionDate() {
        return endTransactionDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setStartTransactionDate(int StartTransactionDate) {
        this.StartTransactionDate = StartTransactionDate;
    }

    public void setEndTransactionDate(int endTransactionDate) {
        this.endTransactionDate = endTransactionDate;
    }

    
    
    public void getTicket(){
        System.out.println("------------------------------------------------------");
        System.out.println("|                                                    |");
        System.out.println("|            |-------------------------|             |");
        System.out.println("|            |WELCOM TO PARKING STATION|             |");
        System.out.println("|            |-------------------------|             |");        
        System.out.println("|                                                    |");
        System.out.println("|     Customer Id : "+this.id+"                       \t\t|");
        System.out.println("|     Plate Number : "+this.plateNumber+"             \t\t|");
        System.out.println("|                                                    |");
        System.out.println("-----------------------------------------------------");
    }
    
    public int totalParkingHours(){
        totalHours =this.endTransactionDate-this.StartTransactionDate;
        System.out.println(this.endTransactionDate);
        System.out.println(this.StartTransactionDate);
        return totalHours;
    }
}
