/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author DELL
 */
public class viewReport {
    int id_operator,start_shift,end_shift ,id_customer;
    double payment;
    String username_customer,username_operator;
    viewReport(int id_operator,String username_operator,int start_shift,int end_shift ,int id_customer,String username_customer,double payment)
    {
        this.id_operator=id_operator;
        this.start_shift=start_shift;
        this.end_shift=end_shift; 
        this.id_customer=id_customer;
        this.payment=payment;
        this.username_customer=username_customer;
        this.username_operator=username_operator;
    
    }
}
