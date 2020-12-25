
package parking;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class Parking {


    public static void main(String[] args) throws InterruptedException {
        Customer c =new Customer(1,"abc 123");
        Operators o = new Operators(1, "ahmed");        
        o.addCustomer("A1", c);
        //nemeen in
        //hi nemeen طز فيكى
        TimeUnit.SECONDS.sleep(10);
    }
    
    /*class admin_DDL{
    String Name;
    int startShift;
    int endShift;
    
    admin_DDL(){}

    void getInsert(){
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project1","root","");
        Statement s = con.createStatement();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        Name = input.next();
        System.out.println("Enter Start work shift: ");
        startShift = input.nextInt();
        System.out.println("Enter End work shift: ");
        endShift = input.nextInt();
        s.execute("insert into PL2 (name ,startShift ,endShift) values ('"+Name+"','"+startShift+"','"+endShift+"')");
        System.out.println("INSERTED");
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
    }
    
    void getUpdate(){
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project1","root","");
        Statement s = con.createStatement();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter ID to Update: ");
        int input1 = input.nextInt();
        System.out.println("Enter new start shift: ");
        startShift =input.nextInt();
        System.out.println("Enter new end shift: ");
        endShift =input.nextInt();
        s.execute("update PL2 set startShift ='"+startShift+"' where id=('"+input1+"')");
        s.execute("update PL2 set endShift ='"+endShift+"' where id=('"+input1+"')");
        System.out.println("UPDATED");
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
    }  
    
    void getDelete(){
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project1","root","");
        Statement s = con.createStatement();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter ID to Delete: ");
        int input1 = input.nextInt();
        s.execute("delete from PL2 where id=('"+input1+"')");
        System.out.println("DELETED");
            }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
        }
    }*/
}
