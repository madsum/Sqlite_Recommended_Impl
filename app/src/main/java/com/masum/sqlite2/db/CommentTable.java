package com.masum.sqlite2.db;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by masum on 27/07/15.
 */
public class CommentTable {
    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_COMMENT + " text not null"
            + ");";

    public static void onCreate(SQLiteDatabase database){

        try {
            database.execSQL(DATABASE_CREATE);
        }catch (Exception e){
            Log.e(CommentTable.class.getName(), e.getMessage());
        }
    }

    public static void onUpdate(SQLiteDatabase database){

        try {
            database.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
            onCreate(database);
        }catch (Exception e){
            Log.e(CommentTable.class.getName(), e.getMessage());
        }
    }


}
