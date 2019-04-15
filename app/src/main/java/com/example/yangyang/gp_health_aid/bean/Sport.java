package com.example.yangyang.gp_health_aid.bean;

import org.litepal.crud.LitePalSupport;

import java.util.Date;

public class Sport extends LitePalSupport {
    private int month;
    private int day;
    private String sport;
    private int duration;


    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
