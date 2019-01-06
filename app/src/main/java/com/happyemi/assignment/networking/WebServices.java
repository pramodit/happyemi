package com.happyemi.assignment.networking;

import com.happyemi.assignment.pojo.WeatherPojo;
import com.happyemi.assignment.util.Constants;
import io.reactivex.Observable;
import retrofit2.Response;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Pramod
 * @since 05 Jan 2019.
 */

public interface WebServices {



    @GET("forecast.json")
    Observable<Response<WeatherPojo>> getWeather(@Query("key") String key,
                                                 @Query("q") String q,
                                                 @Query("days") int days);

}
