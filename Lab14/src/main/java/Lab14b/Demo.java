package Lab14b;

import java.sql.*;
import java.util.*;

public class Demo {
    private static String DB_URL = "jdbc:mysql://localhost:3306/studentInfo";
    private static String USER_NAME = "root";
    private static String PASSWORD = "hoang@@@123";

    /**
     * create connection
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
    
    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

}
