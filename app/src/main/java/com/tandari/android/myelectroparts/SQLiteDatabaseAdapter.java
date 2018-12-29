package com.tandari.android.myelectroparts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.tandari.android.myelectroparts.Database.MyElectroPartBaseHelper;
import com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema;
import com.tandari.android.myelectroparts.Models.Category;
import com.tandari.android.myelectroparts.Models.Project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_CATEGORIES;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PRODUCT_CLASS;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTCATEGORY;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_CREATE_PROJECTS;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.DATABASE_NAME;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.ProjectTable.Cols.DIFFICULTY;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.ProjectTable.Cols.TITLE;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.ProjectTable.Cols.UUID;
import static com.tandari.android.myelectroparts.Database.MyElectroPartsDbSchema.VERSION;

public class SQLiteDatabaseAdapter extends SQLiteOpenHelper {
    private Context mContext;

    public SQLiteDatabaseAdapter(Context context) {
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

    public List<Project> getAllProjects() {
        SQLiteDatabase db=getWritableDatabase();

        String selectString="SELECT * FROM "+MyElectroPartsDbSchema.ProjectTable.NAME
                +", "+MyElectroPartsDbSchema.CategoryTable.NAME+", "+MyElectroPartsDbSchema.ProjectCategoryTable.NAME+" WHERE "
                +MyElectroPartsDbSchema.ProjectTable.NAME+"."+MyElectroPartsDbSchema.ProjectTable.Cols.KEY+"="
                +MyElectroPartsDbSchema.ProjectCategoryTable.NAME+"."+MyElectroPartsDbSchema.ProjectCategoryTable.Cols.PROJECT_KEY+" AND "
                +MyElectroPartsDbSchema.CategoryTable.NAME+"."+MyElectroPartsDbSchema.CategoryTable.Cols.KEY+"="
                +MyElectroPartsDbSchema.ProjectCategoryTable.NAME+"."+MyElectroPartsDbSchema.ProjectCategoryTable.Cols.CATEGORY_KEY+" GROUP BY "
                +MyElectroPartsDbSchema.ProjectTable.NAME+"."+MyElectroPartsDbSchema.ProjectTable.Cols.KEY;

        List<Project> projects = new ArrayList<>();

        Cursor cursor=db.rawQuery(selectString, null);
        if (cursor.moveToFirst()) {
            do {
                Project project = new Project();
                project.setId(java.util.UUID.fromString(cursor.getString(cursor.getColumnIndex(MyElectroPartsDbSchema.ProjectTable.Cols.UUID))));
                project.setDatabaseId(cursor.getLong(cursor.getColumnIndex(MyElectroPartsDbSchema.ProjectTable.Cols.KEY)));
                project.setProjectTitle(cursor.getString(cursor.getColumnIndex(MyElectroPartsDbSchema.ProjectTable.Cols.TITLE)));
                project.setProjectDifficulty(cursor.getInt(cursor.getColumnIndex(MyElectroPartsDbSchema.ProjectTable.Cols.DIFFICULTY)));

                String dateTime = cursor.getString(cursor.getColumnIndex(MyElectroPartsDbSchema.ProjectTable.Cols.DATE));
                DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    project.setDate(iso8601Format.parse(dateTime));
                } catch (ParseException e) {
                }

                projects.add(project);
            } while (cursor.moveToNext());
        }

        db.close();

        return projects;
    }

    public List<Category> getAllCategories() {
        SQLiteDatabase db=getWritableDatabase();
        List<Category> categories = new ArrayList<>();

        String selectString="SELECT * FROM "+MyElectroPartsDbSchema.CategoryTable.NAME;
        Cursor cursor=db.rawQuery(selectString, null);
        if (cursor.moveToFirst()) {
            do {
                Category category=new Category();
                category.setId(cursor.getLong(cursor.getColumnIndex(MyElectroPartsDbSchema.CategoryTable.Cols.KEY)));
                category.setCategoryName(cursor.getString(cursor.getColumnIndex(MyElectroPartsDbSchema.CategoryTable.Cols.NAME)));

                categories.add(category);
            } while (cursor.moveToNext());
        }

        db.close();

        return categories;
    }

    public List<Category> getProjectCategories(long projectId) {
        SQLiteDatabase db=getWritableDatabase();

        String selectString="SELECT * FROM "+MyElectroPartsDbSchema.CategoryTable.NAME+", "+MyElectroPartsDbSchema.ProjectCategoryTable.NAME+" WHERE "
                +MyElectroPartsDbSchema.ProjectCategoryTable.NAME+"."+MyElectroPartsDbSchema.ProjectCategoryTable.Cols.PROJECT_KEY+"="+Long.toString(projectId)
                +" AND "+MyElectroPartsDbSchema.CategoryTable.NAME+"."+MyElectroPartsDbSchema.CategoryTable.Cols.KEY+"="+MyElectroPartsDbSchema.ProjectCategoryTable.NAME+"."+MyElectroPartsDbSchema.ProjectCategoryTable.Cols.CATEGORY_KEY;

        List<Category> categories = new ArrayList<>();

        Cursor cursor=db.rawQuery(selectString, null);
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(cursor.getLong(cursor.getColumnIndex(MyElectroPartsDbSchema.CategoryTable.Cols.KEY)));
                category.setCategoryName(cursor.getString(cursor.getColumnIndex(MyElectroPartsDbSchema.CategoryTable.Cols.NAME)));

                categories.add(category);
            } while (cursor.moveToNext());
        }

        db.close();

        return categories;
    }



    public long addProject(Project project) throws SQLException {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UUID, project.getId().toString());
        values.put(TITLE, project.getProjectTitle());
        values.put(DIFFICULTY, project.getProjectDifficulty());


        long returnValue=db.insert(MyElectroPartsDbSchema.ProjectTable.NAME, null, values);

        return returnValue;
    }

    public void addProjectCategory(long project_id, List<Category> categoryList) throws SQLException {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values = new ContentValues();

        for(int i=0; i<categoryList.size(); i++) {
            values.put(MyElectroPartsDbSchema.ProjectCategoryTable.Cols.PROJECT_KEY, project_id);
            values.put(MyElectroPartsDbSchema.ProjectCategoryTable.Cols.CATEGORY_KEY, categoryList.get(i).getId());
            db.insert(MyElectroPartsDbSchema.ProjectCategoryTable.NAME, null, values);
        }
    }

    public void removeProjects(Set<Project> projectList) {
        //ToDo: optimalization must be happend as soon as possible!!!
        SQLiteDatabase db = this.getWritableDatabase();
        Iterator<Project> it=projectList.iterator();

        while(it.hasNext()) {
            Project p=it.next();
            db.delete(MyElectroPartsDbSchema.ProjectTable.NAME, MyElectroPartsDbSchema.ProjectTable.Cols.KEY + " = ?",
                    new String[]{String.valueOf(p.getDatabaseId())});
            db.delete(MyElectroPartsDbSchema.ProjectCategoryTable.NAME, MyElectroPartsDbSchema.ProjectCategoryTable.Cols.PROJECT_KEY + " = ?",
                    new String[]{String.valueOf(p.getDatabaseId())});
        }
        db.close();
    }



}
