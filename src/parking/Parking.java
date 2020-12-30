package parking;

import java.util.Scanner;


public class Parking extends security{

    
    public static void main(String[] args){
        
        
        Operators operator = newOperator();
        operator.addCustomer("A1");
//        operator.addCustomer("B1");
//        operator.addCustomer("A3");
//        operator.addCustomer("B7");
//        operator.addCustomer("A5");
//        operator.addCustomer("C1");
//        operator.addCustomer("C2");
//        operator.addCustomer("C5");
    }
    
    public static admin_DDL newAdmin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your id : ");  
        int id = input.nextInt();
        System.out.println("Enter your username : ");
        String usernman = input.next();
        return logInAdmin(id,usernman);
    }
    
    public static Operators newOperator(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your id : ");  
        int id = input.nextInt();
        System.out.println("Enter your username : ");
        String usernman = input.next();
        return logInOperator(id,usernman);
    }
}
