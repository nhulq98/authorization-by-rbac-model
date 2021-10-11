package com.laptrinhjavaweb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {

    private long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private long[] ids;
    private int page;
    private int maxPageItem;
    private int totalPages;
    private int totalItems;
    private String sortName;
    private String sortBy;
    private List<T> models = new ArrayList<>();
    private String type;

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPageItem() {
        return maxPageItem;
    }

    public void setMaxPageItem(int maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getModels() {
        return models;
    }

    public void setModels(List<T> models) {
        this.models = models;
    }

    public long[] getIds() {
        return ids;
    }

    public void setIds(long[] ids) {
        this.ids = ids;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
