package com.example.yangyang.gp_health_aid.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yangyang on 2019/4/2.
 * 项目名：gp_health_aid
 * 包名 ： com.example.yangyang.gp_health_aid.bean
 * 作用：
 */
public class User {
    private String name;
    private String info;

    private String username;
    private String password;

    private ArrayList<String> web_history;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getWeb_history() {
        return web_history;
    }

    public void setWeb_history(ArrayList<String> web_history) {
        this.web_history = web_history;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String question;
    private String answer;


}
