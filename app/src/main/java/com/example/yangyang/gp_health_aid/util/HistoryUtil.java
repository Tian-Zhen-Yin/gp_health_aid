package com.example.yangyang.gp_health_aid.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yangyang.gp_health_aid.bean.History;

public class HistoryUtil {

    public static  History saveAndUpdateHistory(String title, String uri) {

        History history=new History();
        history.setUrl(uri);
        history.setTitle(title);
        history.save();

        return history;
    }
}
