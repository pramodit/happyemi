package com.happyemi.assignment.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happyemi.assignment.R;
import com.happyemi.assignment.pojo.Forecastday;
import com.happyemi.assignment.util.Util;

import java.util.List;


/**
 * @author Pramod
 * @since 05 Jan 2019.
 */
public class WeatherListAdapter extends RecyclerView.Adapter
{
    private static final String TAG = "Weather";
    private List<Forecastday> forecastDayList;

    public WeatherListAdapter(List<Forecastday> forecastDayList) {
        this.forecastDayList = forecastDayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row,parent,false);
        return new NewsViewHolder(view);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        NewsViewHolder rHolder = (NewsViewHolder) holder;

        String dayString = Util.getDayString(forecastDayList.get(position).getDate());
        Log.e(TAG, "onBindViewHolder:  Day String "+dayString +"  at position  "+position);
        if (!TextUtils.isEmpty(dayString))
            rHolder.tv_day.setText(dayString);

        rHolder.tv_temperature.setText(String.format("%.0f",forecastDayList.get(position).getDay().getMaxtempC())+" C");

    }

    @Override
    public int getItemCount() {
        return forecastDayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_day;
        TextView tv_temperature;

        NewsViewHolder(View itemView) {
            super(itemView);

            tv_day = itemView.findViewById(R.id.tv_forecast_day);
            tv_temperature = itemView.findViewById(R.id.tv_forecast_temperature);


        }
    }
}
