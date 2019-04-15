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

public class PasswordfindActivity extends AppCompatActivity {
  EditText telphone;
  Button findBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordfind);
        telphone=findViewById(R.id.pnum);
        findBtn=findViewById(R.id.find_btn);
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPassword();
            }
        });
    }

    private void findPassword() {

        String telnum=telphone.getText().toString();
        if (telnum.equals("")){
            Toast.makeText(this,"手机号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }


        OkHttpClient client = new OkHttpClient.Builder().build();
        RequestBody formBody = new FormBody.Builder()
                .add("phone",telnum)
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
                        Toast.makeText(PasswordfindActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
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
                        startActivity(new Intent(PasswordfindActivity.this,LoginActivity.class));
                    }
                });
            }
        });

    }

}
