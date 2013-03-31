package com.example.ordrin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.ordrin.Location.LocationHelper;
import com.example.ordrin.Location.LocationHelperListener;
import com.example.ordrin.Models.Restaurants.DeliveryCheck;
import com.example.ordrin.Models.Restaurants.DeliveryList;
import com.example.ordrin.Models.Restaurants.Fee;
import com.example.ordrin.Models.Restaurants.RestaurantDetails;
import com.example.ordrin.Networking.RestNetworkingListener;
import com.example.ordrin.OrdrinApi.RestaurantManager;

import java.util.List;

public class MainActivity extends Activity {

    private TextView dateTime;
    private TextView zip;
    private TextView city;
    private TextView address;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dateTime = (TextView) findViewById(R.id.editText);
        zip = (TextView) findViewById(R.id.editText1);
        city = (TextView) findViewById(R.id.editText2);
        address = (TextView) findViewById(R.id.editText3);
    }

    public void searchRestaurants(View v) {
        if (checkInternet()) {
            RestaurantManager task = new RestaurantManager();
            task.setOrdrinNetworkingListener(new RestNetworkingListener() {
                @Override
                public void onNetworkingSuccess(Object result) {
                    if (result != null) {
                        showRestaurantPicker((DeliveryList[]) result);
                    }
                }

                @Override
                public void onNetworkingProgress(Integer... progress) {
                    Log.d("Network", "Progress");
                }
            });

            task.getRestaurantsList(dateTime.getText().toString(), zip.getText().toString(), city.getText().toString(), address.getText().toString());
        }
    }

    public void getLocation(View v) {
        LocationHelper locationHelper = new LocationHelper(this);
        locationHelper.setLocationListener(new LocationHelperListener() {

            @Override
            public void onLocationSuccess(List<Address> result) {
                if (result != null)
                {
                    showLocationPicker(result);
                }
            }
        });

        locationHelper.execute(29.750388,-95.370512);
    }

    private void showLocationPicker(final List<Address> result)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose location");

        final CharSequence[] locations = new String[result.size()];
        int i = 0;

        for (Address addressResult : result)
        {
            locations[i] = addressResult.getPostalCode() + " " + addressResult.getLocality() + " " + addressResult.getAddressLine(0);
            locations[i] = locations[i].toString().replaceAll("null", "");
            i++;
        }

        builder.setItems(locations, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which) {
                zip.setText(result.get(which).getPostalCode());
                city.setText(result.get(which).getLocality());
                address.setText(result.get(which).getAddressLine(0));
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showRestaurantPicker(final DeliveryList[] result)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose location");

        final CharSequence[] locations = new String[result.length];
        int i = 0;

        for (DeliveryList delivery :result)
        {
            locations[i] = delivery.getNa() + " " + delivery.getId();
            locations[i] = locations[i].toString().replaceAll("null","");
            i++;
        }

        builder.setItems(locations, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                getRestaurantDetails(result[which].getId());
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void getRestaurantDetails(Number restaurantId) {
        RestaurantManager task = new RestaurantManager();
        task.setOrdrinNetworkingListener(new RestNetworkingListener() {
            @Override
            public void onNetworkingSuccess(Object result) {
                if (result != null) {
                    Log.d("Network", "Name Details::" + ((RestaurantDetails) result).getName());
                }
            }

            @Override
            public void onNetworkingProgress(Integer... progress) {
            }
        });
        task.getRestaurantsDetails(String.valueOf(restaurantId));
    }

    public void deliveryCheck(View v) {
        RestaurantManager task = new RestaurantManager();
        task.setOrdrinNetworkingListener(new RestNetworkingListener() {
            @Override
            public void onNetworkingSuccess(Object result) {
                if (result != null) {
                    Log.d("Network", "Delivery Check::" + ((DeliveryCheck) result).getMsg());
                }
            }

            @Override
            public void onNetworkingProgress(Integer... progress) {
            }
        });
        task.deliveryCheck("143", dateTime.getText().toString(), zip.getText().toString(), city.getText().toString(), address.getText().toString());
    }

    public void getFee(View v) {
        RestaurantManager task = new RestaurantManager();
        task.setOrdrinNetworkingListener(new RestNetworkingListener() {
            @Override
            public void onNetworkingSuccess(Object result) {
                if (result != null) {
                    Log.d("Network", "Delivery Fee::" + ((Fee) result).getMsg());
                }
            }

            @Override
            public void onNetworkingProgress(Integer... progress) {
            }
        });
        task.getFee("143", "10.00", "3.00", dateTime.getText().toString(), zip.getText().toString(), city.getText().toString(), address.getText().toString());
    }

    private boolean checkInternet() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }


}
