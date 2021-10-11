package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.interf.IConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Stack;

public class ConnectionPool implements IConnectionPool {
    protected Stack pool;
    protected String connectionURL;
    protected String userName;
    protected String password;
    ResourceBundle dbResourceBundle = ResourceBundle.getBundle("database");

    public ConnectionPool(String connectionURL, String userName, String password ){
        this.connectionURL = connectionURL;
        this.userName = userName;
        this.password = password;
        // create stack save pool elements
        pool = new Stack();
    }

    // get connect Pool OR create new connect if empty Pool
    @Override
    public Connection getConnection() {
        // if pool not empty - get connect from pool and place call return.
        if(!pool.empty()){
            return (Connection) pool.pop();
        }else {
            // if empty pool. create new pool
            try {
                // Load the Connector driver
                Class.forName(dbResourceBundle.getString("driverName"));
                return DriverManager.getConnection(connectionURL, userName, password);
            } catch (SQLException e) {
                return null;
            } catch (ClassNotFoundException e) {
                return null;
            }
        }

    }

    // return connect for pool
    @Override
    public void releaseConnection(Connection connection) {
        pool.push(connection);
    }
}
