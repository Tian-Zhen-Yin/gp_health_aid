package com.example.yangyang.gp_health_aid.bean;

import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class History extends LitePalSupport {
    private String title;
    private String url;

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
