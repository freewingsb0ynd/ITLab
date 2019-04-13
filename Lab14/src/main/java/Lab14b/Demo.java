package Lab14b;

import Lab14a.Student;

import java.sql.*;
import java.util.*;

public class Demo {
    public static String DB_URL = "jdbc:mysql://localhost:3306/studentInfo";
    public static String USER_NAME = "root";
    public static String PASSWORD = "hoang@@@123";

    static ConnectionPool connectionPool = new ConnectionPool();

    public static void main(String args[]) {
        for (int i = 0; i<10; i++){

        try {
            ThreadDbQuery thread = new ThreadDbQuery(i);
            thread.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        }
    }

    public static ResultSet selectStudentById(Connection conn, int id) throws SQLException {
        String sql = "select * from student where id = ?;";
        CallableStatement callableStmt = conn.prepareCall(sql);

        callableStmt.setInt(1, id);
        callableStmt.execute();
        return callableStmt.getResultSet();
    }
}
