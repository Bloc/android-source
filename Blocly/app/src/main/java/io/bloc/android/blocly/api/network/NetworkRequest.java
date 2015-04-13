package io.bloc.android.blocly.api.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ReneeCS on 4/12/15.
 */
public abstract class NetworkRequest<Result> {

    public static final int ERROR_IO = 1;
    public static final int ERROR_MALFORMED_URL = 2;

    private int errorCode;

    protected void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public abstract Result performRequest();

    protected InputStream openStream(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            setErrorCode(ERROR_MALFORMED_URL);
            return null;
        }
        InputStream inputStream = null;
        try {
            inputStream = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
            setErrorCode(ERROR_IO);
            return null;
        }
        return inputStream;
    }

    public static class GetFeedsNetworkRequest extends NetworkRequest {

        String[] feedUrls;

        public GetFeedsNetworkRequest(String... feedUrls) {
            this.feedUrls = feedUrls;
        }

        @Override
        public Object performRequest() {
            for (String feedUrlString : feedUrls) {
                InputStream inputStream = openStream(feedUrlString);
                if (inputStream == null) {
                    return null;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        Log.v(getClass().getSimpleName(), "Line: " + line);
                        line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    setErrorCode(ERROR_IO);
                    return null;
                }
            }
            return null;
        }
    }
}