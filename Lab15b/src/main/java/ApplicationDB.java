import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StandardlizeService;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

@Slf4j
@SpringBootApplication
public class ApplicationDB{
    @Autowired
    StandardlizeService inputConverter;

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

    public static void databaseConvert() {
        try {
            // connnect to database 'studentInfo'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            ResultSet rs = selectAllStudents(conn);
            StringBuilder stringBuilder = new StringBuilder();
            while (rs.next()) {
                stringBuilder.append(String.format("%s \n", rs.getString(2)));
            }
            writeFile("./src/main/java/inputDB.txt", stringBuilder);

            //showOutputTable(selectAllStudents(conn));
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

    public static void main(String[] args)  throws InterruptedException{
        databaseConvert();

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/config.xml")){
            Thread.sleep(3000);
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
