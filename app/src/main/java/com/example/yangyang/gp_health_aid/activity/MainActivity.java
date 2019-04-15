package com.example.yangyang.gp_health_aid.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.activity.alarm.AlarmActivity;
import com.example.yangyang.gp_health_aid.fragment.MyFragment;
import com.example.yangyang.gp_health_aid.fragment.ReadFragment;
import com.example.yangyang.gp_health_aid.fragment.WelcomeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_container;
    private TextView tv_home;
    private TextView tv_read;
    private TextView tv_my;

    private MyFragment myFragment = new MyFragment();
    private ReadFragment readFragment = new ReadFragment();
    private WelcomeFragment welcomeFragment = new WelcomeFragment();
    private Fragment currentFragment = null;
    AlertDialog builder = null;
    private FragmentManager fragmentManager;

    private void requirePermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            String permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
            if (ActivityCompat.checkSelfPermission(MainActivity.this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission},123);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requirePermission();
        initView();
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            builder = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("温馨提示：")
                    .setMessage("您是否要退出程序？")
                    .setCancelable(false)
                    .setPositiveButton("确定", (dialog, whichButton) -> {

                        MainActivity.this.finish();
                    })
                    .setNegativeButton("取消", (dialog, whichButton) -> {

                        builder.dismiss();
                    }).show();
        }
        return true;
    }
    private void initView() {
        rl_container = findViewById(R.id.rl_container);
        tv_home = findViewById(R.id.tv_home);
        tv_read = findViewById(R.id.tv_read);
        tv_my = findViewById(R.id.tv_my);

        tv_home.setOnClickListener(this);
        tv_read.setOnClickListener(this);
        tv_my.setOnClickListener(this);

        //显示第一个fragment
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.add(R.id.rl_container,welcomeFragment);
        transaction.add(R.id.rl_container,readFragment);
        transaction.hide(readFragment);
        transaction.add(R.id.rl_container,myFragment);
        transaction.hide(myFragment);
        transaction.commit();
        currentFragment = welcomeFragment;
        tv_home.setTextColor(Color.BLUE);
    }



    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.tv_home:
                transaction.hide(currentFragment).show(welcomeFragment);
                transaction.commit();
                currentFragment = welcomeFragment;
                tv_home.setTextColor(Color.BLUE);
                tv_read.setTextColor(Color.BLACK);
                tv_my.setTextColor(Color.BLACK);
                break;
            case R.id.tv_read:
                transaction.hide(currentFragment).show(readFragment);
                transaction.commit();
                currentFragment = readFragment;
                tv_read.setTextColor(Color.BLUE);
                tv_home.setTextColor(Color.BLACK);
                tv_my.setTextColor(Color.BLACK);
                break;
            case R.id.tv_my:
                transaction.hide(currentFragment).show(myFragment);
                transaction.commit();
                currentFragment = myFragment;
                tv_my.setTextColor(Color.BLUE);
                tv_read.setTextColor(Color.BLACK);
                tv_home.setTextColor(Color.BLACK);
                break;
        }
    }
}
