package com.laptrinhjavaweb.dao.interf;

import com.laptrinhjavaweb.model.RoleModel;

import java.util.List;

public interface IRoleDAO{

    List<RoleModel> findAll();

    void insert(RoleModel roleModel);

    void updateById(RoleModel roleModel);

    void deleteById(RoleModel roleModel);

}
