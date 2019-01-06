package com.happyemi.assignment.Dagger2;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Pramod
 * @since 05 Jan 2019.
 */
@Module
public class UtilsModule {

    @Provides
    @Singleton
    CompositeDisposable provideDisposable(){
        return new CompositeDisposable();
    }
}
