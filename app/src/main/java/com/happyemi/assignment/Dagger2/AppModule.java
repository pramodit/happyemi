package com.happyemi.assignment.Dagger2;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by ${3Embed} on 4/11/17.
 */
@Module
public abstract class AppModule {
    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);
}
