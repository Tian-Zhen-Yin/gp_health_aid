package com.example.yangyang.gp_health_aid.activity;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.bean.Sport;

import java.util.Calendar;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_height;
    private EditText et_weight;
    private Button btn_down;
    private Button btn_edit;
    private Button btn_add_sport;
    private Button btn_query_sport;
    private EditText et_sport_name;
    private EditText et_sport_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        et_height = findViewById(R.id.height);
        et_weight = findViewById(R.id.et_weight);
        btn_down = findViewById(R.id.btn_down);
        btn_down.setOnClickListener(this);
        btn_edit = findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(this);
        btn_add_sport = findViewById(R.id.btn_add_sport);
        btn_add_sport.setOnClickListener(this);
        btn_query_sport = findViewById(R.id.btn_query_sport);
        btn_query_sport.setOnClickListener(this);
        et_sport_name = findViewById(R.id.et_sport_name);
        et_sport_time = findViewById(R.id.et_sport_time);


    }

    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        switch (view.getId()){
            case R.id.btn_edit:
                et_height.setEnabled(true);
                et_weight.setEnabled(true);
                break;
            case R.id.btn_down:
                et_height.setText(et_height.getText().toString());
                et_weight.setText(et_weight.getText().toString());
                et_height.setEnabled(false);
                et_weight.setEnabled(false);
                break;
            case R.id.btn_add_sport:
                String sport_name = et_sport_name.getText().toString();
                String sport_time = et_sport_time.getText().toString();
                Sport sport = new Sport();
                if (!sport_name.isEmpty()&&!sport_time.isEmpty()){
                    sport.setSport(sport_name);
                    sport.setDuration(Integer.parseInt(sport_time));
                    sport.setMonth(calendar.get(Calendar.MONTH));
                    sport.setDay(calendar.get(Calendar.DAY_OF_MONTH));
                    if (sport.save()){
                        Toast.makeText(InfoActivity.this,"运动保存成功",Toast.LENGTH_SHORT).show();
                        et_sport_time.setText("");
                        et_sport_name.setText("");
                    }
                }

                break;
            case R.id.btn_query_sport:
                new DatePickerDialog(InfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Intent intent = new Intent(InfoActivity.this,SportActivity.class);
                        intent.putExtra("month",month);
                        intent.putExtra("day",day);
                        startActivity(intent);
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }


}
