package io.bloc.android.blocly.api.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import io.bloc.android.blocly.api.model.database.table.Table;

/**
 * Created by tonyk_000 on 5/11/2015.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    // #1
    private static final String NAME = "blocly_db";
    // #2
    private static final int VERSION = 1;

    private Table[] tables;

    public DatabaseOpenHelper(Context context, Table... tables) {
        // #3
        super(context, NAME, null, VERSION);
        this.tables = tables;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (Table table : tables) {
            db.execSQL(table.getCreateStatement());
        }
    }

    // #5
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (Table table : tables) {
            table.onUpgrade(db, oldVersion, newVersion);
        }
    }
}
