package com.chaalpritam.apps.appli.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaalpritam.apps.appli.R;
import com.chaalpritam.apps.appli.model.Data;

import java.util.Collections;
import java.util.List;

/**
 * Created by chaalpritam on 19/5/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<Data> dataList;

    private OnItemClickListener onItemClickListener;

    public DataAdapter() {
        this.dataList = Collections.emptyList();
    }

    public DataAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_card, parent, false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Data data = dataList.get(position);
        Context context = holder.title.getContext();
        holder.data = data;
        holder.id.setText("Id : " + data.getId());
        holder.userId.setText("UserId : " + data.getUserId());
        holder.title.setText(data.getTitle());
        holder.body.setText(data.getBody());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public View contentLayout;
        public TextView id, userId, title, body;
        public Data data;

        public DataViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            contentLayout = itemView.findViewById(R.id.layout_data_list);
            id = (TextView) itemView.findViewById(R.id.id);
            userId = (TextView) itemView.findViewById(R.id.userId);
            title = (TextView) itemView.findViewById(R.id.title);
            body = (TextView) itemView.findViewById(R.id.body);
        }

        @Override
        public void onClick(View v) {
            Data data = dataList.get(getAdapterPosition());
            int position = getAdapterPosition();
            Log.e("position - ", + position + "");
            onItemClickListener.onItemClick(data, position);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Data shops, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

