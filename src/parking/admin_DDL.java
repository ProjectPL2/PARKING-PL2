package parking;
import java.sql.*;
import java.util.Scanner;

public class admin_DDL {
    int id;
    String Name;
    int startShift;
    int endShift;
    static Connection c;
    static Statement s;
    
    
    void getInsert(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter ID: ");
            id = input.nextInt();
            System.out.println("Enter name: ");
            Name = input.next();
            System.out.println("Enter Start work shift: ");
            startShift = input.nextInt();
            System.out.println("Enter End work shift: ");
            endShift = input.nextInt();
            s.execute("insert into PL2 (id ,name ,startShift ,endShift) values ('"+id+"','"+Name+"','"+startShift+"','"+endShift+"')");
            System.out.println("INSERTED");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
        try{
            c.close();
            s.close();
            }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
    
    
    void getUpdate(){
        try{
            c=security.getConnection();
            s = c.createStatement();
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
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                c.close();
                s.close();
                }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }  
    }

    
    void getDelete(){
        try{
            c=security.getConnection();
            s = c.createStatement();
            Scanner input=new Scanner(System.in);
            System.out.println("Enter ID to Delete: ");
            int input1 = input.nextInt();
            s.execute("delete from PL2 where id=('"+input1+"')");
            System.out.println("DELETED");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
        finally{
            try{
                c.close();
                s.close();
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
