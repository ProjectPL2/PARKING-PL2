package parking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;


public class Customer {
 private int id;
    private String plateNumber;
    private String place;
    private Calendar startDate;
    private Calendar endDate;
    static Connection c;
    static Statement s;
    

    public void setId(int id) {
        this.id = id;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    
    public String getPlace() {
        return place;
    }
    
    public int getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
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
        System.out.println("|     Date : "+this.startDate.get(Calendar.HOUR_OF_DAY)+":"+this.startDate.get(Calendar.MINUTE)+
                           "             \t\t|");
        System.out.println("|                                                    |");
        System.out.println("-----------------------------------------------------");
    }
  
    public void add(){
        try {
            c = security.getConnection();
            s = c.createStatement();
            s.executeUpdate("INSERT INTO info (ID,PLATENUMBER,STARTDATEH,STARTDATEM,PLACE)"+
                    "VALUES ('"+this.id+"','"+this.plateNumber+"','"+this.startDate.get(Calendar.HOUR_OF_DAY)+
                    "','"+this.startDate.get(Calendar.MINUTE)+"','"+this.place+")");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//UPDATE info SET ENDDATEH=,ENDDATEM= WHERE 1  
    public void remve(){
        try {
            c = security.getConnection();
            s = c.createStatement();
            s.executeUpdate("UPDATE info SET ENDDATEH = "+this.startDate.get(Calendar.HOUR_OF_DAY)+
                            ",ENDDATEM="+ this.startDate.get(Calendar.HOUR_OF_DAY)+" WHERE id = " + this.id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
