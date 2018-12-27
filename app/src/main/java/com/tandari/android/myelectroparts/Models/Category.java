package com.tandari.android.myelectroparts.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Category implements Serializable {
    private long mId;
    private String mCategoryName;

    public Category() {

    }

    public Category(long id) {
        this.mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    @Override
    public String toString() {
        return getCategoryName();
    }


}
