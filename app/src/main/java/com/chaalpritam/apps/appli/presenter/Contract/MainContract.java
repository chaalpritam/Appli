package com.chaalpritam.apps.appli.presenter.Contract;

import com.chaalpritam.apps.appli.model.Data;

import java.util.List;

/**
 * Created by chaalpritam on 19/5/17.
 */

public interface MainContract {

    interface IMainPresenter {

        void attachView(IMainView view);

        void detachView();

        void getMainData();
    }

    interface IMainView {

        void setDataAdapter(List<Data> dataList);
    }
}