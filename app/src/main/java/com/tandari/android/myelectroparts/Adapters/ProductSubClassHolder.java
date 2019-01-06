package com.tandari.android.myelectroparts.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.ProductSubClass;
import com.tandari.android.myelectroparts.R;
import com.tandari.android.myelectroparts.SQLiteDatabaseAdapter;

public class ProductSubClassHolder extends RecyclerView.ViewHolder {
    private TextView mProductSubClassTextView;
    private ProductSubClass mProductSubClass;
    private CardView mCardView;
    private SQLiteDatabaseAdapter mSQLiteDatabaseAdapter;
    private LinearLayout mMainLinearLayout;

    public LinearLayout getMainLinearLayout() {
        return mMainLinearLayout;
    }

    public ProductSubClassHolder(@NonNull View itemView, SQLiteDatabaseAdapter sqlAdapter) {
        super(itemView);
        mProductSubClassTextView = (TextView) itemView.findViewById(R.id.product_sub_class_textview);
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

    public ProductSubClass getProductClass() {
        return mProductSubClass;
    }

    public void setProductSubClass(ProductSubClass productSubClass) {
        mProductSubClass = productSubClass;
    }

    public CardView getCardView() {
        return mCardView;
    }

    public void setCardView(CardView cardView) {
        mCardView = cardView;
    }

    public SQLiteDatabaseAdapter getSQLiteDatabaseAdapter() {
        return mSQLiteDatabaseAdapter;
    }

    public void setSQLiteDatabaseAdapter(SQLiteDatabaseAdapter SQLiteDatabaseAdapter) {
        mSQLiteDatabaseAdapter = SQLiteDatabaseAdapter;
    }
}
