package io.bloc.android.blocly.api.model.database.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tonyk_000 on 5/5/2015.
 */
public abstract class Table {

    // #1
    public static interface Builder {
        // #2
        public long insert(SQLiteDatabase writableDB);
    }

    // #1
    protected static final String COLUMN_ID = "id";

    public abstract String getName();

    public abstract String getCreateStatement();

    // #2
    public void onUpgrade(SQLiteDatabase writableDatabase, int oldVersion, int newVersion) {
        // Nothing
    }

    public Cursor fetchRow(SQLiteDatabase readonlyDatabase, long rowId) {
        return readonlyDatabase.query(true, getName(), null, COLUMN_ID + " = ?",
                new String[] {String.valueOf(rowId)}, null, null, null, null);
    }
    // #1a
    protected static String getString(Cursor cursor, String column) {
        int columnIndex = cursor.getColumnIndex(column);
        if (columnIndex == -1) {
            return "";
        }
        return cursor.getString(columnIndex);
    }

    // #1b
    protected static long getLong(Cursor cursor, String column) {
        int columnIndex = cursor.getColumnIndex(column);
        if (columnIndex == -1) {
            return -1;
        }
        return cursor.getLong(columnIndex);
    }

    // #2
    protected static boolean getBoolean(Cursor cursor, String column) {
        return getLong(cursor, column) == 1;
    }
}
