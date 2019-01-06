package com.happyemi.assignment.main_screen;

import android.util.Log;

import com.happyemi.assignment.networking.WebServices;
import com.happyemi.assignment.pojo.Current;
import com.happyemi.assignment.pojo.Forecast;
import com.happyemi.assignment.pojo.Forecastday;
import com.happyemi.assignment.pojo.WeatherPojo;
import com.happyemi.assignment.util.Constants;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter {

    @Inject
    MainView mainView;

    @Inject
    WebServices webServices;

    @Inject
    MainPresenterImpl() {
    }

    @Override
    public void getNews() {
        if (mainView!=null) {
            mainView.showProgress();
        }

        Observable<Response<WeatherPojo>> response = webServices.getWeather(Constants.API_KEY,"Bangalore",5);
        response.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Response<WeatherPojo>>() {

                    @Override
                    public void onNext(Response<WeatherPojo> value)
                    {
                        Log.e("HappyEmi","Server Req URL :: "+value.raw().request().url()+" code : "+value.code());
                        if (200 == value.code()) {
                            WeatherPojo responseBody = value.body();
                            if (responseBody!=null) {
                                String location_name = responseBody.getLocation().getName();
                                double temperature = responseBody.getCurrent().getTempC();
                                mainView.setCurrentWeather(temperature,location_name);
                                //ForeCast of 4
                                List<Forecastday> forecastDayList = responseBody.getForecast().getForecastday();
                                if (forecastDayList!=null) {
                                    if (forecastDayList.size()>0) {
                                        List<Forecastday> newList=new ArrayList<>();
                                        for (int i=1;i<forecastDayList.size();i++) {
                                            newList.add(forecastDayList.get(i));
                                        }
                                        mainView.addItems(newList);
                                    }
                                }
                            }
                        } else {
                            try {
                                if (value.errorBody()!=null) {
                                    JSONObject errJson = new JSONObject(value.errorBody().string());
                                    mainView.setError(errJson.getString("message"));
                                    mainView.hideProgress();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                mainView.hideProgress();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        mainView.hideProgress();
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        mainView.hideProgress();
                    }
                });

    }
}
