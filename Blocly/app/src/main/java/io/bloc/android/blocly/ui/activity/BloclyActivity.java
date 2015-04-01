package io.bloc.android.blocly.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import io.bloc.android.blocly.R;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;

/**
 * Created by ReneeCS on 3/17/15.
 */
public class BloclyActivity extends ActionBarActivity {

    private ItemAdapter itemAdapter;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

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


// #5
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_blocly);
// #6
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        drawerLayout.setDrawerListener(drawerToggle);

    }


    // #7a
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    // #7b
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    // #7c
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

