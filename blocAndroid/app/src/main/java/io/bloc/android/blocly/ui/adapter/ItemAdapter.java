package io.bloc.android.blocly.ui.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements ImageLoadingListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        TextView title;
        TextView feed;
        TextView content;
        View headerWrapper;
        ImageView headerImage;
        RssItem rssItem;
        CheckBox archiveCheckbox;
        CheckBox favoriteCheckbox;

        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_rss_item_title);
            feed = (TextView) itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = (TextView) itemView.findViewById(R.id.tv_rss_item_content);
            headerWrapper = itemView.findViewById(R.id.fl_rss_item_image_header);
            headerImage = (ImageView) headerWrapper.findViewById(R.id.iv_rss_item_image);
            archiveCheckbox = (CheckBox) itemView.findViewById(R.id.cb_item_rss_check_mark);
            favoriteCheckbox = (CheckBox) itemView.findViewById(R.id.cb_item_rss_favorite_star);
            itemView.setOnClickListener(this);
            archiveCheckbox.setOnCheckedChangeListener(this);
            favoriteCheckbox.setOnCheckedChangeListener(this);
        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            this.rssItem = rssItem;
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
            archiveCheckbox.setChecked(rssItem.isArchived());
            favoriteCheckbox.setChecked(rssItem.isFavorite());
            if (rssItem.getImageUrl() != null) {
                headerWrapper.setVisibility(View.VISIBLE);
                headerImage.setVisibility(View.INVISIBLE);
                ImageLoader.getInstance().loadImage(rssItem.getImageUrl(), this);
            } else {
                headerWrapper.setVisibility(View.GONE);
            }
        }
        /*
        *
        *
        *
        Image Loading Listener
        *
        *
        *
         */
        @Override
        public void onLoadingStarted(String imageUri, View view) {}

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            Throwable myThrowable = new Throwable();
            Log.e(TAG, "onLoadingFailed: " + failReason.toString() + " for URL: " + imageUri, myThrowable);
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (imageUri.equals(rssItem.getImageUrl())) {
                headerImage.setImageBitmap(loadedImage);
                headerImage.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onLoadingCancelled(String imageUri, View view) {
            ImageLoader.getInstance().loadImage(imageUri, this);
        }

        /*
        *
        *
        *
        On Click Listener
        *
        *
        *
         */

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), rssItem.getTitle(), Toast.LENGTH_SHORT).show();
        }

        /*
        *
        *
        *
        On Checked Changed Listener
        *
        *
        *
         */
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Log.v(TAG, "Checked changed to "+isChecked);
            if(buttonView.getId()==archiveCheckbox.getId()){
                rssItem.makeArchive(isChecked);
            }
            else
                rssItem.makeFavorite(isChecked);
        }
    }
}