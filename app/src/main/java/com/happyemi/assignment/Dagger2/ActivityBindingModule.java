package com.happyemi.assignment.Dagger2;

import com.happyemi.assignment.main_screen.MainActivity;
import com.happyemi.assignment.main_screen.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Pramod
 * @since 05 Jan 2019.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
