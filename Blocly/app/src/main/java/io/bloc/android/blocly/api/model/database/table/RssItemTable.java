package io.bloc.android.blocly.api.model.database.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Austin on 11/15/2015.
 */
public class RssItemTable extends Table {

    public static class Builder implements Table.Builder{

        ContentValues values = new ContentValues();

        public Builder setLink(String link){
            values.put(COLUMN_LINK, link);
            return this;
        }

        public Builder setDescription(String description){
            values.put(COLUMN_DESCRIPTION, description);
            return this;
        }

        public Builder setTitle(String title){
            values.put(COLUMN_TITLE, title);
            return this;
        }

        public Builder setPubDate(long pubDate){
            values.put(COLUMN_PUB_DATE, pubDate);
            return this;
        }

        public Builder setEnclosure(String enclosure){
            values.put(COLUMN_ENCLOSURE, enclosure);
            return this;
        }

        public Builder setMimeType(String mimeType){
            values.put(COLUMN_MIME_TYPE, mimeType);
            return this;
        }

        public Builder setRssFeed(long rssFeed){
            values.put(COLUMN_RSS_FEED, rssFeed);
            return this;
        }

        public Builder setGuid(String guid){
            values.put(COLUMN_GUID, guid);
            return this;
        }

        @Override
        public long insert(SQLiteDatabase writableDB) {
            return writableDB.insert(NAME, null, values);
        }
    }

    private static final String COLUMN_LINK = "link";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_GUID = "guid";
    public static final String COLUMN_PUB_DATE = "pub_date";
    private static final String COLUMN_ENCLOSURE = "enclosure";
    private static final String COLUMN_MIME_TYPE = "mime_type";
    private static final String COLUMN_RSS_FEED = "rss_feed";
    private static final String COLUMN_FAVORITE = "is_favorite";
    private static final String COLUMN_ARCHIVED = "is_archived";
    private static final String NAME = "rss_items";


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

    public static String getLink(Cursor cursor){
        return getString(cursor, COLUMN_LINK);
    }

    public static String getTitle(Cursor cursor){
        return getString(cursor, COLUMN_TITLE);
    }

    public static String getDescription(Cursor cursor){
        return getString(cursor, COLUMN_DESCRIPTION);
    }

    public static String getGUID(Cursor cursor){
        return getString(cursor, COLUMN_GUID);
    }

    public static long getRssFeedId(Cursor cursor){
        return getLong(cursor, COLUMN_RSS_FEED);
    }

    public static long getPubDate(Cursor cursor){
        return getLong(cursor, COLUMN_PUB_DATE);
    }

    public static String getEnclosure(Cursor cursor){
        return getString(cursor, COLUMN_ENCLOSURE);
    }

    public static boolean getFavorite(Cursor cursor){
        return getBoolean(cursor, COLUMN_FAVORITE);
    }

    public static boolean getArchived(Cursor cursor){
        return getBoolean(cursor, COLUMN_ARCHIVED);
    }

    public Cursor fetchArchivedItems(SQLiteDatabase readonlyDatabase, long rowId){
        return readonlyDatabase.query(getName(), null, COLUMN_ID + " = ?", new String[]{String.valueOf(rowId)}, COLUMN_ARCHIVED, "total(is_archived) = 1", null);
    }

    public Cursor fetchArchivedItemInFeed(SQLiteDatabase readonlyDatabase, String[] feedColumn, long rowId){
        return readonlyDatabase.query(getName(), feedColumn, COLUMN_ID + " = ?", new String[] {String.valueOf(rowId)}, COLUMN_ARCHIVED, "total(is_archived) = 1", null);
    }

    public Cursor fetchFavorites(SQLiteDatabase readonlyDatabase, long rowId){
        return readonlyDatabase.query(getName(), null, COLUMN_ID + " = ?", new String[] {String.valueOf(rowId)}, COLUMN_FAVORITE, "total(is_favorite) = 1", null);
    }

    public Cursor fetchFavoritesInFeed(SQLiteDatabase readonlyDatabase, String[] feedColumn, long rowId){
        return readonlyDatabase.query(getName(), feedColumn, COLUMN_ID + " = ?", new String[] {String.valueOf(rowId)}, COLUMN_FAVORITE, "total(is_favorite) = 1", null);
    }

    public Cursor fetchAllItems(SQLiteDatabase readonlyDatabase, long rowId){
        return readonlyDatabase.query(getName(), null, COLUMN_ID + " = ?", new String [] {String.valueOf(rowId)}, null, null, null);
    }

    public Cursor fetchSelectedItems(SQLiteDatabase readonlyDatabase, int OFFSET, int LIMIT, long rowId){
        return readonlyDatabase.query(getName(), null, COLUMN_ID + " = ?", new String[] {String.valueOf(rowId)}, null, null, null, "LIMIT " + LIMIT + " OFFSET " + OFFSET);
    }

    public static long getRowId(Cursor cursor){
        return getLong(cursor, COLUMN_ID);
    }

    public static Cursor fetchItemsForFeed(SQLiteDatabase readonlyDatabase, long feedRowId){
        return readonlyDatabase.query(true, NAME, null, COLUMN_RSS_FEED + " = ?",
                new String[]{String.valueOf(feedRowId)},
               null, null, COLUMN_PUB_DATE + " DESC", null);
    }

}

