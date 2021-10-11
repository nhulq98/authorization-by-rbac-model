package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.interf.ICommentDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CommentModel;

import java.util.List;

public class CommentDAO extends AbtractDAO implements ICommentDAO {

    @Override
    public List<CommentModel> findAll() {
        String sql_select = "SELECT * FROM comments";
        return query(sql_select, new CategoryMapper());
    }

    @Override
    public void insert(CommentModel commentModel) {

    }

    @Override
    public void updateById(CommentModel commentModel) {

    }

    @Override
    public void deleteById(CommentModel commentModel) {

    }
}
