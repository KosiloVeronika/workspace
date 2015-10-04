package com.epam.libraryManager.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public final class ConnectionPool {
	
	private static final Logger LOG = Logger.getLogger(ConnectionPool.class);
	private static AtomicBoolean instanceCreated = new AtomicBoolean();
	private static ConnectionPool instance;	
    private final int connectionsCount;
    private static ReentrantLock lock = new ReentrantLock();
    private final BlockingQueue<Connection> connectionList;

    
    private final static String DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
    private final static String DB_PATH = "jdbc:mysql://localhost:3306/library_db";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "12345";
    
    private ConnectionPool() {
        try {
            connectionsCount = 30;
            connectionList = new ArrayBlockingQueue<>(connectionsCount);
            Class.forName(DRIVER_CLASS);
            
            for (int i = 0; i < connectionsCount;i++){
                connectionList.add(DriverManager.getConnection(DB_PATH, LOGIN, PASSWORD));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
        	LOG.fatal(ex);
			throw new ExceptionInInitializerError(ex);
		}
    }
    
    public static ConnectionPool getInstance() {
    	if(!instanceCreated.get()) {
			lock.lock();
			try {
				if(!instanceCreated.get()) {
					instance = new ConnectionPool();
					instanceCreated.set(true);
				}
			} finally {
				lock.unlock();
			}
		}
		return instance;
    }
    
    public Connection getConnection() throws ConnectionPoolException{
        Connection connection;
        try {
            connection = connectionList.take();
        } catch (InterruptedException ex) {
            throw  new ConnectionPoolException(ex);
        }
        return connection;
    }
    
    public void freeConnection(Connection connection)  {
        try {
            if (connection != null){
                connectionList.put(connection);
            }
        } catch (InterruptedException ex) {
    			LOG.error(ex);
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
