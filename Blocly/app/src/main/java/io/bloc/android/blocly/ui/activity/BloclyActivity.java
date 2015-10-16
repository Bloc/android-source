package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.bloc.android.blocly.R;

/**
 * Created by Austin on 10/15/2015.
 */
public class BloclyActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
        Button eyo = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.hullo);
        eyo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText("this is a string");
            }
        });
    }
}

