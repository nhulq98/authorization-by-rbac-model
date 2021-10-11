package com.laptrinhjavaweb.dao.interf;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

import java.util.List;

public interface INewDAO{
    List<NewsModel> findAll(Pageble pageble);

    List<NewsModel> findAll();

    Long insert(NewsModel newsModel);

    void updateById(NewsModel newsModel);

    void deleteById(long id);

    //get All NewDAO items codition category_id
    List<NewsModel> findbyCategoryId(long category_id);

    NewsModel findOne(long id);

    int getTotal();

}
