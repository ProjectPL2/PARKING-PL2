package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class security {
    private static final String user="root";
    private static final String password="";
    private static final String url="jdbc:mysql://localhost/stp11";
    
    static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url,user,password);
    }
}
