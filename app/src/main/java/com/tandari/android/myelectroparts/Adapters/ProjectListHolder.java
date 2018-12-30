package com.tandari.android.myelectroparts.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tandari.android.myelectroparts.Models.Category;
import com.tandari.android.myelectroparts.Models.Project;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

public class ProjectListHolder extends RecyclerView.ViewHolder {
    private Project mProject;
    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;
    private TextView mTitleTextView;
    private TextView mProjectCategory;
    private TextView mRating;
    private TextView mDate;
    private LinearLayout view_container;
    private boolean isSelected=false;

    public ProjectListHolder(View itemView, SQLiteDatabaseAdapter sqlAdapter) {
        super(itemView);
        view_container=itemView.findViewById(R.id.container);
        mTitleTextView = (TextView) itemView.findViewById(R.id.project_name);
        mProjectCategory = (TextView) itemView.findViewById(R.id.project_category);
        mRating = (TextView) itemView.findViewById(R.id.rating);
        mDate = (TextView) itemView.findViewById(R.id.project_date);
        mSQLiteDatabaseAdapter = sqlAdapter;
    }

    public void bind(Project project) {
        this.mProject = project;
        List<Category> categoryList;
        StringBuffer categoriesString=new StringBuffer();
        categoriesString.append("| ");

        mTitleTextView.setText(mProject.getProjectTitle());
        //Categories write out
        categoryList=mSQLiteDatabaseAdapter.getProjectCategories(mProject.getDatabaseId());
        for(int i=0; i<categoryList.size(); i++) {
            categoriesString.append(categoryList.get(i).getCategoryName()+" | ");
        }
        mProjectCategory.setText(categoriesString);

        mRating.setText(Integer.toString(mProject.getProjectDifficulty()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mDate.setText(dateFormat.format(mProject.getDate()));
    }

    public LinearLayout getView_container() {
        return view_container;
    }


    public Project getProject() {
        return mProject;
    }

    public void setProject(Project project) {
        mProject = project;
    }

    public TextView getTitleTextView() {
        return mTitleTextView;
    }

    public void setTitleTextView(TextView titleTextView) {
        mTitleTextView = titleTextView;
    }

    public TextView getProjectCategory() {
        return mProjectCategory;
    }

    public void setProjectCategory(TextView projectCategory) {
        mProjectCategory = projectCategory;
    }

    public TextView getRating() {
        return mRating;
    }

    public void setRating(TextView rating) {
        mRating = rating;
    }

    public TextView getDate() {
        return mDate;
    }

    public void setDate(TextView date) {
        mDate = date;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}

