package io.bloc.android.blocly.api.model.database.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ReneeCS on 5/18/15.
 */
public class RssFeedTable extends Table {

    public static class Builder implements Table.Builder {
        ContentValues values = new ContentValues();

        public Builder setSiteURL(String siteURL) {
            values.put(COLUMN_LINK, siteURL);
            return this;
        }

        public Builder setFeedURL(String feedURL) {
            values.put(COLUMN_FEED_URL, feedURL);
            return this;
        }

        public Builder setTitle(String title) {
            values.put(COLUMN_TITLE, title);
            return this;
        }

        public Builder setDescription(String description) {
            values.put(COLUMN_DESCRIPTION, description);
            return this;
        }

        @Override
        public long insert(SQLiteDatabase writableDB) {
            return writableDB.insert(NAME, null, values);
        }
    }

    public static String getSiteURL(Cursor cursor) {
        return getString(cursor, COLUMN_LINK);
    }

    public static String getFeedURL(Cursor cursor) {
        return getString(cursor, COLUMN_FEED_URL);
    }

    public static String getTitle(Cursor cursor) {
        return getString(cursor, COLUMN_TITLE);
    }

    public static String getDescription(Cursor cursor) {
        return getString(cursor, COLUMN_DESCRIPTION);
    }

    private static final String NAME = "rss_feeds";

    private static final String COLUMN_LINK = "link";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_FEED_URL = "feed_url";
//    private static final String AUTHOR = "author"; // example

    @Override
    public String getName() {
        return "rss_feeds";
    }

    @Override
    public String getCreateStatement() {
        return "CREATE TABLE " + getName() + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_LINK + " TEXT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
//                + AUTHOR + " TEXT," // example
                + COLUMN_FEED_URL + " TEXT)";

    }
}
