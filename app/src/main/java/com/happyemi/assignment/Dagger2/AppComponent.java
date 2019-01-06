package com.happyemi.assignment.Dagger2;

import android.app.Application;

import com.happyemi.assignment.util.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by ${3Embed} on 4/11/17.
 */

/**
 * This is a Dagger component. Refer to {@link MyApplication} for the list of Dagger components
 * used in this application.
 * <p>
 * Even though Dagger allows annotating a {@link Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * MyApplication}.
 * //{@link AndroidSupportInjectionModule}
 * // is the module from Dagger.Android that helps with the generation
 * // and location of sub components.
 */
@Singleton
@Component(modules = {AppModule.class,
        ActivityBindingModule.class,
        NetworkModule.class,
        UtilsModule.class,
        AndroidSupportInjectionModule.class})

public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(MyApplication application);

    @Override
    void inject(DaggerApplication instance);

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}