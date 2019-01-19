package com.tandari.android.myelectroparts.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.ProductSubClass;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

import java.util.List;

public class ProductSubClassAdapter extends RecyclerView.Adapter<ProductSubClassHolder> {
    private Context mContext ;
    private List<ProductSubClass> mProductSubClassList;

    public ProductSubClassAdapter(Context context, List<ProductSubClass> productSubClassList) {
        this.mContext = context;
        this.mProductSubClassList = productSubClassList;
    }

    @NonNull
    @Override
    public ProductSubClassHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        view = mInflater.inflate(R.layout.list_item_productsubclass, null);
        ProductSubClassHolder myViewHolder = new ProductSubClassHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSubClassHolder productSubClassHolder, int i) {
        ProductSubClass productSubClass = mProductSubClassList.get(i);
        productSubClassHolder.getProductSubClassTextView().setText(productSubClass.getProductSubClassName());
    }

    @Override
    public int getItemCount() {
        return mProductSubClassList.size();
    }

    public void setProductSubClass(List<ProductSubClass> productSubClassList) {
        this.mProductSubClassList = productSubClassList;
    }
}
