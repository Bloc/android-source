package io.bloc.android.blocly.api;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
public class DataSource{

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
        createRealData();

        new Thread(new Runnable() {
            @Override
            public void run () {
                if(BuildConfig.DEBUG && false){
                    BloclyApplication.getSharedInstance().deleteDatabase("blocly_db");
                }
                SQLiteDatabase writableDatabase = databaseOpenHelper.getWritableDatabase();
                new GetFeedsNetworkRequest("http://feeds.feedburner.com/androidcentral?format=xml").performRequest();
            }
        }).start();
    }

    public List<RssFeed> getFeeds() {
        return feeds;
    }

    public List<RssItem> getItems() {
        return items;
    }


    void createRealData() {
        feeds.add(new RssFeed(GetFeedsNetworkRequest.FeedResponse.channelTitle, GetFeedsNetworkRequest.FeedResponse.channelDescription,
                GetFeedsNetworkRequest.FeedResponse.channelURL, GetFeedsNetworkRequest.FeedResponse.channelFeedURL));
        for (int i = 0; i < 10; i++) {
            items.add(new RssItem(GetFeedsNetworkRequest.ItemResponse.itemGUID,
                    GetFeedsNetworkRequest.ItemResponse.itemTitle,
                    GetFeedsNetworkRequest.ItemResponse.itemDescription,
                    GetFeedsNetworkRequest.ItemResponse.itemURL,
                    GetFeedsNetworkRequest.ItemResponse.itemEnclosureURL,
                    121212,
                    GetFeedsNetworkRequest.ItemResponse.itemPubDate, false, false, false));
        }
    }

}
