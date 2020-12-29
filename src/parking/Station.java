package parking;

import java.util.HashMap;

public class Station {
    
    public static final HashMap<String,Boolean> spots = new HashMap<>();
    protected int operatorId;
    protected String operatorUsername;
    private int adminId;
    private String adminUsername;
       
    
    public void setOperatorId(int id){
        this.operatorId=id;
    }
    
    public void setAdminId(int id){
        this.adminId=id;
    }
    
    public void setOperatorUsername(String username){
        this.operatorUsername=username;
    }
    
    public void setAdminUsername(String username){
        this.adminUsername=username;
    }
    public int getOperatorId(){
        return this.operatorId;
    }
    
    public int getAdminId(){
        return this.adminId;
    }
    
    public String getOperatorUsername(){
        return this.operatorUsername;
    }
    
    public String getAdminUsername(){
        return this.adminUsername;
    }
    
    protected static void creatParking(int numberOfFloors,int spotsInFloor){
        for (int i = 0; i < numberOfFloors; i++) {
            for (int j = 1; j <= spotsInFloor; j++) {
                spots.put(""+(char)(i+65)+""+j,true);
            }
        }
    }
        
}
