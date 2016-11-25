package com.mal.android.nanotourism;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.firebase.client.Firebase;
import com.mal.android.nanotourism.helper.Connector;

public class SplashActivity extends AppCompatActivity {

    private static final long DELAY_MILLIS = 3000;
    public static final String CITY_KEY = "CITY_KEY";
    private Firebase fire_ref;
    private String cityName;
    private Firebase fire_ref_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //use handler for Splash Screen
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Connector.IsConnected(SplashActivity.this))
                    StartMainActivity();
            }
        }, DELAY_MILLIS);

    }

    private void StartMainActivity() {
        finish();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
