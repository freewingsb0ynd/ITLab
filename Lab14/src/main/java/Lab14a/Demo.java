package Lab14a;

import java.sql.*;
import java.sql.Statement;
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

    public static void main(String args[]) {
        //INITIALIZED in DATABASE
//        1  Cong  Hanoi
//        2  Phuong  Vinhphuc
//        3  Hung  Danang
//        4  Nam  Hanoi


        //test to add new students from a list
        List<Student> newStudentList = new ArrayList<Student>();
        newStudentList.add(new Student("Duong", "Haiphong"));
        newStudentList.add(new Student("Hoang", "Namdinh"));
        newStudentList.add(new Student("Van", "Bacgiang"));
        newStudentList.add(new Student("Khanh", "Hanam"));
        newStudentList.add(new Student("Binh", "Quangninh"));


        try {
            // connnect to database 'studentInfo'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//            // crate statement
//            Statement stmt = conn.createStatement();
//            // get data from table 'student'
//            ResultSet rs = stmt.executeQuery("select * from student");

            showOutputTable(selectAllStudents(conn));

//            //test callable statement
//            System.out.println("-----Test Callable Statement-----");
//            insertRow(conn, newStudentList);
//            showOutputTable(selectAllStudents(conn));

            //test stored procedure

            //STORED PROCEDURE IN DATABASE
//            PROCEDURE `getStudentByLargerId`(IN idStudent int)
//            BEGIN
//            select * from student where id > idStudent;
//            END

            System.out.println("-----Test Stored Procedure-----");
            String sql = "CALL getStudentByLargerId(?);";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, 7);            //get all students with id >7
            cs.executeQuery();
            showOutputTable(cs.getResultSet());

            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void insertRow(Connection conn, List<Student> newStudents){
        String sql = "INSERT INTO student (name, address) VALUES (?, ?);";
        try {
        CallableStatement callableStmt = conn.prepareCall(sql);
        for (Student s : newStudents) {
            callableStmt.setString(1, s.getStudentName());
            callableStmt.setString(2, s.getStudentAddress());

            callableStmt.execute();
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectAllStudents(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        // get data from table 'student'
        ResultSet rs = stmt.executeQuery("select * from student");
        return rs;
    }

    public static void showOutputTable(ResultSet rs) throws SQLException {
        // show data
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                    + "  " + rs.getString(3));
        }
    }


}