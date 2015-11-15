package io.bloc.android.blocly.api;

import java.util.ArrayList;
import java.util.List;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.api.network.GetFeedsNetworkRequest;

/**
 * Created by Austin on 10/16/2015.
 */
public class DataSource {

    private ArrayList<GetFeedsNetworkRequest.FeedResponse> feeds;
    private ArrayList<GetFeedsNetworkRequest.ItemResponse> items;

    public DataSource() {
        feeds = new ArrayList<GetFeedsNetworkRequest.FeedResponse>();
        items = new ArrayList<GetFeedsNetworkRequest.ItemResponse>();
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
            items.add(new RssItem(String.valueOf(i),
                    BloclyApplication.getSharedInstance().getString(R.string.placeholder_headline) + " " + i,
                    BloclyApplication.getSharedInstance().getString(R.string.placeholder_content),
                    "http://thisisafakewebsite.com",
                    "http://rs1img.memecdn.com/silly-dog_o_511213.jpg",
                    0, System.currentTimeMillis(), false, false, false));
        }
    }

}
