package com.tandari.android.myelectroparts.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.ProductSubClass;
import com.tandari.android.myelectroparts.Models.Project;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyPartsAdapter extends RecyclerView.Adapter<MyPartsHolder> {
    private Context mContext ;
    private List<ProductClass> mProductClassList;
    //private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;

    public MyPartsAdapter(Context context, List<ProductClass> productClassList) {
        this.mContext = context;
        this.mProductClassList = productClassList;
        //this.mSQLiteDatabaseAdapter = sqLiteDatabaseAdapter;
    }


    @Override
    public MyPartsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.list_item_productclass, viewGroup,false);
        MyPartsHolder myViewHolder = new MyPartsHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyPartsHolder myPartsHolder, int i) {
        ProductClass productClass = mProductClassList.get(i);
        myPartsHolder.getProductClassTextView().setText(productClass.getTitle());


        List<ProductSubClass> mProductSubClassList = productClass.getmProductSubClassList();
        ProductSubClassAdapter productSubClassAdapter=new ProductSubClassAdapter(mContext, mProductSubClassList);

        myPartsHolder.getSubClassRecyclerView().setHasFixedSize(true);
        myPartsHolder.getSubClassRecyclerView().setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        myPartsHolder.getSubClassRecyclerView().setAdapter(productSubClassAdapter);
        myPartsHolder.getSubClassRecyclerView().setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return mProductClassList.size();
    }

    public void setProductClass(List<ProductClass> productClassList) {
        this.mProductClassList = productClassList;
    }
}
