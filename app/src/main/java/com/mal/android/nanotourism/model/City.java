package com.mal.android.nanotourism.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by alaa gaber on 11/23/2016.
 */
@JsonIgnoreProperties("stackId")
public class City  implements Parcelable {


    String name;
//    int id;
    String desc;
    ArrayList<String> img = new ArrayList<>();


    public City(Parcel in) {
        name = in.readString();
        desc = in.readString();
        img = in.readArrayList(null);
//        id=in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(desc);
//        parcel.writeInt(id);
        parcel.writeList(img);
    }


    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

//    public String[] getImg() {
//        return img;
//    }
//
//    public void setImg(String[] img) {
//        this.img = img;
//    }


}
