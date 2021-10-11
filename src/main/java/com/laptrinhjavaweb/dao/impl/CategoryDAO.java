package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.interf.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public class CategoryDAO extends AbtractDAO<CategoryModel> implements ICategoryDAO {

    //get All items CategoryModel from database
    @Override
    public List<CategoryModel> findAll() {
        String  sql_select = "SELECT * FROM categorys";
        return query(sql_select, new CategoryMapper());
    }

    // insert one item categorymodel into database
    @Override
    public long insert(CategoryModel categoryModel) {
        String sql_insert = "INSERT INTO categorys" +
                "( code, name, created_date, modified_date, created_by, modified_by)" +
                " values(?, ?, ?, ?, ?, ?);";
        long id = insert(sql_insert,
                categoryModel.getCode(), categoryModel.getName(),
                categoryModel.getCreatedDate(), categoryModel.getModifiedDate(),
                categoryModel.getCreatedBy(), categoryModel.getModifiedBy());
        notification(id);
        return id;
    }

    //update one item categorymodel into database
    @Override
    public void updateById(CategoryModel categoryModel) {
        String sql_update = "UPDATE categorys" +
                " SET code = ?, name = ?, created_date = ?, modified_date = ?," +
                " created_by = ?, modified_by = ? " +
                "WHERE id= ?";
        update(sql_update, new CategoryMapper(), categoryModel.getCode(),
                categoryModel.getName(), categoryModel.getCreatedDate(),
                categoryModel.getModifiedDate(), categoryModel.getCreatedBy(),
                categoryModel.getModifiedBy(), categoryModel.getId());
    }

    // Delete one item categoryModel with condition is ID
    @Override
    public void deleteById(CategoryModel categoryModel) {
        String sql_delete = "DELETE FROM categorys WHERE id = ?;";
        update(sql_delete, categoryModel.getId());
    }

    // get categoryModel form ResultSet
    public static void main(String[] args) throws SQLException {
        ICategoryDAO categoryDAO = new CategoryDAO();

//        CategoryModel categoryModel = new CategoryModel();
//        categoryModel.setId(1);
//        categoryDAO.deleteById(categoryModel);

//        List<CategoryModel> categoryModels = categoryDAO.findAll();
//        for (CategoryModel a : categoryModels) {
//            System.out.print(a.getId() + "/");
//            System.out.print(a.getName() + "/");
//            System.out.print(a.getCode() + "/");
//            System.out.print(a.getCreatedDate() + "/");
//            System.out.print(a.getModifiedDate() + "/");
//            System.out.print(a.getCreatedBy() + "/");
//            System.out.print(a.getModifiedBy() + "\n");
//        }

        //insert
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setCode("khoi-nghiep");
		categoryModel.setName("Khởi Nghiệp");
		long id = categoryDAO.insert(categoryModel);
        System.out.println("id = " + id);

        //update
//        CategoryModel categoryModel = new CategoryModel();
//        categoryModel.setCode("Suc-Khoe");
//        categoryModel.setId(8);
//        categoryModel.setName("Sức Khỏe");
//        categoryDAO.dbUpdate(categoryModel);
    }


}
