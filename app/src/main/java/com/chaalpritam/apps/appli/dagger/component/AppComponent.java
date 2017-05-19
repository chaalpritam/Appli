package com.chaalpritam.apps.appli.dagger.component;

import android.content.Context;

import com.chaalpritam.apps.appli.dagger.module.ApplicationModule;
import com.chaalpritam.apps.appli.dagger.module.NetworkModule;
import com.chaalpritam.apps.appli.model.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chaalpritam on 19/5/17.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface AppComponent {

    Context appContext();

    ApiService apiService();
}
