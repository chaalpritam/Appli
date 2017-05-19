package com.chaalpritam.apps.appli;

import android.app.Application;

import com.chaalpritam.apps.appli.dagger.component.AppComponent;
import com.chaalpritam.apps.appli.dagger.component.DaggerAppComponent;
import com.chaalpritam.apps.appli.dagger.module.ApplicationModule;

/**
 * Created by chaalpritam on 19/5/17.
 */

public class AppliApplication extends Application {

    public static final String TAG = AppliApplication.class.getSimpleName();

    private static AppliApplication instance;
    private AppComponent appComponent;

    public static AppliApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        instance = this;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}