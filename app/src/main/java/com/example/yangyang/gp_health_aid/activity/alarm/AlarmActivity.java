package com.example.yangyang.gp_health_aid.activity.alarm;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.activity.MainActivity;
import com.example.yangyang.gp_health_aid.adapter.MAdapter;
import com.example.yangyang.gp_health_aid.bean.Alarm;
import com.example.yangyang.gp_health_aid.broadcast.CallAlarm;
import com.example.yangyang.gp_health_aid.view.SwitchView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlarmActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RelativeLayout alarm_clock_left_back;
    ImageView add_alarm_clock;

    List<Alarm> mDataList = null;
    MAdapter adapter = null;
    AlertDialog builder = null;

    Alarm alarm;
    AlarmManager am;
    MediaPlayer mediaPlayer;

    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        mediaPlayer = MediaPlayer.create(this, R.raw.in_call_alarm);
        initConstant();
        initID();
        initDatas();
        initUI();
        initListener();
    }

    protected void initDatas() {
        mDataList = LitePal.findAll(Alarm.class);
    }

    private void initConstant() {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        if (alarm == null) {
            alarm = new Alarm();
        }
    }

    private void initListener() {
        alarm_clock_left_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmActivity.this.finish();
            }
        });
        add_alarm_clock.setOnClickListener(v -> {
            c = Calendar.getInstance();
            c.setTimeInMillis(System.currentTimeMillis());
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);
            new TimePickerDialog(AlarmActivity.this, (view, hourOfDay, minute) -> {
                c.setTimeInMillis(System.currentTimeMillis());
                c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                c.set(Calendar.MINUTE, minute);
                c.set(Calendar.SECOND, 0);
                c.set(Calendar.MILLISECOND, 0);
                Alarm alarm = saveAndUpdateAlarm(hourOfDay, minute);
                Intent intent = new Intent(AlarmActivity.this, CallAlarm.class);
                //penddingintent第二个参数id一定要设置为不同的id，如果设置为同一个id，多个闹钟会在同一个时间执行
                PendingIntent sender = PendingIntent.getBroadcast(AlarmActivity.this, alarm.getId(), intent, 0);

                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    am.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), sender);
                }

            }, mHour, mMinute, true).show();
        });
    }

    private void initID() {
        recyclerView = findViewById(R.id.recyclerView);
        relativeLayout = findViewById(R.id.relativeLayout);
        alarm_clock_left_back = findViewById(R.id.alarm_clock_left_back);
        add_alarm_clock = findViewById(R.id.add_alarm_clock);
    }

    private void closeAlarm(Alarm a) {
        Intent intent = new Intent(AlarmActivity.this, CallAlarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(AlarmActivity.this, a.getId(), intent, 0);
        AlarmManager am;
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.cancel(sender);
    }

    private void changeSwitchViewState(boolean b, SwitchView view, Alarm alarm) {
        view.setOpened(b);
        alarm.setAlarmActive(b);
        alarm.save();

        if (!b) {
            closeAlarm(alarm);
        }
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new MAdapter(mDataList, (position, data, show) -> {
            closeAlarm(data);
            updateUI(data);
        }, new MAdapter.OnSwitchViewToggleListener() {
            @Override
            public void toOn(SwitchView view, Alarm alarm) {
                changeSwitchViewState(true, view, alarm);
            }

            @Override
            public void toOff(SwitchView view, Alarm alarm) {
                changeSwitchViewState(false, view, alarm);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initUI() {
        if (mDataList.size() == 0) {
            relativeLayout.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            relativeLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        initRecyclerView();
    }

    private void updateUI(Alarm data) {
        data.delete();
        mDataList.remove(data);
        if (mDataList.size() == 0) {
            relativeLayout.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private Alarm saveAndUpdateAlarm(int hourOfDay, int minute) {
        if (recyclerView.getVisibility() == View.GONE) {
            relativeLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        String tmpS = format(hourOfDay) + "：" + format(minute);
        Alarm alarm = new Alarm();
        alarm.setAlarmData(tmpS);
        alarm.setAlarmActive(true);
        alarm.setId((int) (Math.random() * 2000));
        alarm.save();
        mDataList.add(alarm);
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        Log.e("MainAlarmActivity","添加闹钟时间：" + tmpS);
        return alarm;
    }


    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1) s = "0" + s;
        return s;
    }
}