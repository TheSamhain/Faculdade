package JDBC;

import java.sql.*;

public class ConnectionFactory {

    
    public Connection conecta() 
    {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" 
                + "databaseName = dbclientes;";
        try 
        {
             return DriverManager.getConnection(connectionUrl ,"sa","1234");

        } catch (SQLException e) 
        {
          throw new RuntimeException(e);
        } 
    } 
}
