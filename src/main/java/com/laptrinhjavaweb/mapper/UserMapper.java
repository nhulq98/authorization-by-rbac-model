package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IRowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet resultSet) {
        UserModel userModel = new UserModel();
        try {
            userModel.setId(resultSet.getLong("id"));
            userModel.setUserName(resultSet.getString("username"));
            userModel.setPassword(resultSet.getString("password"));
            userModel.setStatus(resultSet.getInt("status"));
            userModel.setRoleId(resultSet.getLong("role_id"));
            userModel.setRoleCode(resultSet.getString("role_code"));
            userModel.setFullName(resultSet.getString("full_name"));

            // way 2: use try catch
            if(resultSet.getString("code") != null){
                RoleModel roleModel = new RoleModel();
                roleModel.setCode(resultSet.getString("code"));
                roleModel.setName(resultSet.getString("name"));
                userModel.setRoleModel(roleModel);
            }

            userModel.setCreatedDate(resultSet.getTimestamp("created_date"));
            userModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
            userModel.setCreatedBy(resultSet.getString("created_by"));
            userModel.setModifiedBy(resultSet.getString("modified_by"));
        } catch (SQLException e) {
            return null;
        }
        return userModel;
    }
}
