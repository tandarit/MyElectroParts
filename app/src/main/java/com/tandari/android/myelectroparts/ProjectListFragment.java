package com.tandari.android.myelectroparts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tandari.android.myelectroparts.Adapters.ProjectListAdapter;
import com.tandari.android.myelectroparts.Models.Category;
import com.tandari.android.myelectroparts.Models.Project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.app.Activity.RESULT_OK;


@SuppressLint("ValidFragment")
public class ProjectListFragment extends Fragment {
    public static final int NEW_PROJECT_ACTIVITY = 1;
    public static final String NEW_PROJECT_ACTIVITY_CATEGORIES="category_table";

    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;
    private RecyclerView mProjectRecyclerView;
    private ProjectListAdapter mProjectListAdapter;
    private List<Project> mProjectList;
    private Set<Project> mSelectedProjectList;
    //refresh
    private SwipeRefreshLayout mSwipeRefreshLayout;


    public ProjectListFragment(SQLiteDatabaseAdapter adapter) {
        mSQLiteDatabaseAdapter=adapter;
        mProjectList=new ArrayList<>();
        mSelectedProjectList=new HashSet<>();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bundle resultBundle = data.getExtras();

            Project newProject =(Project)resultBundle.getSerializable(NewProjectActivity.NEW_PROJECT_TAG);
            long projectId=this.mSQLiteDatabaseAdapter.addProject(newProject);

            List<Category> selectedCategoriesList = (List<Category>)resultBundle.getSerializable(NewProjectActivity.NEW_CATEGORIES_TAG);
            this.mSQLiteDatabaseAdapter.addProjectCategory(projectId, selectedCategoriesList);
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_project_list_menu, menu);

        MenuItem subtitleItem = menu.findItem(R.id.new_project);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_project:
                List<Category> categories=this.mSQLiteDatabaseAdapter.getAllCategories();

                Bundle bundle=new Bundle();
                bundle.putSerializable(NEW_PROJECT_ACTIVITY_CATEGORIES, (Serializable) categories);

                Intent newProjectIntent = new Intent(getContext(), NewProjectActivity.class);
                newProjectIntent.putExtras(bundle);
                startActivityForResult(newProjectIntent, NEW_PROJECT_ACTIVITY);
                return true;

            case R.id.delete_project:
                if(!mSelectedProjectList.isEmpty()) {
                    mSQLiteDatabaseAdapter.removeProjects(mSelectedProjectList);
                    mSelectedProjectList.clear();
                    updateUI();
                }else {
                    Toast.makeText(getContext(), "Please select at least one item!", Toast.LENGTH_LONG).show();
                }

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View projectView = inflater.inflate(R.layout.fragment_project_list, container, false);
        mProjectRecyclerView=(RecyclerView)projectView.findViewById(R.id.project_list);
        mProjectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mSwipeRefreshLayout = (SwipeRefreshLayout) projectView.findViewById(R.id.swipeToRefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        //Frissités lekezelése
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                updateUI();

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        updateUI();

        return projectView;
    }

    private void updateUI() {
        this.mProjectList=mSQLiteDatabaseAdapter.getAllProjects();

        if (mProjectListAdapter == null) {
            mProjectListAdapter = new ProjectListAdapter(getContext(), mProjectList, mSelectedProjectList, mSQLiteDatabaseAdapter);
            mProjectRecyclerView.setAdapter(mProjectListAdapter);
        } else {
            mProjectListAdapter.setProjects(mProjectList);
            mProjectListAdapter.notifyDataSetChanged();
        }
    }
/*
    private class ProjectListHolder extends RecyclerView.ViewHolder {
        private Project mProject;

        private TextView mTitleTextView;
        private TextView mProjectCategory;
        private TextView mRating;
        private TextView mDate;
        private LinearLayout view_container;

        private boolean isSelected=false;

        public ProjectListHolder(View itemView) {
            super(itemView);
            view_container=itemView.findViewById(R.id.container);
            mTitleTextView = (TextView) itemView.findViewById(R.id.project_name);
            mProjectCategory = (TextView) itemView.findViewById(R.id.project_category);
            mRating = (TextView) itemView.findViewById(R.id.rating);
            mDate = (TextView) itemView.findViewById(R.id.project_date);
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


    }

    private class ProjectListAdapter extends RecyclerView.Adapter<ProjectListHolder> {
        private Context mContext ;
        private List<Project> mProjectList;

        public ProjectListAdapter(Context context, List<Project> projectList) {
            this.mContext = context;
            this.mProjectList = projectList;
        }

        @Override
        public ProjectListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            final View view ;
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            view = mInflater.inflate(R.layout.list_item_projectlist, parent,false);
            final ProjectListHolder myViewHolder = new ProjectListHolder(view);

            myViewHolder.view_container.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {
                    if(!myViewHolder.isSelected) {
                        myViewHolder.isSelected=true;
                        myViewHolder.view_container.setBackgroundColor(Color.rgb(111, 189, 245));
                        mSelectedProjectList.add(myViewHolder.mProject);
                    }
                    else {
                        myViewHolder.isSelected=false;
                        myViewHolder.view_container.setBackgroundColor(Color.rgb(255, 255, 255));
                        mSelectedProjectList.remove(myViewHolder.mProject);
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

*/
}
