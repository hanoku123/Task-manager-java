import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    static String url = "jdbc:mysql://localhost:3306/taskmanager";
    static String username = "Hanoku";
    static String password = "You@1234";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
