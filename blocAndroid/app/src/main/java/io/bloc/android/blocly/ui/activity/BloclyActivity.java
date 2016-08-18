package io.bloc.android.blocly.ui.activity;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;
import io.bloc.android.blocly.ui.adapter.NavigationDrawerAdapter;

/**
 * Created by aadik_000 on 7/19/2016.
 */
public class BloclyActivity extends AppCompatActivity implements NavigationDrawerAdapter.NavigationDrawerAdapterDelegate, ItemAdapter.Delegate, ItemAdapter.DataSource {

    private ItemAdapter itemAdapter;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationDrawerAdapter navigationDrawerAdapter;
    private Menu menu;
    private View overflowButton;
    private RecyclerView recyclerView;
    private MenuItem actionShare;
    private boolean isShareShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_activity_blocly);
        setSupportActionBar(toolbar);
        itemAdapter = new ItemAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.rv_activity_blocly);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        isShareShown = false;
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_blocly);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0){
            @Override
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
                if(overflowButton!=null){
                    overflowButton.setAlpha(1f);
                    overflowButton.setEnabled(true);
                }
                if(menu==null)
                    return;
                for (int i = 0; i < menu.size(); i++){
                    menu.getItem(i).setEnabled(true);
                    if(menu.getItem(i).getIcon() != null)
                        menu.getItem(i).getIcon().setAlpha(255);
                }
            }

            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                if(overflowButton!=null)
                    overflowButton.setEnabled(false);
                if(menu == null)
                    return;
                for(int i = 0; i < menu.size(); i++){
                    menu.getItem(i).setEnabled(false);
                }
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (overflowButton == null) {
                    ArrayList<View> foundViews = new ArrayList<View>();
                    getWindow().getDecorView().findViewsWithText(foundViews,
                            getString(R.string.abc_action_menu_overflow_description),
                            View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
                    if (foundViews.size() > 0) {
                        overflowButton = foundViews.get(0);
                    }
                }
                if (overflowButton != null) {
                    overflowButton.setAlpha(1f - slideOffset);
                }
                if (menu == null) {
                    return;
                }
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    Drawable icon = item.getIcon();
                    if (icon != null) {
                        icon.setAlpha((int) ((1f - slideOffset) * 255));
                    }
                }
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.openDrawer(Gravity.LEFT);
        navigationDrawerAdapter = new NavigationDrawerAdapter();
        RecyclerView navRecyclerView = (RecyclerView) findViewById(R.id.rv_nav_activity_blocly);
        navRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        navRecyclerView.setItemAnimator(new DefaultItemAnimator());
        navRecyclerView.setAdapter(navigationDrawerAdapter);
        navigationDrawerAdapter.setDelegate(this);
        itemAdapter.setDelegate(this);
        itemAdapter.setDataSource(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (drawerToggle.onOptionsItemSelected(menuItem))
            return true;
        String toastStr = null;
        if(menuItem.getTitle().equals("Share"))
            toastStr = "I love to share!";
        else if(menuItem.getTitle().equals("Search"))
            toastStr = "Searching is fun!";
        else if (menuItem.getTitle().equals("Refresh"))
            toastStr = "Refresh it up…";
        else
            toastStr = "Mark 'em all!";
        Toast.makeText(this, toastStr, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.blocly, menu);
        Log.d(this.getClass().getSimpleName(), new Integer(menu.size()).toString());
        if (menu.size() > 0){
            menu.setGroupVisible(R.id.share_group, isShareShown);
    }
        return super.onCreateOptionsMenu(menu);
    }
    /*
    Delegate
     */
    @Override
    public void didSelectNavigationOption(NavigationDrawerAdapter adapter, NavigationDrawerAdapter.NavigationOption option) {
        drawerLayout.closeDrawers();
        Toast.makeText(this, "Show the " + option.name(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void didSelectRssFeed(NavigationDrawerAdapter adapter, RssFeed rssFeed) {
        drawerLayout.closeDrawers();
        Toast.makeText(this, "Show the " + rssFeed.getTitle(), Toast.LENGTH_SHORT).show();
    }
/*
*ItemAdapter.DataSource
 */
    @Override
    public RssItem getRssItem(ItemAdapter itemAdapter, int position) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase writableDatabase = new io.bloc.android.blocly.api.model.database.table.DatabaseOpenHelper().getWritableDatabase();
            }
        }.start());
        new io.bloc.android.blocly.api.model.database.table.RssFeedTable().query
        */
        BloclyApplication.getSharedDataSource().getWritableDatabase().query("rss_items", null, null, null, null, null, "pub_date", "10");
        if(position>=BloclyApplication.getSharedDataSource().getItems().size())
            position = 0;
        return BloclyApplication.getSharedDataSource().getItems().get(position);
    }

    @Override
    public RssFeed getRssFeed(ItemAdapter itemAdapter, int position) {
        if(position>=BloclyApplication.getSharedDataSource().getFeeds().size())
            position = 0;
        return BloclyApplication.getSharedDataSource().getFeeds().get(position);
    }

    @Override
    public int getItemCount(ItemAdapter itemAdapter) {
        return BloclyApplication.getSharedDataSource().getItems().size();
    }
/*
*ItemAdapter.Delegate
 */
    @Override
    public void onItemClicked(ItemAdapter itemAdapter, RssItem rssItem) {
        int positionToExpand = -1;
        int positionToContract = -1;
        if (itemAdapter.getExpandedItem() != null) {
            positionToContract = BloclyApplication.getSharedDataSource().getItems().indexOf(itemAdapter.getExpandedItem());
            if(recyclerView.getLayoutManager().findViewByPosition(positionToContract)==null){
                positionToContract = -1;
            }
        }
        if (itemAdapter.getExpandedItem() != rssItem) {
            positionToExpand = BloclyApplication.getSharedDataSource().getItems().indexOf(rssItem);
            itemAdapter.setExpandedItem(rssItem);
        } else {
            itemAdapter.setExpandedItem(null);
        }
        if (positionToContract > -1) {
            itemAdapter.notifyItemChanged(positionToContract);
            isShareShown = false;
            invalidateOptionsMenu();
        }
        if (positionToExpand > -1) {
            itemAdapter.notifyItemChanged(positionToExpand);
            isShareShown=true;
            menu.setGroupVisible(R.id.share_group, isShareShown);
        }
        else{
            return;
        }
        int lessToScroll = 0;
        if(positionToContract>-1 && positionToContract<positionToExpand)
            lessToScroll = itemAdapter.getExpandedItemHeight() - itemAdapter.getCollapsedItemHeight();
        if(positionToContract>-1 && positionToContract>positionToExpand){
            lessToScroll = 500;
        }
        recyclerView.smoothScrollBy(0, recyclerView.getLayoutManager().findViewByPosition(positionToExpand).getTop() - lessToScroll);
    }
}