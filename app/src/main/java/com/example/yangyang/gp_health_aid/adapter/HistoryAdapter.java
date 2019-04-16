package com.example.yangyang.gp_health_aid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.ViewHolder.HistoryHolder;

import com.example.yangyang.gp_health_aid.bean.History;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryHolder> {
    private List<History> mDataList;
    private Context mContext;
    History history=PassageAdapter.history;
    private  HistoryAdapter.OnDeleteButtonClick onDeleteButtonClick;


    public  HistoryAdapter(List<History> mDataList, MAdapter.OnDeleteButtonClick onDeleteButtonClick) {

      this.mDataList = mDataList;
      this.onDeleteButtonClick = (OnDeleteButtonClick) onDeleteButtonClick;


    }

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new HistoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int i)
    {
        history= mDataList.get(i);
        holder.show.setText( history.getTitle());
        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteButtonClick.onBtnClicked(i,  history, holder.show);
            }
        });

    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public interface OnDeleteButtonClick{
        void onBtnClicked(int position, History data, TextView show);
    }


}
