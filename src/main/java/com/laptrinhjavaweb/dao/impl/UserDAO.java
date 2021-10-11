package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.interf.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDAO extends AbtractDAO<UserModel> implements IUserDAO {
    private String TBLUSERS = "users";
    private String TBLUSERS_COLUM_ID = "id";
    private String TBLUSERS_COLUM_NAME = "name";
    private String TBLUSERS_COLUM_PASSWORD = "password";
    private String TBLUSERS_COLUM_FULLNAME = "full_name";
    private String TBLUSERS_COLUM_STATUS = "status";
    private String TBLUSERS_COLUM_ROLE_ID = "role_id";

    private Connection connection;
    private PreparedStatement prStatement;
    private ResultSet resultSet;

    @Override
    public List<UserModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM users AS u INNER JOIN roles as r ON u.role_id = r.id");
        if(pageble.getSorter().getSortName() != null){
            sql.append(" ORDER BY "+ pageble.getSorter().getSortBy() +" " + pageble.getSorter().getSortName() + "");
        }
        if(pageble.getOffset() >= 0 && pageble.getLimit() > 0){
            sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+";");
        }

//        String sql_select = " SELECT * FROM news LIMIT ?, ?";
        return query(sql.toString(), new UserMapper());
    }

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users AS u INNER JOIN roles as r ON u.role_id = r.id";
        return query(sql.toString(), new UserMapper());
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
        if(userName.trim().equals("") || password.trim().equals(""))
            return null;
        StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
        sql.append(" INNER JOIN roles as r ON u.role_id = r.id");

        sql.append(" WHERE username = ? AND password = ? AND status = ?;");
        List<UserModel> userModels = query(sql.toString(), new UserMapper(), userName, password, status);
        return userModels == null ? null : userModels.get(0);
    }

    //    @Override
//    public List<UserModel> findAll() {
//        String sql_select = "SELECT * FROM users";
//        return query(sql_select, new UserMapper());
//    }
//
    @Override
    public long insert(UserModel userModel) {
        String sql_insert = "INSERT into users" +
                "(username, password, full_name, status, role_id, role_code, created_date, modified_date, created_by, modified_by)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        long result = insert(sql_insert, userModel.getUserName(),
                userModel.getPassword(), userModel.getFullName(),
                userModel.getStatus(), userModel.getRoleId(), userModel.getRoleCode(),
                userModel.getCreatedDate(), userModel.getModifiedDate(),
                userModel.getCreatedBy(), userModel.getModifiedBy());
        notification(result);
        return result;
    }

    @Override
    public UserModel findOne(long id) {
        String sql = "SELECT * FROM users AS u INNER JOIN roles as r ON u.role_id = r.id WHERE u.id = ?";

        // find user into Database
        List<UserModel> userModels = query(sql, new UserMapper(), id);
        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public void updateById(UserModel userModel) {
        StringBuilder sql = new StringBuilder("UPDATE users SET password = ?, role_code = ?,");
        sql.append(" modified_date = ?, modified_by = ? WHERE id= ?");
//      String sql_update = "UPDATE news SET title = ?, thumbnail = ?," +
//                " short_description = ?, content = ?, category_id = ?," +
//                " modified_date = ?, modified_by = ? " +
//                "WHERE id= ?";
        update(sql.toString(), userModel.getPassword(), userModel.getRoleCode(), userModel.getModifiedDate(),
                userModel.getModifiedBy(), userModel.getId());
    }
//
//    @Override
//    public void updateById(UserModel userModel) {
//        String sql_update = "UPDATE users " +
//                "SET name=?, password=?, full_name=?, status=?, role_id=?," +
//                " created_date=?, modified_date=?, created_by=?, modified_by=?" +
//                "WHERE id=?";
//        update(sql_update, userModel.getUserName(),
//                userModel.getPassword(), userModel.getFullName(),
//                userModel.getStatus(), userModel.getRoleId(),
//                userModel.getCreatedDate(), userModel.getModifiedDate(),
//                userModel.getCreatedBy(), userModel.getModifiedBy());
//    }
//
//    @Override
//    public void deleteById(UserModel userModel) {
//        String sql_delete = "DELETE FROM users WHERE id = ?;";
//        update(sql_delete, userModel.getId());
//    }

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
//		List<UserModel> userModels = userDAO.findAll();
//		for(UserModel a: userModels){
//			System.out.println(a.getUserName());
//		}
//        UserModel userModel = new UserModel();
//        userModel.setUserName("lequangnhu");
//        userModel.setPassWord("1234");
//        userModel.setStatus(1);// active
//        userModel.setRoleId(5);// admin
//        userDAO.insert(userModel);

	}
}
