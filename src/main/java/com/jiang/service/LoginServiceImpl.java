package com.jiang.service;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/20.
 */

import com.jiang.dao.LoginMapper;
import com.jiang.pojo.Login;

public class LoginServiceImpl implements LoginService{
    //service调dao层；组合dao
    private LoginMapper loginMapper;

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public int addLogin(Login login) {
        return loginMapper.addLogin( login) ;
    }

    @Override
    public int deleteLoginById(int id) {
        return loginMapper. deleteLoginById( id);
    }

    @Override
    public int updateLogin(Login login) {
        return loginMapper.updateLogin(login);
    }

    @Override
    public Login queryLoginById(int id) {
        return loginMapper.queryLoginById(id);
    }
}
