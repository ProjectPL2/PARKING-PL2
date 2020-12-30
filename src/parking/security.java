package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public  class security {
    private static final String USER="root";
    private static final String PASSWORD="";
    private static final String URL="jdbc:mysql://localhost/test11";
    private static Connection connct;
    private static Statement st;
    private static ResultSet r;
    public static ArrayList<retrieveAdmins> admins = new ArrayList();
    public static ArrayList<retrieveOperators> operators = new ArrayList();
    
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static admin_DDL logInAdmin(int id,String username){
        boolean flag = false;
        try {
            connct = getConnection();
            String query = "select * from admin";
            st = connct.prepareStatement(query);
            r = st.executeQuery(query);
            while (r.next()) {                
                if (id == r.getInt("id_admin") && username.equals(r.getString("username_admin")))
                    flag = true;
            }
            if(flag)
                return new admin_DDL();
            else{
                System.out.println("This user dose not exist!!");
                return null;
            }    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }finally{
            try {
                connct.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static Operators logInOperator(int id,String username){
        boolean flag = false;
        try {
            connct = getConnection();
            String query = "select * from operators";
            st = connct.prepareStatement(query);
            r = st.executeQuery(query);
            while (r.next()) {                
                if (id == r.getInt("id") && username.equals(r.getString("username")))
                    flag = true;
            }
            if(flag)
                return new Operators();
            else{
                System.out.println("This user dose not exist!!");
                return null;
            }    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }/*finally{
            try {
                connct.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }*/
    }
}
