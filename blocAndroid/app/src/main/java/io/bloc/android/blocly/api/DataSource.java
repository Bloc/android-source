package io.bloc.android.blocly.api;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.BuildConfig;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.api.model.database.DatabaseOpenHelper;
import io.bloc.android.blocly.api.model.database.table.RssFeedTable;
import io.bloc.android.blocly.api.model.database.table.RssItemTable;
import io.bloc.android.blocly.api.network.GetFeedsNetworkRequest;

/**
 * Created by aadik_000 on 7/26/2016.
 */
public class DataSource {
    private List<RssFeed> feeds;
    private List<RssItem> items;
    private DatabaseOpenHelper databaseOpenHelper;
    private RssFeedTable rssFeedTable;
    private RssItemTable rssItemTable;

    public DataSource() {
        rssFeedTable = new RssFeedTable();
        rssItemTable = new RssItemTable();
        databaseOpenHelper = new DatabaseOpenHelper(BloclyApplication.getSharedInstance(),
                rssFeedTable, rssItemTable);
        feeds = new ArrayList<RssFeed>();
        items = new ArrayList<RssItem>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (BuildConfig.DEBUG && false) {
                    BloclyApplication.getSharedInstance().deleteDatabase("blocly_db");
                }
                SQLiteDatabase writableDatabase = databaseOpenHelper.getWritableDatabase();
                convertToRssFeed(new GetFeedsNetworkRequest("http://feeds.feedburner.com/androidcentral?format=xml").performRequest());
                ContentValues contentValues = new ContentValues();
                for(int i = 0; i<feeds.size(); i++){
                    contentValues.put("link", feeds.get(i).getSiteUrl());
                    contentValues.put("title", feeds.get(i).getTitle());
                    contentValues.put("description", feeds.get(i).getDescription());
                    contentValues.put("feed_url", feeds.get(i).getFeedUrl());
                    writableDatabase.insert(rssFeedTable.getName(), null, contentValues);
            }
                //Similarly, make a ContentValues variable and loop for rssItemsTable and put values and add them to the table

            }
        }).start();
    }

    public void convertToRssFeed(List<GetFeedsNetworkRequest.FeedResponse> listFeeds){
        GetFeedsNetworkRequest.FeedResponse response;
        for (int i = 0; i<listFeeds.size(); i++){
            response = listFeeds.get(i);
            feeds.add(new RssFeed(response.channelTitle, response.channelDescription, response.channelURL, response.channelFeedURL));
            convertToRssItem(response.channelItems, i);
        }
    }

    public void convertToRssItem(List<GetFeedsNetworkRequest.ItemResponse> listItems, int feedId){
        GetFeedsNetworkRequest.ItemResponse response;
        for(int i = 0; i<listItems.size(); i++){
            response = listItems.get(i);
            items.add(new RssItem(response.itemGUID, response.itemTitle, response.itemDescription,response.itemURL,response.itemEnclosureURL, feedId,
                    Long.valueOf(response.itemPubDate.substring(12,16)), false, false, false));
        }
    }

    public List<RssFeed> getFeeds() {
        return feeds;
    }

    public List<RssItem> getItems() {
        return items;
    }

    void createFakeData() {
        feeds.add(new RssFeed("My Favorite Feed",
                "This feed is just incredible, I can't even begin to tell you…",
                "http://favoritefeed.net", "http://feeds.feedburner.com/favorite_feed?format=xml"));
        for (int i = 0; i < 10; i++) {
            items.add(new RssItem(String.valueOf(i),
                    BloclyApplication.getSharedInstance().getString(R.string.placeholder_headline)+" "+i,
                    BloclyApplication.getSharedInstance().getString(R.string.placeholder_content),
                    "http://favoritefeed.net?story_id=an-incredible-news-story",
                    "https://bloc-global-assets.s3.amazonaws.com/images-android/foundation/silly-dog.jpg",
                    0, System.currentTimeMillis(), false, false, false));
        }
    }
}
