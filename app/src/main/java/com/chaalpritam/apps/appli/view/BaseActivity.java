package com.chaalpritam.apps.appli.view;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chaalpritam.apps.appli.AppliApplication;
import com.chaalpritam.apps.appli.dagger.component.ActivityComponent;
import com.chaalpritam.apps.appli.dagger.component.DaggerActivityComponent;

/**
 * Created by chaalpritam on 19/5/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent
                .builder()
                .appComponent(getApp().getAppComponent())
                .build();

        activityComponent.inject(this);
    }

    public AppliApplication getApp() {
        return (AppliApplication) getApplicationContext();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
