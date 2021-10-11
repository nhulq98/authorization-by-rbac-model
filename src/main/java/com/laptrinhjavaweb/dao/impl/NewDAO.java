package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.interf.INewDAO;
import com.laptrinhjavaweb.mapper.NewsMapper;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class NewDAO extends AbtractDAO<NewsModel> implements INewDAO {
    private String TBLNEWS = "news";
    private String TBLNEWS_COLUM_ID = "id";
    private String TBLNEWS_COLUM_TITLE = "title";
    private String TBLNEWS_COLUM_THUMBNAIL = "thumbnail";
    private String TBLNEWS_COLUM_SHORT_DESCRIPTION = "short_description";
    private String TBLNEWS_COLUM_CONTENT = "content";
    private String TBLNEWS_COLUM_CATEGORY_ID = "category_id";

    private Connection connection;
    //private List<NewsModel> newsModels;
    private PreparedStatement prStatement;
    private ResultSet resultSet;

    @Override
    public int getTotal() {
        String sql = "SELECT count(*) FROM news";
        return count(sql);
    }

    // get data follow count parameter
    @Override
    public List<NewsModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM news");
        if(pageble.getSorter().getSortName() != null){
            sql.append(" ORDER BY "+ pageble.getSorter().getSortBy() +" " + pageble.getSorter().getSortName() + "");
        }
        if(pageble.getOffset() >= 0 && pageble.getLimit() > 0){
            sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+";");
        }

//        String sql_select = " SELECT * FROM news LIMIT ?, ?";
        return query(sql.toString(), new NewsMapper());
    }

    @Override
    public List<NewsModel> findAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM news");

        return query(sql.toString(), new NewsMapper());
    }

    @Override
    public NewsModel findOne(long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewsModel> newsModels = query(sql, new NewsMapper(), id);
        return newsModels.isEmpty() ? null : newsModels.get(0);
    }

    @Override
    public Long insert(NewsModel newsModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO news");
        sql.append("(title, thumbnail, short_description,");
        sql.append(" content, category_id, created_date,");
        sql.append(" created_by) VALUES(?, ?, ?, ?, ?, ?, ?)");
//        String sql_insert = "INSERT INTO news" +
//                "(title, thumbnail, short_description," +
//                " content, category_id, created_date," +
//                " created_by) VALUES(?, ?, ?, ?, ?, ?, ?)";
        long result = insert(sql.toString(), newsModel.getTitle(),
                newsModel.getThumbnail(), newsModel.getShortDescription(),
                newsModel.getContent(), newsModel.getCategoryId(),
                newsModel.getCreatedDate(), newsModel.getCreatedBy());
        notification(result);
        return result;
    }

    @Override
    public void updateById(NewsModel newsModel) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
        sql.append(" short_description = ?, content = ?, category_id = ?,");
        sql.append(" modified_date = ?, modified_by = ? WHERE id= ?");
//        String sql_update = "UPDATE news SET title = ?, thumbnail = ?," +
//                " short_description = ?, content = ?, category_id = ?," +
//                " modified_date = ?, modified_by = ? " +
//                "WHERE id= ?";
        update(sql.toString(), newsModel.getTitle(), newsModel.getThumbnail(), newsModel.getShortDescription(),
                newsModel.getContent(), newsModel.getCategoryId(), newsModel.getModifiedDate(),
                newsModel.getModifiedBy(), newsModel.getId());
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM news WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<NewsModel> findbyCategoryId(long category_id) {
        String sql_select = "SELECT * FROM news WHERE category_id = ?";
        return query(sql_select, new NewsMapper(), category_id);
    }

    public static void main(String[] args) {
        NewDAO newDAO = new NewDAO();
//        List<NewsModel> list = newDAO.findAll();
//        for(NewsModel newsModel:list){
//            System.out.println(newsModel.getTitle());
//        }
        NewsModel newsModel = new NewsModel();
        newsModel.setTitle("Bài viết 4");
        newsModel.setTitle("Bài viết 4");
        newsModel.setContent("Bài viết 4");
        newsModel.setCategoryId(1);
        newDAO.insert(newsModel);
    }
}
