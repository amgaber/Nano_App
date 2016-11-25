package com.mal.android.nanotourism;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by toshiba1 on 11/25/2016.
 */
public class CityActivityDetails extends AppCompatActivity {

    private static final String TAG =CityActivityDetails.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }
}
