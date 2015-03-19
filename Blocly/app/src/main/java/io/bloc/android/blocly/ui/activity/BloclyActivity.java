package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.bloc.android.blocly.R;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;

/**
 * Created by ReneeCS on 3/17/15.
 */
public class BloclyActivity extends Activity {

//    public TextView mAppTitle;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);

//        Toast.makeText(this,
//                BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle(),
//                Toast.LENGTH_LONG).show();

        itemAdapter = new ItemAdapter();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_activity_blocly);
// #12
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);

//        TextView mAppTitle = (TextView) findViewById(R.id.appTitle);
//        mAppTitle.setText(R.string.app_title);
    }
}
