package com.example.yangyang.gp_health_aid.bean;

import org.litepal.crud.LitePalSupport;

public class Passage extends LitePalSupport {
    String pic_uri;
    String title;
    String passage_uri;

    public String getPic_uri() {
        return pic_uri;
    }

    public void setPic_uri(String pic_uri) {
        this.pic_uri = pic_uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassage_uri() {
        return passage_uri;
    }

    public void setPassage_uri(String passage_uri) {
        this.passage_uri = passage_uri;
    }
}
