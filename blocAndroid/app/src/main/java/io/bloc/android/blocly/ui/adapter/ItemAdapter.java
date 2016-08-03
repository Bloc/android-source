package io.bloc.android.blocly.ui.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.DataSource;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;

/**
 * Created by aadik_000 on 7/26/2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private static String TAG = ItemAdapter.class.getSimpleName();

    // #6
    @Override
    public ItemAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_item, viewGroup, false);
        return new ItemAdapterViewHolder(inflate);
    }

    // #7
    @Override
    public void onBindViewHolder(ItemAdapterViewHolder itemAdapterViewHolder, int index) {
        DataSource sharedDataSource = BloclyApplication.getSharedDataSource();
        itemAdapterViewHolder.update(sharedDataSource.getFeeds().get(0), sharedDataSource.getItems().get(index));
    }

    // #8
    @Override
    public int getItemCount() {
        return BloclyApplication.getSharedDataSource().getItems().size();
    }

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements ImageLoadingListener {

        TextView title;
        TextView feed;
        TextView content;
        View headerWrapper;
        ImageView headerImage;
        String imageURL;

        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_rss_item_title);
            feed = (TextView) itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = (TextView) itemView.findViewById(R.id.tv_rss_item_content);
            headerWrapper = itemView.findViewById(R.id.fl_rss_item_image_header);
            headerImage = (ImageView) headerWrapper.findViewById(R.id.iv_rss_item_image);
        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
            imageURL = rssItem.getImageUrl();
            if (imageURL != null) {
                headerWrapper.setVisibility(View.VISIBLE);
                headerImage.setVisibility(View.INVISIBLE);
                ImageLoader.getInstance().loadImage(imageURL, this);
            } else {
                headerWrapper.setVisibility(View.GONE);
            }
        }

        @Override
        public void onLoadingStarted(String imageUri, View view) {}

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            Throwable myThrowable = new Throwable();
            Log.e(TAG, "onLoadingFailed: " + failReason.toString() + " for URL: " + imageUri, myThrowable);
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (imageUri.equals(imageURL)) {
                headerImage.setImageBitmap(loadedImage);
                headerImage.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onLoadingCancelled(String imageUri, View view) {
            ImageLoader.getInstance().loadImage(imageUri, this);
        }
    }
}