package io.bloc.android.blocly.api.model.database.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tonyk_000 on 5/5/2015.
 */
public class RssFeedTable extends Table {

    public static class Builder implements Table.Builder {
        // #3
        ContentValues values = new ContentValues();

        // #4
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

        // #5
        @Override
        public long insert(SQLiteDatabase writableDB) {
            return writableDB.insert(NAME, null, values);
        }
    }

    private static final String NAME = "rss_feeds";

    private static final String COLUMN_LINK = "link";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_FEED_URL = "feed_url";

    @Override
    public String getName() {
        return "rss_feeds";
    }

    @Override
    public String getCreateStatement() {
        // #3
        return "CREATE TABLE " + getName() + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_LINK + " TEXT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_FEED_URL + " TEXT)";
    }
}
