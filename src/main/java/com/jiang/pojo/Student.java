package com.jiang.pojo;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/10.
 */

public class Student {
    private int id;
    private String name;
    private String phone;
    private int qq;
    private String email;

    public Student(){

    }

    public Student(int id, String name, String phone, int qq, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.qq = qq;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id+","+name+","+phone+","+qq+","+email;
}
}
