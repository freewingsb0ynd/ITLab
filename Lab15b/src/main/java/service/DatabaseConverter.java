package service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


@Service
@Primary
@Scope("singleton")
public class DatabaseConverter implements StandardlizeService {
    private static String DB_URL = "jdbc:mysql://localhost:3306/studentInfo";
    private static String USER_NAME = "root";
    private static String PASSWORD = "hoang@@@123";

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

    public void databaseConvert() {
        try {
            // connnect to database 'studentInfo'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            ResultSet rs = selectAllStudents(conn);
            StringBuilder stringBuilder = new StringBuilder();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3));

                stringBuilder.append(String.format("%s\n", rs.getString(2)));
            }
            writeFile("./inputDB.txt", stringBuilder);

            showOutputTable(selectAllStudents(conn));
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//
//    }
//
    public static void writeFile(String fileName, CharSequence csq) {
        try {
            FileWriter browsersFile = new FileWriter(fileName);
            browsersFile.append(csq);
            browsersFile.flush();
            browsersFile.close();
        } catch (IOException e) {
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


    @Override
    public void convertInputToList() {
        databaseConvert();
    }

//    @Override
//    public void outputFile(LinkedList linkedList) {
//
//    }
}
