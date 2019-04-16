package com.example.yangyang.gp_health_aid.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yangyang.gp_health_aid.R;

import java.io.InputStream;

public class ConsultActivity extends AppCompatActivity {
    EditText questionEdit;
    Button consultBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        questionEdit=findViewById(R.id.question_info);
        consultBtn=findViewById(R.id.consult_btn);
        consultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.120ask.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
