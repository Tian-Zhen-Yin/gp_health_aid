package com.example.yangyang.gp_health_aid.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.activity.ConsultActivity;
import com.example.yangyang.gp_health_aid.activity.InfoActivity;
import com.example.yangyang.gp_health_aid.activity.SettingActivity;
import com.example.yangyang.gp_health_aid.activity.alarm.AlarmActivity;


public class MyFragment extends Fragment implements View.OnClickListener {
    private TextView tv_info_query;
    private TextView tv_body_exam;
    private TextView tv_online_consult;
    private TextView tv_base_setting;


    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        tv_info_query = view.findViewById(R.id.tv_info_query);
        tv_body_exam = view.findViewById(R.id.tv_body_exam);
        tv_online_consult = view.findViewById(R.id.tv_online_consult);
        tv_base_setting = view.findViewById(R.id.tv_base_setting);

        tv_info_query.setOnClickListener(this);
        tv_body_exam.setOnClickListener(this);
        tv_online_consult.setOnClickListener(this);
        tv_base_setting.setOnClickListener(this);

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SET_ALARM,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                2);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_info_query:
                startActivity(new Intent(getContext(),InfoActivity.class));
                break;
            case R.id.tv_body_exam:
                Intent intent = new Intent(getContext(),AlarmActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_online_consult:
                startActivity(new Intent(getContext(),ConsultActivity.class));
                break;
            case R.id.tv_base_setting:
                startActivity(new Intent(getContext(),SettingActivity.class));
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
