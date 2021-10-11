package com.laptrinhjavaweb.dao.interf;

import java.sql.Connection;

public interface IConnectionPool {
    Connection getConnection();
    void releaseConnection(Connection connection);
}
