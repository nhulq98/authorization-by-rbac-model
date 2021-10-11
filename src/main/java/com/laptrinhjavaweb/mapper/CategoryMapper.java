package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.dao.impl.AbtractDAO;
import com.laptrinhjavaweb.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper extends AbtractDAO implements IRowMapper<CategoryModel> {
    private String TBLCATEGORYS = "categorys";
    private String TBLCATEGORYS_COLUM_ID = "id";
    private String TBLCATEGORYS_COLUM_NAME = "name";
    private String TBLCATEGORYS_COLUM_CODE = "code";


    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        CategoryModel categoryModel = new CategoryModel();
        try {
            categoryModel.setId(resultSet.getLong("id"));
            categoryModel.setName(resultSet.getString("name"));
            categoryModel.setCode(resultSet.getString("code"));

            categoryModel.setCreatedDate(resultSet.getTimestamp("created_date"));
            categoryModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
            categoryModel.setCreatedBy(resultSet.getString("created_by"));
            categoryModel.setModifiedBy(resultSet.getString("modified_by"));
        } catch (SQLException e) {
            return null;
        }
        return categoryModel;
    }
}
