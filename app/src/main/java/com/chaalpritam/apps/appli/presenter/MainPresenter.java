package com.chaalpritam.apps.appli.presenter;

import android.util.Log;

import com.chaalpritam.apps.appli.model.ApiService;
import com.chaalpritam.apps.appli.model.Data;
import com.chaalpritam.apps.appli.presenter.Contract.MainContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chaalpritam on 19/5/17.
 */

public class MainPresenter implements MainContract.IMainPresenter {

    public static String TAG = MainPresenter.class.getSimpleName();

    private MainContract.IMainView view;
    private CompositeDisposable subscription = new CompositeDisposable();

    private List<Data> dataList;

    private ApiService apiService;

    @Inject
    public MainPresenter(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void attachView(MainContract.IMainView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        if (subscription != null) subscription.clear();
    }

    @Override
    public void getMainData() {
        if (subscription != null) subscription.clear();
        subscription.add(apiService.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<List<Data>>() {
                    @Override
                    public void onNext(List<Data> dataList) {
                        MainPresenter.this.dataList = dataList;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "Error loading data ", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "data loaded " + dataList);
                        if (!dataList.isEmpty()) {
                            view.setDataAdapter(dataList);
                        }
                    }
                }));
    }
}
