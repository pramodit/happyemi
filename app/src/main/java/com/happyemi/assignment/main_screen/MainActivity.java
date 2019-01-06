package com.happyemi.assignment.main_screen;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.happyemi.assignment.R;
import com.happyemi.assignment.adapters.WeatherListAdapter;
import com.happyemi.assignment.pojo.Forecastday;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainView{

    private AlertDialog alertDialog;
    private AlertDialog.Builder dialogBuilder;

    private WeatherListAdapter weatherListAdapter;

    @BindString(R.string.wait_fetch_news) String wait_fetch_news;

    @BindView(R.id.tv_temperature)
    TextView tv_temperature;

    @BindView(R.id.tv_location)
    TextView tv_location;

    @BindView(R.id.rv_news)
    RecyclerView rv_news;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.getNews();
    }

    @Override
    public void addItems(List<Forecastday> list) {

        weatherListAdapter = new WeatherListAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_news.setLayoutManager(layoutManager);
        rv_news.setAdapter(weatherListAdapter);
    }


    @Override
    public void setCurrentWeather(double temperature, String location) {

        SpannableStringBuilder cs = new SpannableStringBuilder(String.format("%.0f", temperature)+"o");
        cs.setSpan(new SuperscriptSpan(), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        cs.setSpan(new RelativeSizeSpan(0.75f), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_temperature.setText(cs);
        tv_location.setText(location);
    }

    @Override
    public void setError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        if (!isFinishing()) {
            dialogBuilder = new AlertDialog.Builder(MainActivity.this);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View dialogView = inflater.inflate(R.layout.progress_dialog_layout, null);
            TextView tv_progress = dialogView.findViewById(R.id.tv_progress);
            tv_progress.setText(wait_fetch_news);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setCancelable(false);
            alertDialog = dialogBuilder.create();
            alertDialog.show();
        }

    }

    @Override
    public void hideProgress() {
        alertDialog.dismiss();
    }
}
