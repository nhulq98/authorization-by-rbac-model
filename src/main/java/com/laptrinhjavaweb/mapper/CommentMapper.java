package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.model.CommentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements IRowMapper<CommentModel> {

    @Override
    public CommentModel mapRow(ResultSet resultSet) {
        try {
            CommentModel commentModel = new CommentModel();

            commentModel.setId(resultSet.getLong("id"));
            commentModel.setContent(resultSet.getString("content"));
            commentModel.setNewId(resultSet.getLong("new_id"));
            commentModel.setUserId(resultSet.getLong("user_id"));

            commentModel.setCreatedDate(resultSet.getTimestamp("created_date"));
            commentModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
            commentModel.setCreatedBy(resultSet.getString("created_by"));
            commentModel.setModifiedBy(resultSet.getString("modified_by"));
            return commentModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
