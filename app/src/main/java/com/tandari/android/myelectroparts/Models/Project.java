package com.tandari.android.myelectroparts.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Project implements Serializable {
    private UUID mId;
    private long mDatabaseId;
    private String mProjectTitle;
    private Date mDate;
    private int mProjectDifficulty;

    public Project() {
        this.mId=UUID.randomUUID();
    }

    public Project(UUID id) {
        this.mId = id;
        this.mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getProjectTitle() {
        return mProjectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        mProjectTitle = projectTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public int getProjectDifficulty() {
        return mProjectDifficulty;
    }

    public void setProjectDifficulty(int projectDifficulty) {
        mProjectDifficulty = projectDifficulty;
    }

    public long getDatabaseId() {
        return mDatabaseId;
    }

    public void setDatabaseId(long databaseId) {
        mDatabaseId = databaseId;
    }

}
