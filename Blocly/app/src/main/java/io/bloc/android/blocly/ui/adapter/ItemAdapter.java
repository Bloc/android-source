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
 * Created by Austin on 10/19/2015.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    //log message location for image loader
    private static String TAG = ItemAdapter.class.getSimpleName();

    public ItemAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int index){
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_item, viewGroup, false);
        return new ItemAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ItemAdapterViewHolder itemAdapterViewHolder, int index) {
        DataSource sharedDataSource = BloclyApplication.getSharedDataSource();
        itemAdapterViewHolder.update(sharedDataSource.getFeeds().get(0), sharedDataSource.getItems().get(index));
    }

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
        CheckBox archiveCheckBox;
        CheckBox favoriteCheckBox;

        public ItemAdapterViewHolder(View itemView) {

            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_rss_item_title);
            feed = (TextView) itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = (TextView) itemView.findViewById(R.id.tv_rss_item_content);
            headerWrapper = itemView.findViewById(R.id.fl_rss_item_image_header);
            headerImage = (ImageView) headerWrapper.findViewById(R.id.iv_rss_item_image);
            archiveCheckBox = (CheckBox) itemView.findViewById(R.id.cb_rss_item_check_mark);
            favoriteCheckBox = (CheckBox) itemView.findViewById(R.id.cb_rss_item_favorite_star);
            itemView.setOnClickListener(this);
            archiveCheckBox.setOnCheckedChangeListener(this);
            favoriteCheckBox.setOnCheckedChangeListener(this);
        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            this.rssItem = rssItem;
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
            if(rssItem.getImageUrl() != null){
                headerWrapper.setVisibility(View.VISIBLE);
                headerImage.setVisibility(View.INVISIBLE);
                ImageLoader.getInstance().loadImage(rssItem.getImageUrl(), this);
            }else{
                headerWrapper.setVisibility(View.GONE);
            }
        }

        @Override
        public void onLoadingStarted(String imageUri, View view){

        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason){
            Log.e(TAG, "Error on loading: ", failReason.getCause());
        }

        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage){
            if(imageUri.equals(rssItem.getImageUrl())){
                headerImage.setImageBitmap(loadedImage);
                headerImage.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public void onLoadingCancelled(String imageUri, View view){
            ImageLoader.getInstance().loadImage(imageUri, this);
        }

        @Override
        public void onClick(View view){
            Toast.makeText(view.getContext(), rssItem.getTitle(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            Log.v(TAG, "Checked changed to:" + isChecked);
        }
    }
}
