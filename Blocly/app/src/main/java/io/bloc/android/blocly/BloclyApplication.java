package io.bloc.android.blocly;

import android.app.Application;

import io.bloc.android.blocly.api.DataSource;

/**
 * Created by Austin on 10/16/2015.
 */
    public class BloclyApplication extends Application {

        public static BloclyApplication getSharedInstance(){
            return sharedInstance;
        }

        public static DataSource getSharedDataSource() {
            return BloclyApplication.getSharedInstance().getDataSource();
        }

    private static BloclyApplication sharedInstance;
    private DataSource dataSource;

    // #3
        @Override
        public void onCreate() {
            super.onCreate();
            sharedInstance = this;
            dataSource = new DataSource();
        }

        public DataSource getDataSource() {
            return dataSource;
        }
    }


