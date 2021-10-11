package com.laptrinhjavaweb.dao.interf;

import com.laptrinhjavaweb.mapper.IRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface GenericDAO<T> {
    List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);

    // use for insert
    long insert(String sql, Object ... parameters);

    //use for update, delete
    void update(String sql, Object ... parameters);

    Connection getConnection();

    void closeAll(Connection connection, PreparedStatement prStatement, ResultSet resultSet);

    void notification(long result);

    void setParameters(PreparedStatement prStatement, Object... parameters);
    //void insertCommon(T object);

    int count(String sql, Object... parameters);
}
