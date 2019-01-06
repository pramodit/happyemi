package com.happyemi.assignment.main_screen;

import com.happyemi.assignment.Dagger2.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
abstract public class MainModule {

    @ActivityScoped
    @Binds
    abstract MainPresenter mainPresenter(MainPresenterImpl presenter);

    @ActivityScoped
    @Binds
    abstract MainView mainView(MainActivity mainActivity);
}
