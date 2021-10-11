package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements IRowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet resultSet) {
        try{
            RoleModel roleModel = new RoleModel();

            roleModel.setId(resultSet.getLong("id"));
            roleModel.setName(resultSet.getString("name"));
            roleModel.setCode(resultSet.getString("code"));

            roleModel.setCreatedDate(resultSet.getTimestamp("created_date"));
            roleModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
            roleModel.setCreatedBy(resultSet.getString("created_by"));
            roleModel.setModifiedBy(resultSet.getString("modified_by"));
            return roleModel;
        }catch (SQLException e){
            return null;
        }
    }
}
