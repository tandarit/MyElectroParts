package com.tandari.android.myelectroparts.Database;

public class MyElectroPartsDbSchema {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "MyElectroParts.db";

    /*-------------------------------------------------------------------------------------------------------*
    *   Project table                                                                                        *
    * -------------------------------------------------------------------------------------------------------*/

    public static final String DATABASE_DROP_PROJECTS = "DROP TABLE IF EXISTS "+ProjectTable.NAME+";";
    public static final String DATABASE_CREATE_PROJECTS = "CREATE TABLE IF NOT EXISTS "+ProjectTable.NAME+"("+
            ProjectTable.Cols.KEY+" integer primary key autoincrement, " +
            ProjectTable.Cols.UUID + " VARCHAR(255), " +
            ProjectTable.Cols.TITLE + " VARCHAR(75), " +
            ProjectTable.Cols.DIFFICULTY + " INTEGER, " +
            ProjectTable.Cols.DATE +
            " DATETIME DEFAULT CURRENT_TIMESTAMP);";

    public static final class ProjectTable {
        public static final String NAME = "Projects";
        public static final class Cols {
            public static final String KEY = "project_id";
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String DIFFICULTY = "difficulty";
        }
    }

    /*--------------------------------------------------------------------------------------------------------*
     *   Category table                                                                                        *
     * -------------------------------------------------------------------------------------------------------*/

    public static final String DATABASE_DROP_CATEGORIES = "DROP TABLE IF EXISTS "+CategoryTable.NAME+";";
    public static final String DATABASE_CREATE_CATEGORIES = "CREATE TABLE IF NOT EXISTS "+CategoryTable.NAME+"("+
            CategoryTable.Cols.KEY+" integer primary key autoincrement, " +
            CategoryTable.Cols.NAME + " VARCHAR(75));";



    public static final class CategoryTable {
        public static final String NAME = "Categories";
        public static final class Cols {
            public static final String KEY = "category_id";
            public static final String NAME = "category_name";
        }
    }

    /*--------------------------------------------------------------------------------------------------------*
     *   ProjectCategory table                                                                                        *
     * -------------------------------------------------------------------------------------------------------*/
    public static final String DATABASE_DROP_PROJECTCATEGORY = "DROP TABLE IF EXISTS "+ProjectCategoryTable.NAME+";";
    public static final String DATABASE_CREATE_PROJECTCATEGORY = "CREATE TABLE IF NOT EXISTS "+ProjectCategoryTable.NAME+"("+
            ProjectCategoryTable.Cols.KEY+" integer primary key autoincrement, " +
            ProjectCategoryTable.Cols.PROJECT_KEY + " integer, "+
            ProjectCategoryTable.Cols.CATEGORY_KEY+" integer);";



    public static final class ProjectCategoryTable {
        public static final String NAME = "ProjectCategories";
        public static final class Cols {
            public static final String KEY = "project_category_id";
            public static final String PROJECT_KEY = "project_id";
            public static final String CATEGORY_KEY = "category_id";
        }
    }

    /*--------------------------------------------------------------------------------------------------------*
     *   ProductClass table                                                                                        *
     * -------------------------------------------------------------------------------------------------------*/
    public static final String DATABASE_DROP_PRODUCT_CLASS = "DROP TABLE IF EXISTS "+ProductClassTable.NAME+";";
    public static final String DATABASE_CREATE_PRODUCT_CLASS = "CREATE TABLE IF NOT EXISTS "+ProductClassTable.NAME+"("+
            ProductClassTable.Cols.KEY+" integer primary key autoincrement, " +
            ProductClassTable.Cols.PRODUCT_CLASS_NAME + " VARCHAR(75));";



    public static final class ProductClassTable {
        public static final String NAME = "ProductClass";
        public static final class Cols {
            public static final String KEY = "product_class_id";
            public static final String PRODUCT_CLASS_NAME = "product_class_name";
        }
    }

}
