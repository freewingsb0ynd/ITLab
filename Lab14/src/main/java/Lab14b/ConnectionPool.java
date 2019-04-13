package Lab14b;

import java.sql.*;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {

    public static final int MAX_SIZE = 15;
    public static final int INIT_SIZE = 2;
    private int connectionsAlive;
    private int connectionsInQueue;

    private BlockingDeque<Connection> connectionBlockingQueue = new LinkedBlockingDeque<Connection>();


    public ConnectionPool() {
        for (int i = 0; i < INIT_SIZE; i++) {
            createConnection();
        }

        //System.out.println("connectionBlockingQueue " + connectionBlockingQueue.getFirst());
    }

    private void createConnection() {
        if (connectionsInQueue == MAX_SIZE) return ;
        try {
            Connection connection = DriverManager.getConnection(Demo.DB_URL, Demo.USER_NAME, Demo.PASSWORD);
            connectionBlockingQueue.offer(connection);
            connectionsInQueue++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized int connectionsAliveActive () {
        return connectionsAlive;
    }
    public int getSize () {
        return connectionBlockingQueue.size();
    }
    private  boolean isFull() {
        return connectionBlockingQueue.size() >= MAX_SIZE;
    }

    Connection getConnection() throws InterruptedException {
        connectionsAlive++;
        if (connectionBlockingQueue.isEmpty() && connectionsAlive < MAX_SIZE) {
            createConnection();
            return connectionBlockingQueue.poll();
        }

        return connectionBlockingQueue.poll(100, TimeUnit.MILLISECONDS);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
