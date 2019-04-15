package com.example.yangyang.gp_health_aid.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.view.SwitchView;

public class MViewHolder extends RecyclerView.ViewHolder {

    public TextView show;
    public SwitchView sw;
    public TextView tv_delete;

    public MViewHolder(View itemView) {
        super(itemView);
        show = itemView.findViewById(R.id.show);
        sw = itemView.findViewById(R.id.sw);
        tv_delete = itemView.findViewById(R.id.tv_delete);
    }
}

