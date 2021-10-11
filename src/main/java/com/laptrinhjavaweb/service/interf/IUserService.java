package com.laptrinhjavaweb.service.interf;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

import java.util.List;

public interface IUserService {

    List<UserModel> findAll(Pageble pageble);

    List<UserModel> findAll();

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status);

    // return detail newly added data. important is id
    UserModel save(UserModel userModel);

    UserModel findUserByID(long id);

    UserModel updateById(UserModel userModel);

//    UserModel authenticationUser(UserModel userModel);
//    boolean authorization(UserModel userModel);

    UserModel add(UserModel userModel);
}
