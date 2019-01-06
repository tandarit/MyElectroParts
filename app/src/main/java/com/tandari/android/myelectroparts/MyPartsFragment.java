package com.tandari.android.myelectroparts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tandari.android.myelectroparts.Adapters.MyPartsAdapter;
import com.tandari.android.myelectroparts.Adapters.ProjectListAdapter;
import com.tandari.android.myelectroparts.Models.ProductClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint("ValidFragment")
public class MyPartsFragment extends Fragment {
    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;
    private List<ProductClass> mProductClassList;
    private MyPartsAdapter mMyPartsAdapter;
    private RecyclerView mProductClassRecyclerView;
    private RecyclerView mProductSubClassRecyclerView;

    public MyPartsFragment(SQLiteDatabaseAdapter adapter) {
        mSQLiteDatabaseAdapter=adapter;
        mProductClassList=new ArrayList<>();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myPartsView = inflater.inflate(R.layout.fragment_my_parts, container, false);

        mProductClassRecyclerView = (RecyclerView)myPartsView.findViewById(R.id.product_class_recyclerview);
        mProductClassRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mProductSubClassRecyclerView = (RecyclerView)myPartsView.findViewById(R.id.sub_class_recyclerView);
        mProductSubClassRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        updateUI();

        return myPartsView;
    }

    private void updateUI() {
        this.mProductClassList=mSQLiteDatabaseAdapter.getAllProductClass();

        mMyPartsAdapter = new MyPartsAdapter(getContext(), mProductClassList, mSQLiteDatabaseAdapter);
        mProductClassRecyclerView.setAdapter(mMyPartsAdapter);


        if (mMyPartsAdapter == null) {
            mMyPartsAdapter = new MyPartsAdapter(getContext(), mProductClassList, mSQLiteDatabaseAdapter);
            mProductClassRecyclerView.setAdapter(mMyPartsAdapter);
        } else {
            mMyPartsAdapter.setProductClass(mProductClassList);
            mMyPartsAdapter.notifyDataSetChanged();
        }


    }
}
