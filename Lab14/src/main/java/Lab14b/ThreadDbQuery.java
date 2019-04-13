package Lab14b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class ThreadDbQuery extends Thread{
//    PreparedStatement preparedStmt;
    Connection conn;
    ResultSet resultSet;
    int idQuery;
    long executedTime;

    public ThreadDbQuery(int id){
        this.idQuery = id;
    }

    @Override
    public void run() {
        long startTime = new Date().getTime();

        try {
            Random rd = new Random();
            Thread.sleep(rd.nextInt(3)*1000);

            conn = Demo.connectionPool.getConnection();
            this.resultSet = Demo.selectStudentById(this.conn, this.idQuery);

            this.executedTime = new Date().getTime() - startTime;
            showOutput(resultSet, executedTime);

            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public static void showOutput(ResultSet rs, long time) throws SQLException {
        // show data
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                    + "  " + rs.getString(3));
        }
        System.out.println("Executed Time: " + time);
    }

}
