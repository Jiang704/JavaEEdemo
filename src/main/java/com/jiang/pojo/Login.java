package com.jiang.pojo;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/20.
 */

public class Login {
    private int id;
    private String password;
    private int admin;

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public Login() {
    }

    public Login(int id, String password, int admin) {
        this.id = id;
        this.password = password;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id+","+password;
    }
}
