package com.tandari.android.myelectroparts.Adapters;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.Project;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

public class MyPartsHolder extends RecyclerView.ViewHolder {
    private ProductClass mProductClass;
    private CardView mCardView;
    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;
    private TextView mProductClassTextView;
    private RecyclerView mSubClassRecyclerView;
    private LinearLayout mMainLinearLayout;

    public LinearLayout getMainLinearLayout() {
        return mMainLinearLayout;
    }

    public void setMainLinearLayout(LinearLayout mainLinearLayout) {
        mMainLinearLayout = mainLinearLayout;
    }

    public MyPartsHolder(View itemView, SQLiteDatabaseAdapter sqlAdapter) {
        super(itemView);
        mMainLinearLayout = itemView.findViewById(R.id.product_class_container);
        mProductClassTextView = (TextView)itemView.findViewById(R.id.product_class_textview);
        mSubClassRecyclerView = (RecyclerView) itemView.findViewById(R.id.sub_class_recyclerView);
        mSQLiteDatabaseAdapter = sqlAdapter;
    }


    public void bind(ProductClass productClass) {
       this.mProductClass = productClass;
       mProductClassTextView.setText(mProductClass.getTitle());
       //Drawable draw=Drawable.createFromPath("C:\\Users\\Tandari\\AndroidStudioProjects\\MyElectroParts\\app\\src\\main\\res\\drawable\\Images\\"+mProductClass.getTitle()+".jpg");
       //mProductClassImageView.setImageDrawable(draw);
    }

    public TextView getProductClassTextView() {
        return mProductClassTextView;
    }

    public void setProductClassTextView(TextView productClassTextView) {
        mProductClassTextView = productClassTextView;
    }

    public RecyclerView getSubClassRecyclerView() {
        return mSubClassRecyclerView;
    }

    public void setSubClassRecyclerView(RecyclerView subClassRecyclerView) {
        mSubClassRecyclerView = subClassRecyclerView;
    }

    public CardView getCardView() {
        return mCardView;
    }

    public void setCardView(CardView cardView) {
        mCardView = cardView;
    }


}
