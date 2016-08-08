package io.bloc.android.blocly.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.model.RssFeed;

/**
 * Created by aadik_000 on 8/8/2016.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.NavigationDrawerViewHolder> {

    public enum NavigationOption {
        NAVIGATION_OPTION_INBOX,
        NAVIGATION_OPTION_FAVORITES,
        NAVIGATION_OPTION_ARCHIVED
    }

    public static interface NavigationDrawerAdapterDelegate{
        public void didSelectNavigationOption(NavigationDrawerAdapter adapter, NavigationOption option);
        public void didSelectRssFeed(NavigationDrawerAdapter adapter, RssFeed rssFeed);
    }

    WeakReference<NavigationDrawerAdapterDelegate> delegate;

    @Override
    public NavigationDrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item, parent, false);
        return new NavigationDrawerViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(NavigationDrawerViewHolder holder, int position) {
        RssFeed rssFeed = null;
        if(position>=NavigationOption.values().length) {
            rssFeed = BloclyApplication.getSharedDataSource().getFeeds().get(position - NavigationOption.values().length);
        }
        holder.update(position, rssFeed);
    }

    @Override
    public int getItemCount() {
        return NavigationOption.values().length + BloclyApplication.getSharedDataSource().getFeeds().size();
    }

    public NavigationDrawerAdapterDelegate getDelegate(){
        if(delegate == null){
            return null;
        }
        return delegate.get();
    }

    public void setDelegate(NavigationDrawerAdapterDelegate d){
        delegate = new WeakReference<NavigationDrawerAdapterDelegate>(d);
    }

    public class NavigationDrawerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        View topPadding;
        TextView title;
        View bottomPadding;
        View divider;
        int position;
        RssFeed rssFeed;

        public NavigationDrawerViewHolder(View itemView) {
            super(itemView);
            topPadding = (View) itemView.findViewById(R.id.v_nav_item_top_padding);
            title = (TextView) itemView.findViewById(R.id.tv_nav_item_title);
            bottomPadding = (View) itemView.findViewById(R.id.v_nav_item_bottom_padding);
            divider = (View) itemView.findViewById(R.id.v_nav_item_divider);
            itemView.setOnClickListener(this);
        }


        public void update(int position, RssFeed rssFeed){
            this.position = position;
            this.rssFeed = rssFeed;
            boolean shouldShowTopPadding = position == NavigationOption.NAVIGATION_OPTION_INBOX.ordinal() || position == NavigationOption.values().length;
            topPadding.setVisibility(shouldShowTopPadding ? View.VISIBLE : View.GONE);

            boolean shouldShowBottomPadding = position == NavigationOption.NAVIGATION_OPTION_ARCHIVED.ordinal() || position == getItemCount()  - 1;
            bottomPadding.setVisibility(shouldShowBottomPadding ? View.VISIBLE : View.GONE);

            divider.setVisibility(position == NavigationOption.NAVIGATION_OPTION_ARCHIVED.ordinal() ? View.VISIBLE : View.GONE);
            if(position<NavigationOption.values().length){
                int[] stringInts = {R.string.inbox, R.string.favorites, R.string.archived};
                title.setText(stringInts[position]);
            }
            else{
                title.setText(rssFeed.getTitle());
            }
        }

        /*
        *OnClickListener
         */
        @Override
        public void onClick(View v) {
            if(delegate.get() == null){
                return;
            }
            if(position<NavigationOption.values().length){
                getDelegate().didSelectNavigationOption(NavigationDrawerAdapter.this, NavigationOption.values()[position]);
            }
            else{
                getDelegate().didSelectRssFeed(NavigationDrawerAdapter.this, rssFeed);
            }
        }
    }
}
