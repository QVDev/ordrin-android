package com.example.ordrin.Networking;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/28/13
 * Time: 11:13 AM
 * <p/>
 * Base for Network communication with REST API's
 */
public class RestNetworking extends AsyncTask<RequestBuilder, Integer, Object> {

    private final static String LOG_TAG_NETWORK_DEBUG = "NETWORK_DEBUG";
    private final static boolean IN_DEBUG = true;

    private RestNetworkingListener listener;

    private URL url = null;
    private HttpsURLConnection urlConnection = null;

    /**
     * Set the networking listener for catching events
     *
     * @param listener
     */
    public void setOrdrinNetworkingListener(RestNetworkingListener listener) {
        this.listener = listener;
    }

    /**
     * This will execute the request and create the matching object
     *
     * @param params API url
     * @return urlconnection response as a String
     */
    @Override
    protected Object doInBackground(RequestBuilder... params) {
        String responseString = null;
        Object responseObject = null;

        try {
            this.url = new URL(params[0].url);
        } catch (MalformedURLException e) {
            debugPrint(e.getMessage());
        }

        if (urlConnection == null) {
            try {
                urlConnection = (HttpsURLConnection) this.url.openConnection();
                urlConnection.setRequestMethod(params[0].requestMethod);
                for(int i = 0; i < params[0].headers.length; i++)
                {
                    urlConnection.setRequestProperty(params[0].headers[i], params[0].headers[i+1]);
                    i++;
                }
                urlConnection.setUseCaches(true);
            } catch (IOException e) {
                debugPrint(e.getMessage());
            }
        }

        try {
            debugPrint(urlConnection.getURL().toString());
            debugPrint(urlConnection.getRequestProperties().toString());
            responseString = generateStringResponse(urlConnection.getInputStream());
        } catch (IOException e) {
            debugPrint(e.getMessage());
        } finally {
            urlConnection.disconnect();
        }


        try {
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                Gson gson = new Gson();
                responseObject = gson.fromJson(responseString, params[0].classMap);
            }
            else
            {
                debugPrint("Response::" + urlConnection.getResponseCode());
            }
        }
        catch (Exception e) {
            debugPrint(e.getMessage());
        }

        return responseObject;
    }

    /**
     * This will create a String from the url response this can be used for further processing
     *
     * @param in Inputstream from url connection
     * @return response in String
     * @throws IOException
     */
    private String generateStringResponse(InputStream in) throws IOException {
        String response;

        StringBuffer sb = new StringBuffer();
        int chr;
        while ((chr = in.read()) != -1) {
            sb.append((char) chr);
        }
        in.close();
        response = sb.toString();

        debugPrint(response);

        return response;
    }

    private void debugPrint(String message)
    {
        if(IN_DEBUG)
        {
            Log.d(LOG_TAG_NETWORK_DEBUG, message);
        }
    }

    /**
     * Perfom action before the request will be executed
     */
    @Override
    protected void onPreExecute() {

    }

    /**
     * This will get progress
     *
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        listener.onNetworkingProgress(values);
    }

    /**
     * Request successfully executed delivering the result
     *
     * @param result
     */
    @Override
    protected void onPostExecute(Object result) {
        listener.onNetworkingSuccess(result);
    }
}
