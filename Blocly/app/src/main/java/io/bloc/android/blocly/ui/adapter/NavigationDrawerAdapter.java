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
 * Created by Austin on 11/3/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder>{

    public enum NavigationOption{
        NAVIGATION_OPTION_INBOX,
        NAVIGATION_OPTION_FAVORITES,
        NAVIGATION_OPTION_ARCHIVED
    }

    public interface NavigationDrawerAdapterDelegate{
        void didSelectNavigationOption(NavigationDrawerAdapter adapter, NavigationOption navigationOption);
        void didSelectFeed(NavigationDrawerAdapter adapter, RssFeed rssFeed);
        void printText(View v, String s);
    }

    WeakReference<NavigationDrawerAdapterDelegate> delegate;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position){
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.navigation_item,viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        RssFeed rssFeed = null;
        if(position >= NavigationOption.values().length){
            int feedPosition = position - NavigationOption.values().length;
            rssFeed = BloclyApplication.getSharedDataSource().getFeeds().get(feedPosition);
        }
        viewHolder.update(position,rssFeed);
    }

    @Override
    public int getItemCount(){
        return NavigationOption.values().length
        + BloclyApplication.getSharedDataSource().getFeeds().size();
    }

    public NavigationDrawerAdapterDelegate getDelegate(){
        if(delegate.get() == null) {
            return null;
        }else{
            return delegate.get();
        }
    }

    public void setDelegate(NavigationDrawerAdapterDelegate delegate) {
        this.delegate = new WeakReference<NavigationDrawerAdapterDelegate>((NavigationDrawerAdapterDelegate) delegate);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        View topPadding;
        TextView title;
        View bottomPadding;
        View divider;
        NavigationDrawerAdapterDelegate delegate = getDelegate();

        int position;
        RssFeed rssFeed;

        public ViewHolder(View itemView){
            super(itemView);
            topPadding = itemView.findViewById(R.id.v_nav_item_top_padding);
            title = (TextView) itemView.findViewById(R.id.tv_nav_item_title);
            bottomPadding = itemView.findViewById(R.id.v_nav_item_bottom_padding);
            divider = itemView.findViewById(R.id.v_nav_item_divider);
            itemView.setOnClickListener(this);
        }

        void update(int position, RssFeed rssFeed) {
            this.position = position;
            this.rssFeed = rssFeed;

            boolean shouldShowTopPadding = position == NavigationOption.NAVIGATION_OPTION_INBOX.ordinal()
                    || position == NavigationOption.values().length;
            topPadding.setVisibility(shouldShowTopPadding ? View.VISIBLE : View.GONE);

            boolean shouldShowBottomPadding = position == NavigationOption.NAVIGATION_OPTION_ARCHIVED.ordinal()
                    || position == getItemCount() - 1;
            bottomPadding.setVisibility(shouldShowBottomPadding ? View.VISIBLE : View.GONE);

            divider.setVisibility(position == NavigationOption.NAVIGATION_OPTION_ARCHIVED.ordinal()
                    ? View.VISIBLE : View.GONE);

            if (position < NavigationOption.values().length) {
                // #5
                int[] titleTexts = new int[] {R.string.navigation_option_inbox,
                        R.string.navigation_option_favorites,
                        R.string.navigation_option_archived};
                title.setText(titleTexts[position]);
            } else {
                title.setText(rssFeed.getTitle());
            }
        }

        public void onClick(View v){
            delegate.printText(v, "Hullo");
            if(getDelegate() == null){
                return;
            }
            if(position < NavigationOption.values().length){
                getDelegate().didSelectNavigationOption(NavigationDrawerAdapter.this,
                        NavigationOption.values()[position]);
            }
        }

    }

}
