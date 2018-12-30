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
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PRODUCT_CLASS;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTCATEGORY;
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
        db.execSQL(DATABASE_CREATE_PROJECTCATEGORY);
        db.execSQL(DATABASE_CREATE_PRODUCT_CLASS);

        //Category fill
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Radio');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('MCU and FPGA');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Audio');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Power source');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Model control');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Auto electronic');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Measuring technology');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Robot');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Telephone');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.CategoryTable.NAME +"("+MyElectroPartsDbSchema.CategoryTable.Cols.NAME +") VALUES('Power electronic');");

        //ProductClass fill
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Passive Components');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Discrate Components');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Integrate Semiconductor');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Coolers');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Cabels');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('PCBs');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Mechanical Parts');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Batteries');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Chemicals');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Sensors');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Fuses');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Switch and Buttons');");
        db.execSQL("INSERT INTO "+MyElectroPartsDbSchema.ProductClassTable.NAME+"("+MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME +") VALUES('Tools');");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PROJECTS);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTS);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_CATEGORIES);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_CATEGORIES);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PROJECTCATEGORY);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTCATEGORY);

        db.execSQL(MyElectroPartsDbSchema.DATABASE_DROP_PROJECTCATEGORY);
        db.execSQL(MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTCATEGORY);
    }


}

