package io.bloc.android.blocly.api.model.database.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Austin on 11/15/2015.
 */
public class RssItemTable extends Table {

    private static final String COLUMN_LINK = "link";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_GUID = "guid";
    private static final String COLUMN_PUB_DATE = "pub_date";
    private static final String COLUMN_ENCLOSURE = "enclosure";
    private static final String COLUMN_MIME_TYPE = "mime_type";
    private static final String COLUMN_RSS_FEED = "rss_feed";
    private static final String COLUMN_FAVORITE = "is_favorite";
    private static final String COLUMN_ARCHIVED = "is_archived";
    private static final String NAME = "rss_items";

    ContentValues values = new ContentValues();

    @Override
    public String getName() {
        return "rss_items";
    }

    @Override
    public String getCreateStatement() {
        return "CREATE TABLE " + getName() + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_LINK + " TEXT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_GUID + " TEXT,"
                + COLUMN_PUB_DATE + " INTEGER,"
                + COLUMN_ENCLOSURE + " TEXT,"
                + COLUMN_MIME_TYPE + " TEXT,"
                + COLUMN_RSS_FEED + " INTEGER,"
                + COLUMN_FAVORITE + " INTEGER DEFAULT 0,"
                + COLUMN_ARCHIVED + " INTEGER DEFAULT 0)";
    }

    public long insert(SQLiteDatabase writableDB) {
        return writableDB.insert(NAME, null, values);
    }

    public void setColumnLink(String link) {
        values.put(COLUMN_LINK, link);
    }

    public void setColumnTitle(String title) {
        values.put(COLUMN_TITLE, title);
    }

    public void setColumnDescription(String description) {
        values.put(COLUMN_DESCRIPTION, description);
    }

    public void setColumnGuid(String guid) {
        values.put(COLUMN_GUID, guid);
    }

    public void setColumnPubDate(String pubDate) {
        values.put(COLUMN_PUB_DATE, pubDate);
    }

    public void setColumnEnclosure(String enclosure) {
        values.put(COLUMN_ENCLOSURE, enclosure);
    }

    public void setColumnMimeType(String mimeType) {
        values.put(COLUMN_MIME_TYPE, mimeType);
    }

    public void setColumnRssFeed(long rssFeed) {
        values.put(COLUMN_RSS_FEED, rssFeed);
    }

}

