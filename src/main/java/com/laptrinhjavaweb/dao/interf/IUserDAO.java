package com.laptrinhjavaweb.dao.interf;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

import java.util.List;

public interface IUserDAO extends GenericDAO<UserModel> {

    List<UserModel> findAll(Pageble pageble);

    List<UserModel> findAll();


    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status);
//    List<UserModel> findAll();
//
    long insert(UserModel userModel);

    UserModel findOne(long id);

    void updateById(UserModel userModel);

//
//    void updateById(UserModel userModel);
//
//    void deleteById(UserModel userModel);
}
