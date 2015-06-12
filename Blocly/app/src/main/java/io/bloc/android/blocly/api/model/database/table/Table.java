package io.bloc.android.blocly.api.model.database.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ReneeCS on 5/18/15.
 */
public abstract class Table {

    public static interface Builder {
        public long insert(SQLiteDatabase writableDB);
    }

        protected static final String COLUMN_ID = "id";

        public abstract String getName();

        public abstract String getCreateStatement();

        public void onUpgrade(SQLiteDatabase writableDatabase, int oldVersion, int newVersion) {
            // Nothing
        }

    public Cursor fetchRow(SQLiteDatabase readonlyDatabase, long rowId) {
        return readonlyDatabase.query(true, getName(), null, COLUMN_ID + " = ?",
                new String[] {String.valueOf(rowId)}, null, null, null, null);
    }

    protected static String getString(Cursor cursor, String column) {
        int columnIndex = cursor.getColumnIndex(column);
        if (columnIndex == -1) {
            return "";
        }
        return cursor.getString(columnIndex);
    }

    protected static long getLong(Cursor cursor, String column) {
        int columnIndex = cursor.getColumnIndex(column);
        if (columnIndex == -1) {
            return -1l;
        }
        return cursor.getLong(columnIndex);
    }

    protected static boolean getBoolean(Cursor cursor, String column) {
        return getLong(cursor, column) == 1l;
    }

}