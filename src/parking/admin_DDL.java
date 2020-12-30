package parking;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class admin_DDL extends Station {
   
    
    Scanner input = new Scanner(System.in);
    public void insertOperator(){
        try{
            connect=security.getConnection();           
            System.out.println("Enter name: ");
            setOperatorUsername(input.next());
            System.out.println("Enter Start work shift: ");
            setStartShift(input.nextInt());
            System.out.println("Enter End work shift: ");
            setEndShift(input.nextInt());
            query = "insert into operators (username ,start_shift ,end_shift) values ('"+getOperatorUsername()+
                    "','"+ getStartShift()+"','"+ getEndShift()+"')";
            st = connect.prepareStatement(query);
            st.execute(query);
            System.out.println("INSERTED");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                connect.close();
                st.close();
                }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    public void updateOperator(){
        try{
            connect=security.getConnection();
            System.out.println("Enter ID to Update: ");
            int id = input.nextInt();
            System.out.println("Enter new start shift: ");
            setStartShift(input.nextInt());
            System.out.println("Enter new end shift: ");
            setEndShift(input.nextInt());
            query = "update PL2 set startShift ='"+getStartShift()+"',endShift ='"+getEndShift()+"' where id=('"+id+"')";
            st = connect.prepareStatement(query);
            st.execute(query);
            System.out.println("UPDATED");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                connect.close();
                st.close();
                }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }  
    }

    
    public void deleteOperator(){
        try{
            connect=security.getConnection();           
            System.out.println("Enter ID to Delete: ");
            int id = input.nextInt();
            query = "delete from PL2 where id=('"+id+"')";
            st = connect.prepareStatement(query);
            st.execute(query);
            System.out.println("DELETED");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
        finally{
            try{
                connect.close();
                st.close();
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void viewAllSpots()
    {  
        int size=spots.size();       
        ArrayList<String> key = new ArrayList<>(spots.keySet()); 
        Collections.sort(key);  
        ArrayList<String> free =new ArrayList<>();
        ArrayList<String> busy =new ArrayList<>();
        
        int flagFree=0,flagBusy=0;
   
        for(int i=0;i<size;i++)
        {
            if(spots.get(key.get(i)) == true)  
            {
                 free.add(key.get(i));  
                 flagFree=1;
            }   
            else
            {              
                busy.add(key.get(i));
                flagBusy=1;
            }
        }        
        if(flagFree==0)
            System.out.println("there are no free spots");
        else
        {
            System.out.println("the free spots are :");
            for (int i = 0; i < free.size(); i++)  
            {
                System.out.print(free.get(i) + " ");
            }          
        }
        System.out.println("\n------------------------------------");
        if(flagBusy==0)   
            System.out.println("there are no busy spots");
        else
        {
            System.out.println("the busy spots are :");
            for (int i = 0; i < busy.size(); i++)  
            {
                System.out.print(busy.get(i) + " ");
            }
           System.out.print("\n");
        }                     
    }
    
    public void addSpots(){       
        System.out.println("Enter number of floors");
        Station.numberOfFloors=input.nextInt();
        System.out.println("Enter number of spots");
        Station.numberOfSpots=input.nextInt();
        Station.allSpots = Station.numberOfFloors * Station.numberOfSpots;
        createParking(numberOfFloors,numberOfSpots);
    }
    
    void viewParkedCar(){
        try{
            ArrayList<element> list=new ArrayList();
            connect=security.getConnection();
            query = "select username,id_customer,plate_number,place,start_dateH,start_dateM from customers"
                    + "join totalspots on totalspots.place = customers.place"
                    + "where totalspots.state = 'false'";
            st = connect.prepareStatement(query);
            r=st.executeQuery(query);
            while(r.next()){
                list.add(new element(r.getString("username"),r.getInt("id_customer"),r.getString("plate_number")
                                    ,r.getString("place"),r.getInt("start_dateH"),r.getInt("start_dateM")));
            }
            for(int i=0;i<list.size();i++)
            {
                System.out.print(list.get(i).username+"|" + list.get(i).id_customer+"|"+list.get(i).plate_number+"|"+
                                 list.get(i).place+"|" +list.get(i).start_dateH+"|"+list.get(i).start_dateM+"|"  );
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
        finally{
        try{
            connect.close();
            st.close();
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
            }
        }
    }
    public void viewReportPayment(Operators o, Customer e){
     
        try {
            ArrayList<viewReport> list=new ArrayList();
            connect=security.getConnection();
            query="select operators.id,operators.username,operators.start_shift,operators.end_shift,"
                    + "customers.id_customer,customers.plate_number from customers join operators "
                    + "on customers.id_operator=operators.id";
            st=connect.prepareStatement(query);
            r=st.executeQuery(query);
            while(r.next()){
                list.add(new viewReport(r.getInt("id"),r.getString("username"),r.getString("plate_number"),
                    r.getInt("start_shift"),r.getInt("end_shift"),r.getInt("id_customer"),10*o.totalParkingHours(e)));          
             }
             System.out.println("                                |------------------------------------|");
             System.out.println("                                |  View Shifts Report With Payement  |                     ");
             System.out.println("                                |------------------------------------|");
             for(int i=0;i<list.size();i++){
                 System.out.println("Customer id is: "+list.get(i).id_customer+"\n"+"Customer Plate number: "+list.get(i).plate_number
                         +"\n"+"The Payment is :"+list.get(i).payment+"\n"+"By Username Operator: "+list.get(i).username_operator+"\n"+"And Operator id: "+list.get(i).id_operator
                         +"\n"+"His/Her Start Shift is : "+list.get(i).start_shift +"\n"+"His/Her End Shift is : "+list.get(i).end_shift);
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                st.close();
                connect.close();
                r.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
 
}


