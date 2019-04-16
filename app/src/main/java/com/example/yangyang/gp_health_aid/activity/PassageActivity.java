package com.example.yangyang.gp_health_aid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.bean.History;

public class PassageActivity extends AppCompatActivity {
    private WebView webView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passage);
        webView = findViewById(R.id.web_view);
        intent = getIntent();
        String uri = intent.getStringExtra("uri");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(uri);
    }
}
