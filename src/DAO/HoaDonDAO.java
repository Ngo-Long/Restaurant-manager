package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HoaDonDAO {

    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=RestaurantManager;encrypt=false";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return conn;
    }
}
