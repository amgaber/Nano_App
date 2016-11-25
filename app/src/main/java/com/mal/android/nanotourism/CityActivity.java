package com.mal.android.nanotourism;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.mal.android.nanotourism.adapter.CityAdapter;
import com.mal.android.nanotourism.backend.OnItemClickListener;
import com.mal.android.nanotourism.model.City;

import java.util.ArrayList;

/**
 * Created by alaa gaber on 11/25/2016.
 */
public class CityActivity extends AppCompatActivity{

    private static final String TAG = CityActivity.class.getSimpleName();
    public static final String CITY_DESC = "CITY_DESC";
    public static final String CITY_IMG = "CITY_IMG";

    private Firebase fire_ref_city;
    private RecyclerView cityrecyclerViewCity;
    private ArrayList<String> cityPlace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_city);

        cityrecyclerViewCity = (RecyclerView) findViewById(R.id.recycler_view_city);

        //Use RecyclerView to view List chat
        cityrecyclerViewCity.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        cityrecyclerViewCity.setLayoutManager(mLayoutManager);

        String cityName=getIntent().getStringExtra(MainActivity.CITY_NAME);
        firebaseForCity(cityName);
    }

    private void firebaseForCity(final String cityName) {

        if (cityName != null) {


            fire_ref_city = new Firebase("https://nanotourism-3a25b.firebaseio.com/Countries/"+cityName);

            fire_ref_city.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                for (com.firebase.client.DataSnapshot child : dataSnapshot.getChildren()) {
                    Log.v("DaTABASE", "placeName data 2: " + child.getKey());

                    Log.v("DaTABASE", "yourStringArray 2: " + child.child("name").getValue());
                    Log.v("DaTABASE", "yourStringArray 3: " + child.child("desc").getValue());
                    Log.v("DaTABASE", "yourStringArray 4: " + child.child("img").getKey());
                    Log.v("DaTABASE", "yourStringArray for string4: " + child.child("img").child(child.getKey()).getValue());
                    //setNames of City places
                    setDataTitles((String) child.child("name").getValue(),(String)child.child("desc").getValue(),(String)child.child("img").child(child.getKey()).getValue());



                    for (com.firebase.client.DataSnapshot children : dataSnapshot.child(cityName).getChildren()) {
                        //Here you can access the child.getKey()
//                        City iterator=children.getChildren().iterator().next().getValue(City.class);
                        Log.v("DaTABASE", "cities : " + children.getChildren().iterator().next());
                    }
                    ArrayList<City> c = (ArrayList<City>) dataSnapshot.child(cityName).getValue();
                    Log.v("DaTABASE", "test : " + c);
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        }
    }

    private void setDataTitles(String name, final String desc, final String img) {

        //Initialize arrayList if null
        if (null == cityPlace) {
            cityPlace = new ArrayList<String>();
        }

        cityPlace.add(name);


        //using recycler adapter with gridview
        CityAdapter cityListadapter = new CityAdapter(this, cityPlace);
        cityrecyclerViewCity.setAdapter(cityListadapter);
        cityListadapter.notifyDataSetChanged();

        //setClick listener for adapter to send data onclick
        cityListadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Toast.makeText(CityActivity.this, item, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(CityActivity.this, CityActivityDetails.class);
                intent.putExtra(MainActivity.CITY_NAME, item);
                intent.putExtra(CITY_DESC, desc);
                intent.putExtra(CITY_IMG, img);
                startActivity(intent);



            }
        });
    }

}

