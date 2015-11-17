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

        new Thread(new Runnable() {
            @Override
            public void run () {
                if(BuildConfig.DEBUG && false){
                    BloclyApplication.getSharedInstance().deleteDatabase("blocly_db");
                }
                SQLiteDatabase writableDatabase = databaseOpenHelper.getWritableDatabase();

               List<GetFeedsNetworkRequest.FeedResponse> feedResponses = new GetFeedsNetworkRequest("http://feeds.feedburner.com/androidcentral?format=xml").performRequest();
                List<GetFeedsNetworkRequest.ItemResponse> itemResponses = feedResponses.get(0).getItems();
                addFeedData(feedResponses);
                addItemData(itemResponses);
            }
        }).start();
    }

    public List<RssFeed> getFeeds() {
        return feeds;
    }

    public List<RssItem> getItems() {
        return items;
    }


    public List<RssFeed> addFeedData(List<GetFeedsNetworkRequest.FeedResponse> feedResponses) {
        for(int i = 0; i < feedResponses.size(); i++) {
            RssFeed feed = new RssFeed(feedResponses.get(i).getChannelTitle(),
                    feedResponses.get(i).getChannelDescription(),
                    feedResponses.get(i).getChannelURL(),
                    feedResponses.get(i).getChannelFeedURL());
            feeds.add(i, feed);
        }
        return feeds;
    }

    public List<RssItem> addItemData(List<GetFeedsNetworkRequest.ItemResponse> itemResponses){
        for(int i = 0; i < itemResponses.size(); i++){
            RssItem item = new RssItem(itemResponses.get(i).getItemGUID(),
                    itemResponses.get(i).getItemTitle(),
                    itemResponses.get(i).getItemDescription(),
                    itemResponses.get(i).getItemURL(),
                    "http://i.imgur.com/dGfyviu.jpg",
                    itemResponses.get(i).getItemPubDate(), false, false, false);
            items.add(i, item);
        }
        return items;
    }

}
