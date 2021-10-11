package com.laptrinhjavaweb.dao.interf;

import com.laptrinhjavaweb.model.CommentModel;

import java.util.List;

public interface ICommentDAO extends GenericDAO {

    List<CommentModel> findAll();

    void insert(CommentModel commentModel);

    void updateById(CommentModel commentModel);

    void deleteById(CommentModel commentModel);
}
