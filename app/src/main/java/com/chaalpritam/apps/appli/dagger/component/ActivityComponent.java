package com.chaalpritam.apps.appli.dagger.component;

import com.chaalpritam.apps.appli.dagger.scope.ActivityScope;
import com.chaalpritam.apps.appli.view.BaseActivity;
import com.chaalpritam.apps.appli.view.MainActivity;

import dagger.Component;

/**
 * Created by chaalpritam on 19/5/17.
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent extends AppComponent {

    void inject (BaseActivity baseActivity);

    void inject (MainActivity mainActivity);
}