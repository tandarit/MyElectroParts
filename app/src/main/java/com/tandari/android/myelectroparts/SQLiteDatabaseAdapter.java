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
import com.tandari.android.myelectroparts.Models.ProductClass;
import com.tandari.android.myelectroparts.Models.ProductSubClass;
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

public class SQLiteDatabaseAdapter extends MyElectroPartBaseHelper {
    private Context mContext;

    public SQLiteDatabaseAdapter(Context context) {
        super(context);
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

    public List<ProductClass> getAllProductClass() {
        SQLiteDatabase db=getWritableDatabase();
        List<ProductClass> productClasses = new ArrayList<>();

        String selectString="SELECT * FROM "+MyElectroPartsDbSchema.ProductClassTable.NAME;
        Cursor cursor=db.rawQuery(selectString, null);
        if (cursor.moveToFirst()) {
            do {
                ProductClass productClass=new ProductClass();

                productClass.setDatabaseId(cursor.getLong(cursor.getColumnIndex(MyElectroPartsDbSchema.ProductClassTable.Cols.KEY)));
                productClass.setTitle(cursor.getString(cursor.getColumnIndex(MyElectroPartsDbSchema.ProductClassTable.Cols.PRODUCT_CLASS_NAME)));



                productClasses.add(productClass);
            } while (cursor.moveToNext());
        }
        db.close();
        return productClasses;
    }

    public List<ProductSubClass> getAllProductSubClass(long productId) {
        SQLiteDatabase db=getWritableDatabase();
        List<ProductSubClass> productSubClasses = new ArrayList<>();

        String selectString="SELECT * FROM "+MyElectroPartsDbSchema.ProductSubClassTable.NAME+" WHERE "+MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY+"="+productId;
        Cursor cursor=db.rawQuery(selectString, null);
        if (cursor.moveToFirst()) {
            do {
                ProductSubClass productSubClass=new ProductSubClass();

                productSubClass.setProductSubClassID(cursor.getLong(cursor.getColumnIndex(MyElectroPartsDbSchema.ProductSubClassTable.Cols.KEY)));
                productSubClass.setProductSubClassName(cursor.getString(cursor.getColumnIndex(MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_SUB_CLASS_NAME)));
                productSubClass.setProductClassID(cursor.getLong(cursor.getColumnIndex(MyElectroPartsDbSchema.ProductSubClassTable.Cols.PRODUCT_CLASS_KEY)));

                productSubClasses.add(productSubClass);
            } while (cursor.moveToNext());
        }
        db.close();

        return productSubClasses;
    }



}
