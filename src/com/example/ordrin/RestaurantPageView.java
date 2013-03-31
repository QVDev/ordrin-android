package com.example.ordrin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ordrin.Models.Restaurants.DeliveryList;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/31/13
 * Time: 7:06 PM
 */
public class RestaurantPageView extends Fragment
{
    private DeliveryList restaurant;
    private TextView restaurantName;

    public RestaurantPageView(DeliveryList restaurant)
    {
        this.restaurant = restaurant;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.restaurant_page, container, false);

        setRestaurantDetails(rootView);

        return rootView;
    }

    private void setRestaurantDetails(ViewGroup rootView)
    {
        this.restaurantName = (TextView) rootView.findViewById(R.id.restaurantName);
        restaurantName.setText(this.restaurant.getNa());
    }
}
