package database;
import java.sql.*;

public class Database {
    public static Connection sql = null;

    protected static Statement statement;
    protected static PreparedStatement preparedStatement;
    protected static ResultSet resultSet;
        
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/haykal";
            sql = DriverManager.getConnection(url, "root", "");
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect database!");
        }
        return sql;
    }

    public static void disconnect(){
        try {
            sql.close();
            System.out.println("Database disconnected!");
        } catch (SQLException e) {
            System.out.println("Failed to disconnect database!");
        }
    }
}
