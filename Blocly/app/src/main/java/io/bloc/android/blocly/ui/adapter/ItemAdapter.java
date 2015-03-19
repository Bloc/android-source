package io.bloc.android.blocly.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.DataSource;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;

/**
 * Created by ReneeCS on 3/18/15.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

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

    // #9
    class ItemAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView feed;
        TextView content;

        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
// #10
            title = (TextView) itemView.findViewById(R.id.tv_rss_item_title);
            feed = (TextView) itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = (TextView) itemView.findViewById(R.id.tv_rss_item_content);
        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
        }
    }


}

