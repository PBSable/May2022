import java.sql.*;
import java.util.Scanner;

public class VulnerableApp {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test", "root", "password");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // ❌ SQL Injection vulnerability
        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("User found: " + rs.getString("username"));
        }

        conn.close();
    }
}