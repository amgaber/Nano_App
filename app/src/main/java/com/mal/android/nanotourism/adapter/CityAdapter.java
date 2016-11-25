package com.mal.android.nanotourism.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mal.android.nanotourism.MainActivity;
import com.mal.android.nanotourism.R;
import com.mal.android.nanotourism.backend.OnItemClickListener;
import com.mal.android.nanotourism.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba1 on 11/25/2016.
 */
public class CityAdapter  extends RecyclerView.Adapter<CityAdapter.CustomViewHolder> {


    private final Context mContext;
    private final List<String> CityItemList;

    private OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CityAdapter(Context context, List<String> CityItemList) {
        this.CityItemList = CityItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, final int i) {
//        City cityItem = CityItemList.get(i);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(CityItemList.get(i));
            }
        };

        //Setting text view title
        customViewHolder.textView.setText(CityItemList.get(i));
//        customViewHolder.textView.setOnClickListener(listener);
        customViewHolder.rlRow.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return (null != CityItemList ? CityItemList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private final RelativeLayout rlRow;
        protected TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.rlRow=(RelativeLayout) view.findViewById(R.id.rlRow);
        }
    }
}