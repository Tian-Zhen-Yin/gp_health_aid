package com.example.yangyang.gp_health_aid.fragmentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.example.yangyang.gp_health_aid.R;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract BaseFragment setRootView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(Bundle savedInstanceState) {
        @SuppressLint("RestrictedApi")
        ContentFrameLayout cotainer = new ContentFrameLayout(this);
        cotainer.setId(R.id.fragment_container);
        setContentView(cotainer);
        if(savedInstanceState == null){
            loadRootFragment(R.id.fragment_container,setRootView());
        }

    }
}
