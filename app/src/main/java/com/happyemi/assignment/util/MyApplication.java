package com.happyemi.assignment.util;

import com.happyemi.assignment.Dagger2.AppComponent;
import com.happyemi.assignment.Dagger2.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author Pramod
 * @since 05 Jan 2019.
 */

public class MyApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
