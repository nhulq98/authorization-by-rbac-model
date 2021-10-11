package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public class PageRequest implements Pageble {
    private int page;
    private int maxPageItem;
    private Sorter sorter;

    public PageRequest(int page, int maxPageItem, Sorter sorter){
        this.page = page;
        this.maxPageItem = maxPageItem;

//        this.sorter.setSortName(sorter.getSortName());
////        this.sorter.setSortBy(sorter.getSortBy());
        this.sorter = sorter;
    }

    public Sorter getSorter() {
        return sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public int getMaxPageItem() {
        return maxPageItem;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getOffset() {
        return (page - 1) * maxPageItem;
    }

    @Override
    public int getLimit() {
        return 0;
    }
}
