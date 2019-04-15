package com.example.yangyang.gp_health_aid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yangyang.gp_health_aid.R;

import org.litepal.LitePal;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_register;
    private TextView tv_find_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LitePal.initialize(getApplicationContext());

        initView();
    }

    private void initView() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        tv_find_pass = findViewById(R.id.tv_find_pass);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        tv_find_pass.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.tv_find_pass:

                break;


        }
    }

    private void login() {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        if (username.equals("")||password.equals("")){
            Toast.makeText(this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        OkHttpClient client = new OkHttpClient.Builder().build();
        RequestBody formBody = new FormBody.Builder()
                .add("username",username)
                .add("password",password)
                .build();

        final Request request = new Request.Builder()
                .post(formBody)
                .url("http://47.104.168.58:8001/login")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String result = response.body().string();
               Log.d("TAG",result);
               if (result.equals("true")){
                   startActivity(new Intent(LoginActivity.this,MainActivity.class));
               }else {
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                       }
                   });
               }
            }
        });



    }


}
