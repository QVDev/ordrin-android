package com.example.ordrin;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import com.example.ordrin.Models.Restaurants.DeliveryList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/31/13
 * Time: 7:05 PM
 */
public class RestaurantsPageViewAdapter extends FragmentStatePagerAdapter {

    private List<DeliveryList> restaurants = new ArrayList<DeliveryList>();

    public RestaurantsPageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new RestaurantPageView(restaurants.get(i));
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    public void setRestaurants(List<DeliveryList> restaurants)
    {
        this.restaurants = restaurants;
        this.notifyDataSetChanged();
    }
}
