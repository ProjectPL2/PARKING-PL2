package parking;
public class viewReport {
    int id_operator,start_shift,end_shift ,id_customer;
    double payment;
    String username_operator,plate_number;
    viewReport(int id_operator,String username_operator,String plate_number,int start_shift,int end_shift ,int id_customer,double payment)
    {
        this.id_operator=id_operator;
        this.start_shift=start_shift;
        this.end_shift=end_shift; 
        this.id_customer=id_customer;
        this.plate_number=plate_number;
        this.payment=payment;
        this.username_operator=username_operator;
        
        
    
    }
}