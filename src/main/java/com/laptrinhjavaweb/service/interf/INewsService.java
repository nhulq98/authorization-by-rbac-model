package com.laptrinhjavaweb.service.interf;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

import java.util.List;

public interface INewsService {

    List<NewsModel> findAll(Pageble pageble);

    List<NewsModel> findAll();

    List<NewsModel> findByCategoryId(long categoryId);

    //các hàm bên dưới phải trả về 1 cái gì đó chứng minh là mình đã thao tác thành công với database
    // Ví dụ: mỗi khi dữ liệu đc thêm vào thì nó sẽ sinh ra 1 id ngẫu nhiên nếu ta set nó là AI(auto Increment)
    // Vậy thì ID sẽ bằng chứng ==> nên trả về data có chứa ID, điều này sẽ chứng minh việc thao tác thành công với DB

    // return detail newly added data. important is id
    NewsModel save(NewsModel newsModel);
    // return detail newly update data. important is modified by and modified date
    NewsModel updateById(NewsModel newsModel);

    // return detail newly delete data. important is modified by and modified date
    void deleteById(NewsModel newsModel);

    int getTotalItems();
}
