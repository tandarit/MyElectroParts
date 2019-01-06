package com.tandari.android.myelectroparts.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tandari.android.myelectroparts.Models.Project;
import com.tandari.android.myelectroparts.ProjectListFragment;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

import java.util.List;
import java.util.Set;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListHolder> {
    private Context mContext ;
    private List<Project> mProjectList;
    private Set<Project> mSelectedProjectList;
    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;

    public ProjectListAdapter(Context context, List<Project> projectList, Set<Project> selectedProjectList, SQLiteDatabaseAdapter sqLiteDatabaseAdapter) {
        this.mContext = context;
        this.mProjectList = projectList;
        this.mSelectedProjectList = selectedProjectList;
        this.mSQLiteDatabaseAdapter = sqLiteDatabaseAdapter;
    }

    @Override
    public ProjectListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_item_projectlist, parent,false);
        final ProjectListHolder myViewHolder = new ProjectListHolder(view, mSQLiteDatabaseAdapter);

        myViewHolder.getView_container().setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                if(!myViewHolder.isSelected()) {
                    myViewHolder.setSelected(true);
                    myViewHolder.getView_container().setBackgroundColor(Color.rgb(111, 189, 245));
                    mSelectedProjectList.add(myViewHolder.getProject());
                }
                else {
                    myViewHolder.setSelected(false);
                    myViewHolder.getView_container().setBackgroundColor(Color.rgb(255, 255, 255));
                    mSelectedProjectList.remove(myViewHolder.getProject());
                }
                return false;
            }
        });
        // click listener here
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ProjectListHolder holder, final int position) {
        Project project = mProjectList.get(position);
        holder.bind(project);

        // load image from the internet using Glide
        //Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.AnimeThumbnail);

    }

    @Override
    public int getItemCount() {
        return mProjectList.size();
    }

    //Ez a frissítések miatt kell!
    public void setProjects(List<Project> projects) {
        mProjectList = projects;
    }


}

