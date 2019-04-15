package com.example.yangyang.gp_health_aid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.yangyang.gp_health_aid.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    TextView passFind,searHitory,updateInfo,quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        passFind=findViewById(R.id.find_pas);
        searHitory=findViewById(R.id.search_history);
        updateInfo=findViewById(R.id.change_infor);
        quit=findViewById(R.id.quit);
        passFind.setOnClickListener(this);
        searHitory.setOnClickListener(this);
        updateInfo.setOnClickListener(this);
        quit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.quit:
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.change_infor:
                Intent intent1=new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intent1);
                break;
            case R.id.search_history:
                Intent intent2=new Intent(getApplicationContext(),HistoryActivity.class);
                startActivity(intent2);
                break;
            case R.id.find_pas:
                Intent intent3=new Intent(getApplicationContext(),PasswordfindActivity.class);
                startActivity(intent3);
                break;

        }
    }
}
