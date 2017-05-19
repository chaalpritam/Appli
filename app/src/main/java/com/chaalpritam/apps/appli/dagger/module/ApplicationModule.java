package com.chaalpritam.apps.appli.dagger.module;

import android.content.Context;

import com.chaalpritam.apps.appli.AppliApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chaalpritam on 19/5/17.
 */

@Module
public class ApplicationModule {

    private AppliApplication application;

    public ApplicationModule(AppliApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context appContext() {
        return application;
    }
}