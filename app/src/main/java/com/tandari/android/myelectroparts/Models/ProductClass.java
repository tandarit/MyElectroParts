package com.tandari.android.myelectroparts.Models;

import java.util.ArrayList;
import java.util.List;

public class ProductClass {
    private String mTitle;
    private long mDatabaseId;
    private List<ProductSubClass> mProductSubClassList;

    public ProductClass() {

    }

    public ProductClass(String title, ArrayList<ProductSubClass> productSubClasses) {
        this.mTitle = title;
        this.mProductSubClassList = productSubClasses;
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


    public List<ProductSubClass> getmProductSubClassList() {
        return mProductSubClassList;
    }

    public void setmProductSubClassList(List<ProductSubClass> mProductSubClassList) {
        this.mProductSubClassList = mProductSubClassList;
    }
}
