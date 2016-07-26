package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;

/**
 * Created by aadik_000 on 7/19/2016.
 */
public class BloclyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
        Toast.makeText(this,
                BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle(),
                Toast.LENGTH_LONG).show();
        TextView modelName = (TextView)findViewById(R.id.hello_world);
        modelName.setText(BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle());
    }
}
