package io.bloc.android.blocly.api;

import java.util.ArrayList;
import java.util.List;

import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.api.network.GetFeedsNetworkRequest;

/**
 * Created by Austin on 10/16/2015.
 */
public class DataSource{

    private ArrayList<RssFeed> feeds;
    private ArrayList<RssItem> items;

    public DataSource() {
        feeds = new ArrayList<RssFeed>();
        items = new ArrayList<RssItem>();
        createRealData();

        new Thread(new Runnable() {
            @Override
            public void run () {
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
