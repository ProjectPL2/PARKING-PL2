package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class security {
    private final String user="root";
    private final String password="";
    private final String uri="jdbc:mysql://localhost/employee";
    public Connection con() throws SQLException
    {
        return DriverManager.getConnection(uri,user,password);
    }
}
