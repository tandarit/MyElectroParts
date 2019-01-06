package com.tandari.android.myelectroparts.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.ProductSubClass;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

import java.util.List;

public class ProductSubClassAdapter extends RecyclerView.Adapter<ProductSubClassHolder> {
    private Context mContext ;
    private List<ProductSubClass> mProductSubClassList;
    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;

    public ProductSubClassAdapter(Context context, List<ProductSubClass> productSubClassList, SQLiteDatabaseAdapter sqLiteDatabaseAdapter) {
        this.mContext = context;
        this.mProductSubClassList = productSubClassList;
        this.mSQLiteDatabaseAdapter = sqLiteDatabaseAdapter;
    }

    @NonNull
    @Override
    public ProductSubClassHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_item_productsubclass, viewGroup,false);
        final ProductSubClassHolder myViewHolder = new ProductSubClassHolder(view, mSQLiteDatabaseAdapter);
        myViewHolder.getMainLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ide jön az új activity ami kilistáza a választott dolgot.
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSubClassHolder productSubClassHolder, int i) {
        ProductSubClass productSubClass = mProductSubClassList.get(i);
        productSubClassHolder.bind(productSubClass);
    }

    @Override
    public int getItemCount() {
        return mProductSubClassList.size();
    }

    public void setProductSubClass(List<ProductSubClass> productSubClassList) {
        this.mProductSubClassList = productSubClassList;
    }
}
