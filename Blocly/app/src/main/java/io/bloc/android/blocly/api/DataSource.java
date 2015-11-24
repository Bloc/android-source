package io.bloc.android.blocly.api;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.BuildConfig;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.api.model.database.DatabaseOpenHelper;
import io.bloc.android.blocly.api.model.database.table.RssFeedTable;
import io.bloc.android.blocly.api.model.database.table.RssItemTable;
import io.bloc.android.blocly.api.network.GetFeedsNetworkRequest;

/**
 * Created by Austin on 10/16/2015.
 */
public class DataSource {

    public static final String ACTION_DOWNLOAD_COMPLETED = DataSource.class.getCanonicalName().concat(".ACTION_DOWNLOAD_COMPLETED");

    private DatabaseOpenHelper databaseOpenHelper;
    private RssFeedTable rssFeedTable;
    private RssItemTable rssItemTable;
    private ArrayList<RssFeed> feeds;
    private ArrayList<RssItem> items;

    public DataSource() {
        rssFeedTable = new RssFeedTable();
        rssItemTable = new RssItemTable();

        databaseOpenHelper = new DatabaseOpenHelper(BloclyApplication.getSharedInstance(), rssFeedTable, rssItemTable);
        feeds = new ArrayList<RssFeed>();
        items = new ArrayList<RssItem>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (BuildConfig.DEBUG && true) {
                    BloclyApplication.getSharedInstance().deleteDatabase("blocly_db");

                    SQLiteDatabase writableDatabase = databaseOpenHelper.getWritableDatabase();

                    List<GetFeedsNetworkRequest.FeedResponse> feedResponses = new GetFeedsNetworkRequest("http://www.npr.org/rss/rss.php?id=1001").performRequest();
                    List<GetFeedsNetworkRequest.ItemResponse> itemResponses = feedResponses.get(0).getItems();
                    GetFeedsNetworkRequest.FeedResponse androidCentral = feedResponses.get(0);

                    long androidCentralFeedId = new RssFeedTable.Builder()
                            .setFeedURL(androidCentral.getChannelFeedURL())
                            .setDescription(androidCentral.getChannelDescription())
                            .setSiteURL(androidCentral.getChannelURL())
                            .setTitle(androidCentral.getChannelTitle())
                            .insert(writableDatabase);


                    List<RssItem> newRSSItems = new ArrayList<RssItem>();
                    for(GetFeedsNetworkRequest.ItemResponse itemResponse : androidCentral.channelItems){

                        long itemPubDate = System.currentTimeMillis();
                        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z", Locale.ENGLISH);
                        try{
                            itemPubDate = dateFormat.parse(itemResponse.itemPubDate).getTime();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        long newItemRowId = new RssItemTable.Builder()
                                .setTitle(itemResponse.itemTitle)
                                .setDescription(itemResponse.itemDescription)
                                .setEnclosure(itemResponse.itemEnclosureURL)
                                .setGuid(itemResponse.itemGUID)
                                .setLink(itemResponse.itemURL)
                                .setMimeType(itemResponse.itemEnclosureMIMEType)
                                .setPubDate(itemPubDate)
                                .setRssFeed(androidCentralFeedId)
                                .insert(writableDatabase);

                        Cursor itemCursor = rssItemTable.fetchRow(databaseOpenHelper.getReadableDatabase(), newItemRowId);

                        itemCursor.moveToFirst();
                        RssItem newRssItem = itemFromCursor(itemCursor);
                        newRSSItems.add(newRssItem);
                        itemCursor.close();
                    }
                    Cursor androidCentralCursor = rssFeedTable.fetchRow(databaseOpenHelper.getReadableDatabase(), androidCentralFeedId);
                    RssFeed androidCentralRssFeed = feedFromCursor(androidCentralCursor);
                    androidCentralCursor.close();
                    items.addAll(newRSSItems);
                    feeds.add(androidCentralRssFeed);

                    BloclyApplication.getSharedInstance().sendBroadcast(new Intent(ACTION_DOWNLOAD_COMPLETED));
                }
            }
        }).start();
    }

    static RssFeed feedFromCursor(Cursor cursor){
        return new RssFeed(RssFeedTable.getTitle(cursor), RssFeedTable.getDescription(cursor), RssFeedTable.getSiteURL(cursor), RssFeedTable.getFeedURL(cursor));
    }

    static RssItem itemFromCursor(Cursor cursor){
        return new RssItem(RssItemTable.getGUID(cursor), RssItemTable.getTitle(cursor),
                RssItemTable.getDescription(cursor), RssItemTable.getLink(cursor),
                RssItemTable.getEnclosure(cursor), RssItemTable.getRssFeedId(cursor),
                RssItemTable.getPubDate(cursor), false,
                RssItemTable.getFavorite(cursor), RssItemTable.getArchived(cursor));
    }

    public List<RssFeed> getFeeds() {
        return feeds;
    }

    public List<RssItem> getItems() {
        return items;
    }

}