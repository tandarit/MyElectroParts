package com.tandari.android.myelectroparts.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.ProjectTable;
import com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.CategoryTable;
import com.tandari.android.myelectroparts.Models.Category;

import java.util.ArrayList;
import java.util.List;

import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_CATEGORIES;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTS;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_NAME;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.VERSION;

public class MyElectroPartBaseHelper extends SQLiteOpenHelper {

    public MyElectroPartBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_PROJECTS);
        db.execSQL(DATABASE_CREATE_CATEGORIES);

        //db.execSQL("INSERT INTO Categories(uuid, name) VALUES('ewqer32e3er', 'test1');");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PROJECTS);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTS);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_CATEGORIES);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_CATEGORIES);



    }


}

