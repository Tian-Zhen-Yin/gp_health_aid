package com.example.yangyang.gp_health_aid.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.view.SwitchView;

public class HistoryHolder extends RecyclerView.ViewHolder {

    public TextView show;
    public TextView tv_delete;

    public HistoryHolder(View itemView) {
        super(itemView);
        show = itemView.findViewById(R.id.info_show);
        tv_delete = itemView.findViewById(R.id.history_delete);
    }
}