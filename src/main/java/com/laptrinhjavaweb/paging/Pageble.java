package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public interface Pageble {
    int getPage();

    int getOffset();

    int getLimit();

    Sorter getSorter();

}
