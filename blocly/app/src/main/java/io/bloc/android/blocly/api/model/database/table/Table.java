package io.bloc.android.blocly.api.model.database.table;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tonyk_000 on 5/5/2015.
 */
public abstract class Table {

    // #1
    protected static final String COLUMN_ID = "id";

    public abstract String getName();

    public abstract String getCreateStatement();

    // #2
    public void onUpgrade(SQLiteDatabase writableDatabase, int oldVersion, int newVersion) {
        // Nothing
    }
}
