package avengerspizzaria.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnManager {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria", "root", "1234");
    }
    
    public static void closeConnection(Connection conn) throws Exception {
      conn.close();
    }
}