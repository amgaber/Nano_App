package com.mal.android.nanotourism.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

/**
 * Created by Alaa Gaber on 9/12/2016.
 */
public class Connector {


    public static boolean IsConnected(Context context) {

        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return networkInfo.isConnected();
        }else {
            return false;
        }
    }
}
