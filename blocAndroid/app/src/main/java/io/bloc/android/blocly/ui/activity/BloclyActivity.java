package io.bloc.android.blocly.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import io.bloc.android.blocly.R;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;
import io.bloc.android.blocly.ui.adapter.NavigationDrawerAdapter;

/**
 * Created by aadik_000 on 7/19/2016.
 */
public class BloclyActivity extends AppCompatActivity implements View.OnClickListener {

    private ItemAdapter itemAdapter;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationDrawerAdapter navigationDrawerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_activity_blocly);
        setSupportActionBar(toolbar);
        itemAdapter = new ItemAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_activity_blocly);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_blocly);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.openDrawer(Gravity.LEFT);
        navigationDrawerAdapter = new NavigationDrawerAdapter();
        RecyclerView navRecyclerView = (RecyclerView) findViewById(R.id.rv_nav_activity_blocly);
        navRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        navRecyclerView.setItemAnimator(new DefaultItemAnimator());
        navRecyclerView.setAdapter(navigationDrawerAdapter);
        if (navigationDrawerAdapter.getView() != null) {
            navigationDrawerAdapter.getView().setOnClickListener(navigationDrawerAdapter.getNavHolder());
        }
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
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onClick(View v) {
        navigationDrawerAdapter.getNavHolder().onClick(navigationDrawerAdapter.getView());
    }
}