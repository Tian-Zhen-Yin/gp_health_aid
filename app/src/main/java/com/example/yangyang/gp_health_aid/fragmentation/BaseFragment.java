package com.example.yangyang.gp_health_aid.fragmentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseFragment extends SwipeBackFragment {

    public abstract Object setLayout();
    public abstract void onBindView( @Nullable Bundle savedInstanceState,View view);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if (setLayout() instanceof Integer){
            view = inflater.inflate((Integer) setLayout(),container,false);
        } else if(setLayout() instanceof View){
            view = (View) setLayout();
        } else {
            throw new ClassCastException("setlayout返回的类型不符合规范");
        }
        onBindView(savedInstanceState,view);
        return view;
    }




}
