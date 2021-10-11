package com.laptrinhjavaweb.dao.interf;

import com.laptrinhjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO{

    List<CategoryModel> findAll();

    long insert(CategoryModel categoryModel);

    void updateById(CategoryModel categoryModel);

    void deleteById(CategoryModel categoryModel);


}
