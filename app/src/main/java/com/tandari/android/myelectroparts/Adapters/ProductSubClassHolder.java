package com.tandari.android.myelectroparts.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.ProductSubClass;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

import java.util.List;

public class ProductSubClassHolder extends RecyclerView.ViewHolder {
    private TextView mProductSubClassTextView;
    private ImageView mProductSubClassImageView;
    private ProductSubClass mProductSubClass;


    //Maybenot gonna be suitable for this application because of theconstructor's parameter have not been changed!!!
    public ProductSubClassHolder(@NonNull View itemView) {
        super(itemView);
        mProductSubClassTextView = (TextView) itemView.findViewById(R.id.product_sub_class_textview);
        mProductSubClassImageView = (ImageView) itemView.findViewById(R.id.product_sub_class_imageview);

    }

    public void bind(ProductSubClass productSubClass) {
        this.mProductSubClass=productSubClass;
        this.mProductSubClassTextView.setText(mProductSubClass.getProductSubClassName());
    }

    public TextView getProductSubClassTextView() {
        return mProductSubClassTextView;
    }

    public void setProductSubClassTextView(TextView productSubClassTextView) {
        mProductSubClassTextView = productSubClassTextView;
    }

    public ProductSubClass getProductSubClass() {
        return mProductSubClass;
    }

    public void setProductSubClass(ProductSubClass productSubClass) {
        mProductSubClass = productSubClass;
    }

    public ImageView getmProductSubClassImageView() {
        return mProductSubClassImageView;
    }

    public void setmProductSubClassImageView(ImageView mProductSubClassImageView) {
        this.mProductSubClassImageView = mProductSubClassImageView;
    }

}
