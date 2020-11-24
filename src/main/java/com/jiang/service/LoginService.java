package com.jiang.service;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/20.
 */
import com.jiang.pojo.Login;
import org.apache.ibatis.annotations.Param;

public interface LoginService {
    //增
    int addLogin(Login login);
    //删
    int deleteLoginById(@Param("loginId") int id);
    //改
    int updateLogin(Login login);
    //查一个学生
    Login queryLoginById(@Param("id") int id);
}
