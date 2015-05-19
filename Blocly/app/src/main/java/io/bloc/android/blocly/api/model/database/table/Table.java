package io.bloc.android.blocly.api.model.database.table;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ReneeCS on 5/18/15.
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