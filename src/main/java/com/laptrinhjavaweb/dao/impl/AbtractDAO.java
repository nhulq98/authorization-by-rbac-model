package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.interf.GenericDAO;
import com.laptrinhjavaweb.mapper.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbtractDAO<T> implements GenericDAO<T> {
    //private String DATABASE_NAME = "newservlet2020";
//    private String PASSWORD = "123456";
//    private String URL = "jdbc:mysql://127.0.0.1:3306/newservlet2020";
//    private String USER = "root";
    ResourceBundle bdBundle = ResourceBundle.getBundle("database");
    private String PASSWORD = bdBundle.getString("password");
    private String URL = bdBundle.getString("url");
    private String USER = bdBundle.getString("userName");
    ConnectionPool connectionPool = new ConnectionPool(URL, USER, PASSWORD);

//    private String CREATED_DATE = "created_date";
//    private String MODIFIED_DATE = "modified_date";
//    private String CREATED_BY = "created_by";
//    private String MODIFIED_BY = "modified_by";

    private Connection connection;
    private static PreparedStatement prStatement;
    private static ResultSet resultSet;

    @Override
    public Connection getConnection() {
//        // Establish connection to MySQL
//        try {
//            // Load the Connector driver
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (SQLException | ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            return null;
//        }
        return connectionPool.getConnection();
    }

    // generic function "close" relationship objects with Database
    @Override
    public void closeAll(Connection connection, PreparedStatement prStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (prStatement != null) {
                prStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            return;
        }
    }
    // generic function "notification"
    @Override
    public void notification(long result) {
        if(result != 0){//delete success
            System.out.println("Success!!");
        }else{
            System.out.println("Fail!!");
        }
    }

    @Override
    public long insert(String sql, Object... parameters) {
        Long id = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            prStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // set parameter
            setParameters(prStatement, parameters);

            prStatement.executeUpdate();
            ResultSet resultSet = prStatement.getGeneratedKeys();
            if(resultSet.next()){
                id = resultSet.getLong(1);
            }
            connection.commit();
            //It returns an integer value representing the number of rows affected
//            return  prStatement.executeUpdate();
            return id;
        }catch (SQLException e){
            try {
                connection.rollback();// return and database not change
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }finally {
            //closeAll(connection, prStatement, resultSet);
            connectionPool.releaseConnection(connection);
        }
    }

    //generic function for update and delete in database
    @Override
    public void update(String sql, Object... parameters) {
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            prStatement = connection.prepareStatement(sql);
            // set parameter
            setParameters(prStatement, parameters);

            prStatement.executeUpdate();

            connection.commit();
            //It returns an integer value representing the number of rows affected
//            return  prStatement.executeUpdate();

        }catch (SQLException e){
            try {
                connection.rollback();// return and database not affected
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            //closeAll(connection, prStatement, resultSet);
            connectionPool.releaseConnection(connection);
        }
    }

    // generic function "get data"
    @Override
    public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {

        List<T> results = new ArrayList<>();
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            prStatement = connection.prepareStatement(sql);

            // set parameters
            if(parameters.length != 0)
            setParameters(prStatement, parameters);

            resultSet = prStatement.executeQuery();
            while (resultSet.next()) {

                //get All data from resultset
                results.add(rowMapper.mapRow(resultSet));
            }
            connection.commit();
            return results;

        } catch (SQLException e) {
            try {
                if(connection != null){
                    connection.rollback();
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }

            return null;
        } finally {

            //closeAll(connection, prStatement, resultSet);
            connectionPool.releaseConnection(connection);
        }
    }
    
    @Override
    public void setParameters(PreparedStatement prStatement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                //way 1:
                //prStatement.setObject(i + 1, parameters[i]);

                //way 2:
                Object parameter = parameters[i];
                int index = i + 1;
                if(parameter instanceof Long){
                    prStatement.setLong(index, (Long)parameter);
                }else if(parameter instanceof String){
                    prStatement.setString(index, (String)parameter);
                }else if(parameter instanceof Timestamp){
                    prStatement.setTimestamp(index, (Timestamp)parameter);
                } else if(parameter instanceof Integer){
                    prStatement.setInt(index, (Integer)parameter);
                }else if(parameter == null){
                    prStatement.setNull(index, Types.NULL);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int count(String sql, Object... parameters) {
        int count = 0;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            prStatement = connection.prepareStatement(sql);
            // set parameters
            if(parameters.length != 0)
                setParameters(prStatement, parameters);

            resultSet = prStatement.executeQuery();
            while (resultSet.next()) {
                //get data from resultset
                return resultSet.getInt("count(*)");
            }
            connection.commit();
            return count;

        } catch (SQLException e) {
            try {
                if(connection != null){
                    connection.rollback();
                }
            }catch (SQLException e1){
                return 0;
            }

            return 0;
        } finally {
            //closeAll(connection, prStatement, resultSet);
            connectionPool.releaseConnection(connection);
        }
    }
}
