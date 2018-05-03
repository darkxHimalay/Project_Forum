package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginmodule", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        new ConnectionProvider().getConnection();
    }
}