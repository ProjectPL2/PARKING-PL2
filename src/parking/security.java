package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class security {
    private final String user="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost/employee";
    
    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url,user,password);
    }
}
