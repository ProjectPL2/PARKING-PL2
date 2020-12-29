package parking;

import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Customer {
    private int id;
    private String plateNumber;
    private Calendar transactionDate;
    
    public Customer(int id, String plateNumber) {
        try {
            this.id = id;
            this.plateNumber = plateNumber;
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/stp11", "root", "");
            Statement s = c.createStatement();
            s.executeUpdate("insert into CUSTOMER (id,plateNumber) values('"+this.id+"','"+this.plateNumber+"')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
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
        System.out.println("|     Date : "+this.transactionDate+"             \t\t|");
        System.out.println("|                                                    |");
        System.out.println("-----------------------------------------------------");
    }
    
    
}
