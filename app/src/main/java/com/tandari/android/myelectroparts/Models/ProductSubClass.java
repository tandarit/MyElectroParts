package com.tandari.android.myelectroparts.Models;

public class ProductSubClass {
    private long mProductSubClassID;
    private String mProductSubClassName;
    private long mProductClassID;

    public ProductSubClass() {

    }

    public ProductSubClass(long productSubClassID) {
        this.mProductSubClassID=productSubClassID;
    }


    public long getProductSubClassID() {
        return mProductSubClassID;
    }

    public void setProductSubClassID(long productSubClassID) {
        mProductSubClassID = productSubClassID;
    }

    public String getProductSubClassName() {
        return mProductSubClassName;
    }

    public void setProductSubClassName(String productSubClassName) {
        mProductSubClassName = productSubClassName;
    }

    public long getProductClassID() {
        return mProductClassID;
    }

    public void setProductClassID(long productClassID) {
        mProductClassID = productClassID;
    }


}
