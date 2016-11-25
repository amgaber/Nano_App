package com.mal.android.nanotourism;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by alaa gaber  on 11/25/2016.
 */
public class CityActivityDetails extends AppCompatActivity {

    private static final String TAG =CityActivityDetails.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView descTextView = (TextView) findViewById(R.id.descTextView);
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);


        String title = getIntent().getExtras().getString(MainActivity.CITY_NAME);
        String desc = getIntent().getExtras().getString(CityActivity.CITY_DESC);
        String urlImage=getIntent().getExtras().getString(CityActivity.CITY_IMG);

        titleTextView.setText(title);
        descTextView.setText(desc);

        Picasso.with(this.getApplication()).load(urlImage).centerCrop().resize(150, 150)
                .placeholder(R.drawable.abc_ic_star_black_36dp)
                .error(R.drawable.abc_ic_star_black_36dp).into(imageView);
    }
}
