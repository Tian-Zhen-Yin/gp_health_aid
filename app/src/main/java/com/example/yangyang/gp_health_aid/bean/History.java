package com.example.yangyang.gp_health_aid.bean;

import java.util.ArrayList;
import java.util.List;

public class History {
    private String title;
    private String url;

    public History(String s, String s1) {
        this.title=s;
        this.url=s1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
