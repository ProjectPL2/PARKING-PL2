package parking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Station {
    
    
    public static final HashMap<String,Boolean> spots = new HashMap();
    protected int operatorId;
    protected String operatorUsername;
    private int adminId;
    private String adminUsername;
    private int startShift;
    private int endShift;
    static Connection connect;
    static int numberOfFloors;
    static int numberOfSpots;
    static int allSpots;
    static Statement st;
    static String query;
    static ResultSet r;
    private static ArrayList<String> key = new ArrayList(); 
    
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
    
    public void setStartShift(int start){
        this.startShift=start;
    }
    public int getStartShift(){
        return this.startShift;
    }
    
    public void setEndShift(int end){
        this.endShift=end;
    }
    public int getEndShift(){
        return this.endShift;
    }
    
    protected static  void createParking(int numberOfFloors,int spotsInFloor){
        
        for (int i = 0; i < numberOfFloors; i++) {
            for (int j = 1; j <= spotsInFloor; j++) {
                spots.put((char)(i+65)+""+j,true);
                key.add((char)(i+65)+""+j);
            }
        }
    }

    public static void createDb()
    {
        try{
            connect=security.getConnection();
            for(int i=0;i<spots.size();i++)
            {
                query="insert into totalspots values('"+key.get(i)+"','true')";
                st=connect.prepareStatement(query);
                st.execute(query);
            }
           
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                connect.close();
                st.close();
                
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }  
    
    public void addPlace(String place){
        try{
            connect=security.getConnection();
            for(int i=0;i<spots.size();i++)
            {
                query="insert into totalspots values('"+key.get(i)+"','true')";
                st=connect.prepareStatement(query);
                st.execute(query);
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally{
            try{
                connect.close();
                st.close();
                
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
