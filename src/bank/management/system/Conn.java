package bank.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing a connection to the MySQL database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Saurabh@148");

            // Creating a statement object for executing SQL queries
            s = c.createStatement();
        } catch (Exception e) {
            // Handling any exceptions that may occur during the connection setup
            System.out.println(e);
        }
    }
}
