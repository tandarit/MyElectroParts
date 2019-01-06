package com.tandari.android.myelectroparts.Models;

public class ProductClass {
    private String mTitle;
    private long mDatabaseId;

    public ProductClass() {

    }

    public ProductClass(long id) {
        this.mDatabaseId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public long getDatabaseId() {
        return mDatabaseId;
    }

    public void setDatabaseId(long databaseId) {
        mDatabaseId = databaseId;
    }
}
