package io.bloc.android.blocly.api.model.database.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Austin on 11/15/2015.
 */
public abstract class Table {

    public static interface Builder{
        public long insert(SQLiteDatabase writableDB);
    }

    protected static final String COLUMN_ID = "id";

    public abstract String getName();

    public abstract String getCreateStatement();

    public void onUpgrade(SQLiteDatabase writableDatabase, int oldVersion, int newVersion){

    }
    protected static String getString(Cursor cursor, String column){
        int columnIndex = cursor.getColumnIndex(column);
        if(columnIndex == -1){
            return "";
        }
        cursor.moveToFirst();
        return cursor.getString(columnIndex);
    }

    protected static long getLong(Cursor cursor, String column){
        int columnIndex = cursor.getColumnIndex(column);
        if(columnIndex == -1){
            return -1l;
        }
        return cursor.getLong(columnIndex);
    }

    protected static boolean getBoolean(Cursor cursor, String column){
        return getLong(cursor, column) == 1l;
    }

    public Cursor fetchRow(SQLiteDatabase readonlyDatabase, long rowId){
        return readonlyDatabase.query(true, getName(), null, COLUMN_ID + " = ?",
                new String[] {String.valueOf(rowId)}, null, null, null, null);
    }

}
