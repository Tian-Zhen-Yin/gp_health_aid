package com.example.yangyang.gp_health_aid.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.activity.alarm.AlarmActivity;
import com.example.yangyang.gp_health_aid.adapter.HistoryAdapter;
import com.example.yangyang.gp_health_aid.adapter.MAdapter;
import com.example.yangyang.gp_health_aid.adapter.PassageAdapter;
import com.example.yangyang.gp_health_aid.bean.Alarm;
import com.example.yangyang.gp_health_aid.bean.History;
import com.example.yangyang.gp_health_aid.bean.Passage;
import com.example.yangyang.gp_health_aid.broadcast.CallAlarm;
import com.example.yangyang.gp_health_aid.db.MyDB;
import com.example.yangyang.gp_health_aid.util.HistoryUtil;
import com.example.yangyang.gp_health_aid.view.SwitchView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.litepal.LitePalApplication.getContext;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<History> mDataList = null;
    History history;
    HistoryAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initDatas();
        initConstant();
        initID();
        initRecyclerView();
        initUI();


    }
    protected void initDatas() {
        mDataList = LitePal.findAll(History.class);
    }
    private void initConstant() {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        if (history == null) {
            history = new History();
        }
    }


    private void initID() {
        recyclerView = findViewById(R.id.history_recyclerView);

    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new HistoryAdapter(mDataList, (int position, Alarm data, TextView show) -> { updateUI(data); });
        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(adapter);
    }

    private void initUI() {
        if (mDataList.size() == 0) {
            recyclerView.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
        }
        initRecyclerView();
    }
    
    private void updateUI(Alarm data) {
        data.delete();
        mDataList.remove(data);
        if (mDataList.size() == 0)
        {
            recyclerView.setVisibility(View.GONE);
        } else {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }







}
