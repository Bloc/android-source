package io.bloc.android.blocly.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.DataSource;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;

/**
 * Created by tonyk_000 on 6/2/2015.
 */
public class RssItemListFragment extends Fragment implements ItemAdapter.DataSource, ItemAdapter.Delegate {

    // #10 - stores and retrieves RSS feed's identifier from the bundle
    private static final String BUNDLE_EXTRA_RSS_FEED = RssItemListFragment.class.getCanonicalName().concat(".EXTRA_RSS_FEED");

    // #11
    public static RssItemListFragment fragmentForRssFeed(RssFeed rssFeed) {
        Bundle arguments = new Bundle();
        arguments.putLong(BUNDLE_EXTRA_RSS_FEED, rssFeed.getRowId());
        RssItemListFragment rssItemListFragment = new RssItemListFragment();
        rssItemListFragment.setArguments(arguments);
        return rssItemListFragment;
    }

    // #4
    public static interface Delegate {
        public void onItemExpanded(RssItemListFragment rssItemListFragment, RssItem rssItem);
        public void onItemContracted(RssItemListFragment rssItemListFragment, RssItem rssItem);
        public void onItemVisitClicked(RssItemListFragment rssItemListFragment, RssItem rssItem);
    }

    // #5
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    private RssFeed currentFeed;
    private List<RssItem> currentItems = new ArrayList<RssItem>();

    private WeakReference<Delegate> delegate;

    @Override
    //notifies the fragment of its new owner
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // #6 - assign this activity as our delegate reference
        delegate = new WeakReference<Delegate>((Delegate) activity);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemAdapter = new ItemAdapter();
        itemAdapter.setDataSource(this);
        itemAdapter.setDelegate(this);

        // #12
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        long feedRowId = arguments.getLong(BUNDLE_EXTRA_RSS_FEED);
        BloclyApplication.getSharedDataSource().fetchFeedWithId(feedRowId, new DataSource.Callback<RssFeed>() {
            @Override
            public void onSuccess(RssFeed rssFeed) {
                currentFeed = rssFeed;
            }

            @Override
            public void onError(String errorMessage) {}
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_rss_list, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.srl_fragment_rss_list);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_fragment_rss_list);
        return inflate;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.primary));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // #7
                BloclyApplication.getSharedDataSource().fetchNewItemsForFeed(currentFeed,
                        new DataSource.Callback<List<RssItem>>() {
                            @Override
                            public void onSuccess(List<RssItem> rssItems) {
                                if (getActivity() == null) {
                                    return;
                                }
                                // #8
                                if (!rssItems.isEmpty()) {
                                    currentItems.addAll(0, rssItems);
                                    itemAdapter.notifyItemRangeInserted(0, rssItems.size());
                                }
                                swipeRefreshLayout.setRefreshing(false);
                            }

                            @Override
                            public void onError(String errorMessage) {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);
    }
     /*
      * ItemAdapter.DataSource
      */

    @Override
    public RssItem getRssItem(ItemAdapter itemAdapter, int position) {
        return currentItems.get(position);
    }

    @Override
    public RssFeed getRssFeed(ItemAdapter itemAdapter, int position) {
        return currentFeed;
    }

    @Override
    public int getItemCount(ItemAdapter itemAdapter) {
        return currentItems.size();
    }

    /*
      * ItemAdapter.Delegate
      */

    @Override
    public void onItemClicked(ItemAdapter itemAdapter, RssItem rssItem) {
        int positionToExpand = -1;
        int positionToContract = -1;
        if (itemAdapter.getExpandedItem() != null) {
            positionToContract = currentItems.indexOf(itemAdapter.getExpandedItem());
            View viewToContract = recyclerView.getLayoutManager().findViewByPosition(positionToContract);
            if (viewToContract == null) {
                positionToContract = -1;
            }
        }
        if (itemAdapter.getExpandedItem() != rssItem) {
            positionToExpand = currentItems.indexOf(rssItem);
            itemAdapter.setExpandedItem(rssItem);
        } else {
            itemAdapter.setExpandedItem(null);
        }
        if (positionToContract > -1) {
            itemAdapter.notifyItemChanged(positionToContract);
        }
        if (positionToExpand > -1) {
            itemAdapter.notifyItemChanged(positionToExpand);
            // #9a
            delegate.get().onItemExpanded(this, itemAdapter.getExpandedItem());
        } else {
            // #9b
            delegate.get().onItemContracted(this, rssItem);
            return;
        }
        View viewToExpand = recyclerView.getLayoutManager().findViewByPosition(positionToExpand);
        int lessToScroll = 0;
        if (positionToContract > -1 && positionToContract < positionToExpand) {
            lessToScroll = itemAdapter.getExpandedItemHeight() - itemAdapter.getCollapsedItemHeight();
        }
        recyclerView.smoothScrollBy(0, viewToExpand.getTop() - lessToScroll);
    }

    @Override
    public void onVisitClicked(ItemAdapter itemAdapter, RssItem rssItem) {
        // #9c
        delegate.get().onItemVisitClicked(this, rssItem);
    }
}
