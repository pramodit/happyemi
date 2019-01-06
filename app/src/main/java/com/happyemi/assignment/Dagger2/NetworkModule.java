package com.happyemi.assignment.Dagger2;

import com.happyemi.assignment.networking.WebServices;
import com.happyemi.assignment.util.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Pramod
 * @since 05 Jan 2019.
 */
@Module
public class NetworkModule {
    public static final String NAME_BASE_URL="NAME_BASE_URL";

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrl(){
        return Constants.BASE_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter,@Named(NAME_BASE_URL) String baseUrl){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Provides
    @Singleton
    WebServices provideWebServices(Retrofit retrofit){
        return retrofit.create(WebServices.class);
    }

}
