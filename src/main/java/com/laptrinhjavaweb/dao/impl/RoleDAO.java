package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.interf.IRoleDAO;
import com.laptrinhjavaweb.mapper.RoleMapper;
import com.laptrinhjavaweb.model.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class RoleDAO extends AbtractDAO<RoleModel> implements IRoleDAO {
    private String TBLROLES = "roles";
    private String TBLROLES_COLUM_ID = "id";
    private String TBLROLES_COLUM_NAME = "name";
    private String TBLROLES_COLUM_CODE = "code";

    private Connection connection;
    private PreparedStatement prStatement;
    private ResultSet resultSet;


    @Override
    public List<RoleModel> findAll() {
        String sql_select = "SELECT * FROM roles" ;
        return query(sql_select, new RoleMapper());
    }

    @Override
    public void insert(RoleModel roleModel) {
        String sql_insert = "INSERT into roles" +
                "(name, code, created_date, modified_date, created_by, modified_by)" +
                " values(?, ?, ?, ?, ?, ?);";
        // get data from roleModel then add into database
        long result = insert(sql_insert, roleModel.getName(),
                roleModel.getCode(), roleModel.getCreatedDate(),
                roleModel.getModifiedDate(), roleModel.getCreatedBy(), roleModel.getModifiedBy());
        notification(result);
    }

    @Override
    public void updateById(RoleModel roleModel) {
        String sql_update = "UPDATE tblroles " +
                "SET name=?, code=?," +
                " created_date=?, modified_date=?, created_by=?, modified_by=?" +
                "WHERE id=?";
        update(sql_update, roleModel.getName(),
                roleModel.getCode(), roleModel.getCreatedDate(),
                roleModel.getModifiedDate(), roleModel.getCreatedBy(),
                roleModel.getModifiedBy(), roleModel.getId());;
    }

    @Override
    public void deleteById(RoleModel roleModel) {
        String sql_delete = "DELETE FROM " + TBLROLES + " WHERE id = ?;";
        update(sql_delete, roleModel.getId());
    }

    public static void main(String[] args) {
        RoleDAO roleDAO = new RoleDAO();
//        List<RoleModel> roleModels = roleDAO.findAll();
//        for(RoleModel roleModel : roleModels){
//            System.out.println(roleModel.getName());
//        }
        RoleModel roleModel1 = new RoleModel();
        roleModel1.setId(3);
        roleModel1.setCode("user-admin");
        roleModel1.setName("quan tri");
        //roleDAO.deleteById(roleModel1);
        roleDAO.insert(roleModel1);

        RoleModel roleModel2 = new RoleModel();
        roleModel2.setId(4);
        roleModel2.setCode("user-user");
        roleModel2.setName("nguoi dung");
        //roleDAO.deleteById(roleModel2);
        roleDAO.insert(roleModel2);

    }
}
