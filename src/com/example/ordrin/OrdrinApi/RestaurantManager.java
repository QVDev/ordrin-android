package com.example.ordrin.OrdrinApi;

import android.net.Uri;
import com.example.ordrin.Networking.RequestBuilder;
import com.example.ordrin.Networking.RestNetworking;
import com.example.ordrin.Models.Restaurants.DeliveryCheck;
import com.example.ordrin.Models.Restaurants.DeliveryList;
import com.example.ordrin.Models.Restaurants.Fee;
import com.example.ordrin.Models.Restaurants.RestaurantDetails;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/28/13
 * Time: 11:26 AM
 * <p/>
 * This is a wrapper around the RestNetworking class specially made for Ordr.in Restaurants API
 */
public class RestaurantManager extends RestNetworking {

    /**
     * Generates url and execute the request
     *
     * @param dateTime
     * @param zip
     * @param city
     * @param address
     */
    public void getRestaurantsList(String dateTime, String zip, String city, String address) {
        String requestURL = String.format("https://r-test.ordr.in/dl/%s/%s/%s/%s",
                Uri.encode(dateTime),
                Uri.encode(zip),
                Uri.encode(city),
                Uri.encode(address));

        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.url = requestURL;
        requestBuilder.requestMethod = "GET";
        requestBuilder.classMap = DeliveryList[].class;
        setStandarRequestHeader(requestBuilder);

        execute(requestBuilder);
    }

    /**
     *
     * @param restaurantId
     */
    public void getRestaurantsDetails(String restaurantId)
    {
        String requestURL = String.format("https://r-test.ordr.in/rd/%s",
                Uri.encode(restaurantId));

        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.url = requestURL;
        requestBuilder.requestMethod = "GET";
        requestBuilder.classMap = RestaurantDetails.class;
        setStandarRequestHeader(requestBuilder);

        execute(requestBuilder);
    }

    /**
     *
     * @param restaurantId
     * @param dateTime
     * @param zip
     * @param city
     * @param address
     */
    public void deliveryCheck(String restaurantId, String dateTime, String zip, String city, String address)
    {
        String requestURL = String.format("https://r-test.ordr.in/dc/%s/%s/%s/%s/%s",
                Uri.encode(restaurantId),
                Uri.encode(dateTime),
                Uri.encode(zip),
                Uri.encode(city),
                Uri.encode(address));

        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.url = requestURL;
        requestBuilder.requestMethod = "GET";
        requestBuilder.classMap = DeliveryCheck.class;
        setStandarRequestHeader(requestBuilder);

        execute(requestBuilder);
    }

    /**
     *
     * @param restaurantId
     * @param subTotal
     * @param tip
     * @param dateTime
     * @param zip
     * @param city
     * @param address
     */
    public void getFee(String restaurantId, String subTotal,String tip,String dateTime, String zip, String city, String address)
    {
        String requestURL = String.format("https://r-test.ordr.in/fee/%s/%s/%s/%s/%s/%s/%s",
                Uri.encode(restaurantId),
                Uri.encode(subTotal),
                Uri.encode(tip),
                Uri.encode(dateTime),
                Uri.encode(zip),
                Uri.encode(city),
                Uri.encode(address));

        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.url = requestURL;
        requestBuilder.requestMethod = "GET";
        requestBuilder.classMap = Fee.class;
        setStandarRequestHeader(requestBuilder);

        execute(requestBuilder);
    }

    /**
     *
     * @param requestBuilder
     * @return
     */
    private RequestBuilder setStandarRequestHeader(RequestBuilder requestBuilder)
    {
        requestBuilder.headers = new String[]{"X-NAAMA-CLIENT-AUTHENTICATION", "id=\"gHcf1ByS7m04QUIPuGbHMaDdzSPuIz8k5AdZ6iHNzu8\", version=\"1\""};

        return requestBuilder;
    }
}
