package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.dao.impl.AbtractDAO;
import com.laptrinhjavaweb.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper extends AbtractDAO implements IRowMapper<NewsModel> {

    @Override
    public NewsModel mapRow(ResultSet resultSet) {
        try {
            NewsModel newsModel = new NewsModel();

            newsModel.setId(resultSet.getLong("id"));
            newsModel.setTitle(resultSet.getString("title"));
            newsModel.setThumbnail(resultSet.getString("thumbnail"));
            newsModel.setShortDescription(resultSet.getString("short_description"));
            newsModel.setContent(resultSet.getString("content"));
            newsModel.setCategoryId(resultSet.getLong("category_id"));

            newsModel.setCreatedDate(resultSet.getTimestamp("created_date"));
            newsModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
            newsModel.setCreatedBy(resultSet.getString("created_by"));
            newsModel.setModifiedBy(resultSet.getString("modified_by"));

            return newsModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
