package io.bloc.android.blocly.api.model.database.table;

/**
 * Created by ReneeCS on 5/18/15.
 */
public class RssFeedTable extends Table {

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
