package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.interf.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.interf.ICategoryService;

import javax.inject.Inject;
import java.util.List;


public class CategoryService implements ICategoryService {
    //way 1
//    private ICategoryDAO categoryDAO;
//
//    public CategoryService() {
//        categoryDAO = new CategoryDAO();
//    }

    // way 2
    @Inject
    private ICategoryDAO categoryDAO;


    @Override
    public void insert(CategoryModel categoryModel) {

    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
