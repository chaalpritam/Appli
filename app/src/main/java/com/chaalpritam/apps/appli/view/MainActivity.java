package com.chaalpritam.apps.appli.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chaalpritam.apps.appli.R;
import com.chaalpritam.apps.appli.adapter.DataAdapter;
import com.chaalpritam.apps.appli.model.Data;
import com.chaalpritam.apps.appli.presenter.Contract.MainContract;
import com.chaalpritam.apps.appli.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.IMainView {

    @Inject
    MainPresenter mainPresenter;

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private List<Data> dataList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        mainPresenter.attachView(this);

        recyclerView = (RecyclerView) findViewById(R.id.data_recycler_view);

        setUpRecyclerView(recyclerView);
        Log.e("get main data", "");
        mainPresenter.getMainData();
    }

    public void setUpRecyclerView(RecyclerView recyclerView) {
        adapter = new DataAdapter();
        adapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Data data, int position) {
                Log.e("Clicked ", position + " adapter");
//                startActivity(DataDetailActivity.newIntent(MainActivity.this, data));
            }
        });
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setDataAdapter(List<Data> dataList) {
        adapter = (DataAdapter) recyclerView.getAdapter();
        Log.e("Setting List to", "adapter");
        adapter.setDataList(dataList);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.detachView();
        super.onDestroy();
    }
}
