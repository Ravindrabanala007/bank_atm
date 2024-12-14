import java.sql.*;

public class Conn {
    Connection connection;
    Statement statement;

    Conn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankSystem", "root", "1234");
            statement = connection.createStatement();
            System.out.println("connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
