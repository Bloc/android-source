package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;

/**
 * Created by Austin on 10/15/2015.
 */
public class BloclyActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);

        Toast.makeText(this,
                BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle(),
                Toast.LENGTH_LONG).show();

        Button rssFeed = (Button) findViewById(R.id.rssbutton);

        final TextView textView = (TextView) findViewById(R.id.helloworld);

        rssFeed.setOnClickListener(new View.OnClickListener(){
            String rssTitle = (BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle());
            @Override
            public void onClick(View v) {
                textView.setText(rssTitle);
            }
        });
    }
}

