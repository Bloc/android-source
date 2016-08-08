package io.bloc.android.blocly.ui.adapter;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.lang.ref.WeakReference;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.DataSource;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;


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

    public static interface ItemAdapterDelegate{
        public void itemExpand(ItemAdapter itemAdapter, View item);
        public void itemContract(ItemAdapter itemAdapter, View item);
        public void visitSite(ItemAdapter itemAdapter, View item);
        public void isFavorite(CompoundButton buttonView, boolean isFav);
        public void isArchived(CompoundButton buttonView, boolean isArchive);
    }

    WeakReference<ItemAdapterDelegate> delegate;

    public ItemAdapterDelegate getDelegate(){
        return delegate.get();
    }
    public void setDelegate(ItemAdapterDelegate d){
        delegate = new WeakReference<ItemAdapterDelegate>(d);
    }

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements ImageLoadingListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        boolean contentExpanded;
        TextView title;
        TextView feed;
        TextView content;
        View headerWrapper;
        ImageView headerImage;
        RssItem rssItem;
        CheckBox archiveCheckbox;
        CheckBox favoriteCheckbox;
        View expandedContentWrapper;
        TextView expandedContent;
        TextView visitSite;

        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_rss_item_title);
            feed = (TextView) itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = (TextView) itemView.findViewById(R.id.tv_rss_item_content);
            headerWrapper = itemView.findViewById(R.id.fl_rss_item_image_header);
            headerImage = (ImageView) headerWrapper.findViewById(R.id.iv_rss_item_image);
            archiveCheckbox = (CheckBox) itemView.findViewById(R.id.cb_item_rss_check_mark);
            favoriteCheckbox = (CheckBox) itemView.findViewById(R.id.cb_item_rss_favorite_star);
            expandedContentWrapper = itemView.findViewById(R.id.ll_rss_item_expanded_content_wrapper);
            expandedContent = (TextView) expandedContentWrapper.findViewById(R.id.tv_rss_item_content_full);
            visitSite = (TextView) expandedContentWrapper.findViewById(R.id.tv_rss_item_visit_site);

            itemView.setOnClickListener(this);
            archiveCheckbox.setOnCheckedChangeListener(this);
            favoriteCheckbox.setOnCheckedChangeListener(this);
            visitSite.setOnClickListener(this);
        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            this.rssItem = rssItem;
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
            expandedContent.setText(rssItem.getDescription());
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
            //Contract Image
            int startingHeight = headerImage.getMeasuredHeight();
            int finalHeight = 0;
            startAnimator(startingHeight, finalHeight, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    headerImage.getLayoutParams().height = animatedFraction == 1f ?
                            ViewGroup.LayoutParams.WRAP_CONTENT:
                            (Integer)valueAnimator.getAnimatedValue();
                    headerImage.requestLayout();
                    if(animatedFraction==1f){
                        headerImage.setVisibility(View.GONE);
                    }
                }
            });
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (imageUri.equals(rssItem.getImageUrl())) {
                headerImage.setImageBitmap(loadedImage);
                headerImage.setVisibility(View.VISIBLE);
            }
            //Expand Image
            headerImage.measure(View.MeasureSpec.makeMeasureSpec(headerWrapper.getWidth(), View.MeasureSpec.EXACTLY), ViewGroup.LayoutParams.WRAP_CONTENT);
            int startingHeight = headerImage.getMeasuredHeight();
            int finalHeight = startingHeight + 1000;
            startAnimator(startingHeight, finalHeight, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    headerImage.getLayoutParams().height = (Integer)valueAnimator.getAnimatedValue();
                    headerImage.requestLayout();
                }
            });
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
            if (v == itemView) {
                animateContent(!contentExpanded);

            if (contentExpanded) {
                getDelegate().itemExpand(ItemAdapter.this, v);
            } else {
                getDelegate().itemContract(ItemAdapter.this, v);
            }} else{
                Toast.makeText(v.getContext(), "Visit " + rssItem.getUrl(), Toast.LENGTH_SHORT).show();
                getDelegate().visitSite(ItemAdapter.this, v);
            }
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
                getDelegate().isArchived(buttonView, isChecked);
            }
            else
                rssItem.makeFavorite(isChecked);
                getDelegate().isFavorite(buttonView, isChecked);
        }

        /*
        *
        *
        *
        * Private Methods
        *
        *
        *
         */
        private void animateContent(final boolean expand){
            if((expand&&contentExpanded)||(!expand&&!contentExpanded)){
                return;
            }
            int startingHeight = expandedContentWrapper.getMeasuredHeight();
            int finalHeight = content.getMeasuredHeight();
            if(expand){
                startingHeight = finalHeight;
                expandedContentWrapper.setAlpha(0f);
                expandedContentWrapper.setVisibility(View.VISIBLE);
                expandedContentWrapper.measure(View.MeasureSpec.makeMeasureSpec(content.getWidth(), View.MeasureSpec.EXACTLY), ViewGroup.LayoutParams.WRAP_CONTENT);
                finalHeight = expandedContentWrapper.getMeasuredHeight();
            }
            else{
                content.setVisibility(View.VISIBLE);
            }
            startAnimator(startingHeight, finalHeight, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    float wrapperAlpha = expand ? animatedFraction : 1f - animatedFraction;
                    float contentAlpha = 1f - wrapperAlpha;
                    expandedContentWrapper.setAlpha(wrapperAlpha);
                    content.setAlpha(contentAlpha);
                    expandedContentWrapper.getLayoutParams().height = animatedFraction == 1f ?
                            ViewGroup.LayoutParams.WRAP_CONTENT:
                            (Integer)valueAnimator.getAnimatedValue();
                    expandedContentWrapper.requestLayout();
                    if(animatedFraction==1f){
                        if(expand){
                            content.setVisibility(View.GONE);
                        }
                        else
                            expandedContentWrapper.setVisibility(View.GONE);
                    }
                }
            });
            contentExpanded = expand;
        }

        private void startAnimator(int start, int end, ValueAnimator.AnimatorUpdateListener animatorUpdateListener){
            ValueAnimator valueAnimator = ValueAnimator.ofInt(start, end);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.setDuration(itemView.getResources().getInteger(android.R.integer.config_mediumAnimTime));
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.start();
        }
    }
}