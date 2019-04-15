package com.example.yangyang.gp_health_aid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yangyang.gp_health_aid.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btn_register;
    private EditText et_username;
    private EditText et_password;
    private EditText et_name;
    private EditText et_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btn_register = findViewById(R.id.btn_update);
        et_username = findViewById(R.id.up_username);
        et_password = findViewById(R.id.up_password);
        et_name = findViewById(R.id.up_username);
        et_tel = findViewById(R.id.up_tel);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update:
                save();
                break;

        }
    }

    private void save() {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        String info = et_tel.getText().toString();
        String name = et_name.getText().toString();
        if (username.equals("")||password.equals("")){
            Toast.makeText(this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }


        OkHttpClient client = new OkHttpClient.Builder().build();
        RequestBody formBody = new FormBody.Builder()
                .add("username",username)
                .add("password",password)
                .add("info",info)
                .add("name",name)
                .add("question","")
                .add("answer","")
                .build();

        final Request request = new Request.Builder()
                .post(formBody)
                .url("http://47.104.168.58:8001/register")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(UserActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response)  {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(UserActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UserActivity.this,SettingActivity.class));
                    }
                });
            }
        });



}
}
