package com.example.ordrin.Location;

import android.location.Address;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/28/13
 * Time: 4:02 PM
 */
public interface LocationHelperListener
{
    public void onLocationSuccess(List<Address> result);
}
