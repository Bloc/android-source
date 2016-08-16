package io.bloc.android.blocly.api.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by aadik_000 on 8/16/2016.
 */
public class GetFeedsNetworkRequest extends NetworkRequest{

    String[] feedUrls;

    public GetFeedsNetworkRequest(String... feedUrls){
        this.feedUrls = feedUrls;
    }

    @Override
    public Object performRequest() {
        for (String feedUrlString : feedUrls) {
            InputStream inputStream = openStream(feedUrlString);
            if (inputStream == null) {
                return null;
            }
            int numItems = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = bufferedReader.readLine();
                while (line != null) {
                    if(line.length()>5 && line.substring(0,5).equals("<?xml")){
                        numItems++;
                    }
                    Log.v(getClass().getSimpleName(), "Line: " + line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                Log.v(this.getClass().getSimpleName(), "Number of Items: " + numItems);
            } catch (IOException e) {
                e.printStackTrace();
                setErrorCode(ERROR_IO);
                return null;
            }
        }
        return null;
    }
}
