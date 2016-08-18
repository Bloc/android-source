package io.bloc.android.blocly.api.model;

/**
 * Created by aadik_000 on 7/26/2016.
 */
public class RssItem extends Model{
    private String guid;
    private String title;
    private String description;
    private String url;
    private String imageUrl;
    private long rssFeedId;
    private long datePublished;
    private boolean read;
    private boolean favorite;
    private boolean archived;

    public RssItem(long rowId, String guid, String title, String description, String url, String imageUrl, long rssFeedId, long datePublished, boolean read, boolean favorite, boolean archived) {
        super(rowId);
        this.guid = guid;
        this.title = title;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
        this.rssFeedId = rssFeedId;
        this.datePublished = datePublished;
        this.read = read;
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

    public boolean isRead() {
        return read;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public boolean isArchived() {
        return archived;
    }

    public void makeFavorite(boolean b){
        favorite = b;
    }

    public void makeArchive(boolean b){
        archived = b;
    }
}
