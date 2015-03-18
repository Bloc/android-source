package io.bloc.android.blocly.api.model;

/**
 * Created by ReneeCS on 3/17/15.
 */
public class RssFeed {
    private String title;

    public RssFeed(String title, String description, String siteUrl, String feedUrl) {
        this.title = title;
        this.description = description;
        this.siteUrl = siteUrl;
        this.feedUrl = feedUrl;
    }

    private String description;
    private String siteUrl;
    private String feedUrl;

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
