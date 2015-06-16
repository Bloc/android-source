package io.bloc.android.blocly.api.model;

/**
 * Created by ReneeCS on 3/17/15.
 */
public class RssItem {
    private String guid;
    private String title;
    private String description;
    private String url;
    private String imageUrl;
    private long rssFeedId;
    private long datePublished;
//    private boolean read;
    private boolean favorite;
    private boolean archived;

    public RssItem(String guid, String title, String description, String url, String imageUrl, long rssFeedId, long datePublished, boolean favorite, boolean archived) { // boolean read removed from between datePublished and favorited
        this.guid = guid;
        this.title = title;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
        this.rssFeedId = rssFeedId;
        this.datePublished = datePublished;
//        this.read = read;
        this.favorite = favorite;
        this.archived = archived;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getRssFeedId() {
        return rssFeedId;
    }

    public long getDatePublished() {
        return datePublished;
    }

//    public boolean isRead() {
//        return read;
//    }

    public boolean isFavorite() {
        return favorite;
    }

    public boolean isArchived() {
        return archived;
    }
}

