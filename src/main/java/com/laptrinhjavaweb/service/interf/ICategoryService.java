package com.laptrinhjavaweb.service.interf;


import com.laptrinhjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();

    void insert(CategoryModel categoryModel);
}
