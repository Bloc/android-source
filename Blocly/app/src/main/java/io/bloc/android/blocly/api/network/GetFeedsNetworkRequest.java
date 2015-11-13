package io.bloc.android.blocly.api.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Austin on 11/13/2015.
 */
public class GetFeedsNetworkRequest extends NetworkRequest{
    String [] feedUrls;

    public GetFeedsNetworkRequest(String... feedUrls){
        this.feedUrls = feedUrls;
    }

    @Override
    public Object performRequest(){
        for(String feedUrlString : feedUrls){
            InputStream inputStream = openStream(feedUrlString);
            if(inputStream == null){
                return null;
            }
            try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = bufferedReader.readLine();
                int lineNumber = 1;
                while(line != null){
                    Log.v(getClass().getSimpleName(), "Line: " + line);
                    Log.i(getClass().getSimpleName(), "Number of lines: " + lineNumber);git
                    line = bufferedReader.readLine();
                    lineNumber++;
                }
                bufferedReader.close();
            }catch(IOException e){
                e.printStackTrace();
                setErrorCode(ERROR_IO);
                return null;
            }
        }
        return null;
    }
}
