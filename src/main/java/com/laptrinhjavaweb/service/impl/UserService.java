package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.interf.IUserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.interf.IUserService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class UserService implements IUserService {


    @Inject
    private IUserDAO userDAO;
//
//    @Override



    @Override
    public List<UserModel> findAll(Pageble pageble) {
        return userDAO.findAll(pageble);
    }

    @Override
    public List<UserModel> findAll() {
        return userDAO.findAll();
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }

    @Override
    public UserModel save(UserModel userModel) {
        userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userModel.setCreatedBy("");
        long id = userDAO.insert(userModel);
        return userDAO.findOne(id);
    }

    @Override
    public UserModel findUserByID(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public UserModel updateById(UserModel userModel) {
        // get Old value
        UserModel oldUser = userDAO.findOne(userModel.getId());

        // set old value into new Value
        userModel.setCreatedDate(oldUser.getCreatedDate());
        userModel.setCreatedBy(oldUser.getCreatedBy());

        //update time modified and edit user
        userModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        userModel.setModifiedBy(userModel.getModifiedBy());

        userDAO.updateById(userModel);
        return userDAO.findOne(userModel.getId());
    }

    @Override
    public UserModel add(UserModel userModel) {
        userDAO.insert(userModel);
        return userDAO.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);

    }

    //    public boolean authorization(UserModel userModel) {
//
//        return false;
//    }
//
//    @Override
//    public UserModel authenticationUser(UserModel userModel) {
//        List<UserModel> userModels = userDAO.findAll();
//        UserModel userModelNeedReturn = new UserModel();
//        for (UserModel userModelI : userModels) {
//            if (userModel.getUserName().equals(userModelI.getUserName()) &&
//                    userModel.getPassword().equals(userModelI.getPassword())) {
//                return userModelI;
//            }
//        }
//        return userModelNeedReturn;
//    }
}
