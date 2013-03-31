package com.example.ordrin.Location;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/28/13
 * Time: 3:56 PM
 */
public class LocationHelper extends AsyncTask<Double, Integer, List<Address>>
{
    private LocationHelperListener listener;
    private final Context context;

    public LocationHelper(Context context)
    {
        this.context = context;
    }

    public void setLocationListener(LocationHelperListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected List<Address> doInBackground(Double... latlng)
    {

        Geocoder geocoder = new Geocoder(context);
        try {
            return geocoder.getFromLocation(latlng[0], latlng[1], 10);

        } catch (IOException e) {
            Log.d("Network", e.getMessage());
            return null;
        }
    }

    protected void onProgressUpdate(Integer... progress)
    {

    }

    protected void onPostExecute(List<Address> result)
    {
        listener.onLocationSuccess(result);
    }
}
