package io.bloc.android.blocly.api.model.database.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Austin on 11/15/2015.
 */
public class RssFeedTable extends Table{
    private static final String COLUMN_LINK = "link";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_FEED_URL = "feed_url";
    ContentValues values = new ContentValues();
    private static final String NAME = "rss_feeds";

    @Override
    public String getName() {
        return "rss_feeds";
    }

    @Override
    public String getCreateStatement() {
        return "CREATE TABLE " + getName() + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_LINK + "TEXT,"
                + COLUMN_TITLE + "TEXT,"
                + COLUMN_DESCRIPTION + "TEXT,"
                + COLUMN_FEED_URL + "TEXT,";
    }

    public void setColumnSiteURL(String siteURL){
        values.put(COLUMN_LINK, siteURL);
    }

    public void setColumnFeedURL(String feedURL){
        values.put(COLUMN_FEED_URL, feedURL);
    }

    public void setColumnTitle(String title){
        values.put(COLUMN_TITLE, title);
    }

    public void setColumnLink(String link){
        values.put(COLUMN_LINK, link);
    }

    public void setColumnDescription(String description){
        values.put(COLUMN_DESCRIPTION, description);
    }

    public long insert(SQLiteDatabase writableDB){
        return writableDB.insert(NAME, null, values);
    }

}