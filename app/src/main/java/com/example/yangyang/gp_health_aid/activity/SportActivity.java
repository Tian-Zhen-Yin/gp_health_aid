package com.example.yangyang.gp_health_aid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.bean.Sport;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class SportActivity extends AppCompatActivity {
    Intent intent ;
    Integer month;
    Integer day;
    List<Sport> sports = new ArrayList<>();
    LinearLayout ll;
    Button btn_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        ll = findViewById(R.id.ll);
        intent = getIntent();
        month = intent.getIntExtra("month",0);
        day = intent.getIntExtra("day",0);
        sports = LitePal.where("day=?",day+"").find(Sport.class);
        for (int i = 0;i<sports.size();i++ ){
            Sport sport = sports.get(i);
            TextView textView = new TextView(this);
            textView.setText("今天做了   "+sport.getSport()+"    花费了    "+sport.getDuration()+"小时");
            ll.addView(textView);
        }
        btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.deleteAll(Sport.class);
            }
        });

    }

}
