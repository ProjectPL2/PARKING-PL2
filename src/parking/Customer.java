
package parking;


public class Customer {
    private int id;
    private String transactionDate ;
    private String plateNumber;

    public Customer(int id, String transactionDate, String plateNumber) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.plateNumber = plateNumber;
    }

    public int getId() {
        return id;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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
        System.out.println("|     Transaction Date : "+this.transactionDate+"    \t\t|");
        System.out.println("|                                                    |");
        System.out.println("-----------------------------------------------------");
    }
}
