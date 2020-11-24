package com.jiang.utils;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/24.
 */

public class User_list {
    private String group_id;
    private String user_id;
    private String user_info;
    private String score;

    public User_list(){

    }

    public User_list(String group_id, String user_id, String user_info, String score) {
        this.group_id = group_id;
        this.user_id = user_id;
        this.user_info = user_info;
        this.score = score;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
