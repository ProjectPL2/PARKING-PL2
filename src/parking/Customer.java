package parking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;


public class Customer extends Station{
    private int id;
    private String plateNumber;
    private String place;
    private Calendar startDate;
    private Calendar endDate;

    
     Scanner input =new Scanner(System.in).useLocale(Locale.US);
    
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
   
    public void payment(Customer c){
        Operators o=new Operators();
        double exchange,payed,cost=10*o.totalParkingHours(c);
        System.out.println("Enter the Payment: ");
        payed=input.nextDouble();
        if(payed==cost){
            System.out.println("Payment Successfully");
        }else{
            exchange=payed-cost;
            System.out.println("Payment Successfully");
            System.out.println("Entered:"+payed);
            System.out.println("The Exchange is:"+exchange);
        }
    }
    
    public void report(Operators o, Customer e){    
        try {
            ArrayList<viewReport> list=new ArrayList();
            connect=security.getConnection();
            query="select operators.id,operators.username,operators.start_shift,operators.end_shift,"
                    + "customers.id_customer,customers.username_customer from customers join operators "
                    + "on customers.id_operator=operators.id";
            st=connect.prepareStatement(query);
            r=st.executeQuery(query);
            while(r.next()){
                list.add(new viewReport(r.getInt("id"),r.getString("username"),
                r.getInt("start_shift"),r.getInt("end_shift"),r.getInt("id_customer"),
                r.getString("username_customer"),10*o.totalParkingHours(e)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                st.close();
                connect.close();
                r.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }    
}
