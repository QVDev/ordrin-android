package com.example.ordrin.Networking;

/**
 * Created with IntelliJ IDEA.
 * User: dirkwilmer
 * Date: 3/28/13
 * Time: 11:04 AM
 */
public interface RestNetworkingListener
{
    public void onNetworkingSuccess(Object result);
    public abstract void onNetworkingProgress(Integer... progress);
}
