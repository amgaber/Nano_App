package com.mal.android.nanotourism;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by toshiba1 on 11/23/2016.
 */

public class AppController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
