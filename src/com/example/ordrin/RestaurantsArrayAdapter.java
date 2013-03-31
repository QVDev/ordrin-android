package com.example.ordrin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.ordrin.Models.Restaurants.DeliveryList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/31/13
 * Time: 4:54 PM
 */
public class RestaurantsArrayAdapter extends ArrayAdapter
{
    private List<DeliveryList> restaurants;
    private Context context;

    public RestaurantsArrayAdapter(Context context, int restaurantResourceId, List<DeliveryList> restaurants)
    {
        super(context, restaurantResourceId, restaurants);

        this.context = context;
        this.restaurants = restaurants;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        // Keeps reference to avoid future findViewById()
        RestaurantsViewHolder viewHolder;

        if(v == null)
        {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(
                    context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.restaurant_page, parent, false);

            viewHolder = new RestaurantsViewHolder();
            viewHolder.restaurantName = (TextView) v.findViewById(R.id.restaurantName);

            v.setTag(viewHolder);
        }
        else
        {
            viewHolder = (RestaurantsViewHolder) v.getTag();
        }

        DeliveryList restaurant = restaurants.get(position);
        if (restaurant != null) {
            viewHolder.restaurantName.setText(restaurant.getNa());
            v.setBackgroundColor(android.R.color.holo_red_light);
        }

        return v;
    }

    public void setRestaurants(List<DeliveryList> restaurants)
    {
        this.clear();
        this.addAll(restaurants);
        this.notifyDataSetChanged();
    }

    static class RestaurantsViewHolder
    {
        TextView restaurantName;
    }
}
