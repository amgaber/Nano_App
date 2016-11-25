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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.mal.android.nanotourism.adapter.CityAdapter;
import com.mal.android.nanotourism.backend.OnItemClickListener;
import com.mal.android.nanotourism.model.City;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by toshiba1 on 11/25/2016.
 */
public class CityActivity extends AppCompatActivity{

    private static final String TAG = CityActivity.class.getSimpleName();
    private Firebase fire_ref_city;
    private RecyclerView cityrecyclerViewCity;

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

                    Log.v("DaTABASE", "City data : "+child.child(child.getKey()).child(""));


                    Log.v(TAG,"PLace data: "+child.getValue());
                    Log.v(TAG,"PLace data: "+child.getChildren().iterator().next().getValue());

                    List<City> tempKey2 = (List<City>) dataSnapshot.child(cityName).getValue();
                    Log.v("DaTABASE", "DATABASE 2: " + tempKey2);

                    for (com.firebase.client.DataSnapshot children : dataSnapshot.child(cityName).getChildren()) {
                        //Here you can access the child.getKey()
//                        City iterator=children.getChildren().iterator().next().getValue(City.class);
                        Log.v("DaTABASE", "cities : " + children.getChildren().iterator().next());
                    }
                    ArrayList<City> c = (ArrayList<City>) dataSnapshot.child(cityName).getValue();
                    Log.v("DaTABASE", "test : " + c);

//                    int x = 1;
//                    Map<Integer,City> map = new HashMap<Integer, City>();
//                    for (com.firebase.client.DataSnapshot childMap: dataSnapshot.getChildren()) {
//                        ArrayList<City> mapArray = (ArrayList<City>) dataSnapshot.child(cityName).getValue();
//                        City name = null;
//                        for (int k=0;k < mapArray.size();k++) {
////                             name = mapArray.get(k);
//                            Log.v("DaTABASE", "Map : " + mapArray.get(k));
//                            map.put(x, mapArray.get(k));
//                        }
////                        map.put(x, name);
//                        x = x + 1;
//                    }
//                    Log.v("DaTABASE", "Map data : " + map.values());
//                    Collection cost = map.values();
//                    Log.v("DaTABASE", "Collection data : " + cost.iterator().next());


//                  //using recycler adapter with gridview
//                    CityAdapter cityListadapter = new CityAdapter(this, cityTitle);
//                    cityrecyclerView.setAdapter(cityListadapter);
//                    cityListadapter.notifyDataSetChanged();
//
//                    //setClick listener for adapter to send data onclick
//                    cityListadapter.setOnItemClickListener(new OnItemClickListener() {
//                        @Override
//                        public void onItemClick(String item) {
//                            Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
//
//                            Intent intent = new Intent(MainActivity.this, CityActivity.class);
//                            intent.putExtra(CITY_NAME, item);
//                            startActivity(intent);
//
//                        }
//                    });



                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        }
    }
}
