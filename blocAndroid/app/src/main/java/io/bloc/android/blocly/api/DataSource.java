package io.bloc.android.blocly.api;

import java.util.ArrayList;
import java.util.List;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.api.network.GetFeedsNetworkRequest;

/**
 * Created by aadik_000 on 7/26/2016.
 */
public class DataSource {
    private List<RssFeed> feeds;
    private List<RssItem> items;

    public DataSource() {
        feeds = new ArrayList<RssFeed>();
        items = new ArrayList<RssItem>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                convertToRssFeed(new GetFeedsNetworkRequest("http://feeds.feedburner.com/androidcentral?format=xml").performRequest());
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
