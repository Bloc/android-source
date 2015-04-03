package io.bloc.android.blocly.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.model.RssFeed;

/**
 * Created by tonyk_000 on 4/2/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {
    public enum NavigationOption {
        NAVIGATION_OPTION_INBOX,
        NAVIGATION_OPTION_FAVORITES,
        NAVIGATION_OPTION_ARCHIVED
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.navigation_item, viewGroup, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
            RssFeed rssFeed = null;

            if(position>= NavigationOption.values().length){
                int feedPosition = position - NavigationOption.values().length;
                rssFeed = BloclyApplication.getSharedDataSource().getFeeds().get(feedPosition);
            }
        viewHolder.update(position,rssFeed);
    }

    @Override
    public int getItemCount() {
        return NavigationOption.values().length +
                BloclyApplication.getSharedDataSource().getFeeds().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View topPadding;
        TextView title;
        View bottomPadding;
        View divider;


        public ViewHolder(View itemView) {
            super(itemView);
            topPadding = (View) itemView.findViewById(R.id.v_nav_item_top_padding);
            title = (TextView) itemView.findViewById(R.id.tv_nav_item_title);
            bottomPadding = (View) itemView.findViewById(R.id.v_nav_item_bottom_padding);
            divider = (View) itemView.findViewById(R.id.v_nav_item_divider);
            itemView.setOnClickListener(this);
        }

        void update(int position, RssFeed rssFeed){
           boolean shouldShowTopPadding = position == NavigationOption.NAVIGATION_OPTION_INBOX.ordinal()
                   || position == NavigationOption.values().length;
            topPadding.setVisibility(shouldShowTopPadding ? View.VISIBLE : View.GONE);

           boolean shouldShowBottomPadding = position == NavigationOption.NAVIGATION_OPTION_ARCHIVED.ordinal()
                   || position == getItemCount();
            bottomPadding.setVisibility(shouldShowBottomPadding ? View.VISIBLE : View.GONE);

            divider.setVisibility(position == NavigationOption.NAVIGATION_OPTION_ARCHIVED.ordinal()
                    ? View.VISIBLE : View.GONE);

            if (position < NavigationOption.values().length){
                int [] titleTexts = new int[] {R.string.navigation_option_inbox,
                R.string.navigation_option_favorites,
                R.string.navigation_option_archived};

                title.setText(titleTexts[position]);
            } else {
                title.setText(rssFeed.getTitle());
            }


        }
         /*
          * OnClickListener
          */

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Nothing… yet!", Toast.LENGTH_SHORT).show();
        }
    }
}
