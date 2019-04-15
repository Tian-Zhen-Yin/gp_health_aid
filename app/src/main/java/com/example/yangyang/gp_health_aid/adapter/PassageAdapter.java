package com.example.yangyang.gp_health_aid.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.activity.PassageActivity;
import com.example.yangyang.gp_health_aid.bean.History;
import com.example.yangyang.gp_health_aid.bean.Passage;

import java.util.ArrayList;

public class PassageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Passage> data;

    public PassageAdapter(Context context, ArrayList<Passage> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_passage,viewGroup,false);
            viewHolder.textView = view.findViewById(R.id.tv_title);
            viewHolder.imageView = view.findViewById(R.id.iv_passage);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(data.get(i).getPic_uri()).into(viewHolder.imageView);
        TextView textView = viewHolder.textView;
        textView.setText(data.get(i).getTitle());
        final int j = i;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PassageActivity.class);
                intent.putExtra("uri",data.get(j).getPassage_uri());
                context.startActivity(intent);
            }
        });
        return view;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}




















