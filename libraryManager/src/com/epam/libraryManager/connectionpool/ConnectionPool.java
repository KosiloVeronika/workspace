package com.epam.libraryManager.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {
	private static ConnectionPool instance;
    private final int connectionsCount;
    private final BlockingQueue<Connection> connectionList;
    
    private final static String DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
    private final static String DB_PATH = "jdbc:mysql://localhost:3306/library_db";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "12345";
    
    private ConnectionPool() throws ConnectionPoolException{
        try {
            connectionsCount = 10;
            connectionList = new ArrayBlockingQueue<>(connectionsCount);
            Class.forName(DRIVER_CLASS);
            
            for (int i = 0; i < connectionsCount;i++){
                connectionList.add(DriverManager.getConnection(DB_PATH, LOGIN, PASSWORD));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ConnectionPoolException(ex);
        }
    }
    
    public static ConnectionPool getInstance() throws ConnectionPoolException{
        if (instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }
    
    public Connection getConnection() throws ConnectionPoolException{
        Connection connection = null;
        try {
            connection = connectionList.take();
        } catch (InterruptedException ex) {
            throw  new ConnectionPoolException(ex);
        }
        return connection;
    }
    
    public void freeConnection(Connection connection)  throws ConnectionPoolException{
        try {
            if (connection != null){
                connectionList.put(connection);
            }
        } catch (InterruptedException ex) {
            throw  new ConnectionPoolException(ex);
        }
    }
    
    public void closeConnections() throws ConnectionPoolException{
        for (int i = 0; i < connectionsCount;i++){
            try {
                connectionList.take().close();
            } catch (InterruptedException | SQLException ex) {
                throw new  ConnectionPoolException(ex);
            }
        }
        instance = null;
    }
}