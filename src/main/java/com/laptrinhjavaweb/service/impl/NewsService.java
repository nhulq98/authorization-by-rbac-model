package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.interf.INewDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.interf.INewsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService {

    @Inject
    private INewDAO newDAO;

    @Override
    public List<NewsModel> findAll(Pageble pageble) {
        return newDAO.findAll(pageble);
    }

    @Override
    public List<NewsModel> findAll() {
        return newDAO.findAll();
    }

    @Override
    public List<NewsModel> findByCategoryId(long categoryId) {
        return newDAO.findbyCategoryId(categoryId);
    }

    @Override
    public int getTotalItems() {
        return newDAO.getTotal();
    }

    @Override
    public NewsModel updateById(NewsModel newsModel) {
        // get Old value
        NewsModel oldNews = newDAO.findOne(newsModel.getId());
        // set old value into new Value
        newsModel.setCreatedDate(oldNews.getCreatedDate());
        newsModel.setCreatedBy(oldNews.getCreatedBy());
        //update time modified and edit user
        newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setModifiedBy("");

        newDAO.updateById(newsModel);
        return newDAO.findOne(newsModel.getId());
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setCreatedBy("");
        long id = newDAO.insert(newsModel);
        return newDAO.findOne(id);
    }

    @Override
    public void deleteById(NewsModel newsModel) {
        for (long id:newsModel.getIds()){
            // 1. Delete Comment (foreign key new_id) || if do not delete will error
            // 2. Delete New
            newDAO.deleteById(id);
        }

    }
}
