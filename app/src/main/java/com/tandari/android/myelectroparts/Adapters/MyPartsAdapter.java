package com.tandari.android.myelectroparts.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.Project;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyPartsAdapter extends RecyclerView.Adapter<MyPartsHolder> {
    private Context mContext ;
    private List<ProductClass> mProductClassList;
    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;

    public MyPartsAdapter(Context context, List<ProductClass> productClassList, SQLiteDatabaseAdapter sqLiteDatabaseAdapter) {
        this.mContext = context;
        this.mProductClassList = productClassList;
        this.mSQLiteDatabaseAdapter = sqLiteDatabaseAdapter;
    }


    @Override
    public MyPartsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_item_productclass, viewGroup,false);
        final MyPartsHolder myViewHolder = new MyPartsHolder(view, mSQLiteDatabaseAdapter);
        myViewHolder.getMainLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add new recyclerview
                myViewHolder.getSubClassRecyclerView().setVisibility(View.VISIBLE);

            }
        });
        myViewHolder.getMainLinearLayout().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return false;
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyPartsHolder myPartsHolder, int i) {
        ProductClass productClass = mProductClassList.get(i);
        myPartsHolder.bind(productClass);
    }

    @Override
    public int getItemCount() {
        return mProductClassList.size();
    }

    public void setProductClass(List<ProductClass> productClassList) {
        this.mProductClassList = productClassList;
    }
}
