package io.bloc.android.blocly.api.model;

import java.util.List;

import io.bloc.android.blocly.api.network.GetFeedsNetworkRequest;

/**
 * Created by Austin on 10/16/2015.
 */
public class RssFeed extends GetFeedsNetworkRequest.FeedResponse {

    private String title;
    private String description;
    private String siteUrl;
    private String feedUrl;
    public RssFeed(String title, String description, String siteUrl, String feedUrl) {
        super(title, description, siteUrl, feedUrl, GetFeedsNetworkRequest.FeedResponse);
        this.title = title;
        this.description = description;
        this.siteUrl = siteUrl;
        this.feedUrl = feedUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getFeedUrl() {
        return feedUrl;
    }
}
