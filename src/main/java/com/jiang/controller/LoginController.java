package com.jiang.controller;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/20.
 */

import com.jiang.service.LoginService;
import com.jiang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    //controller 调 service 层
    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;

    //查询全部的学生，并返回到一个学生展示界面
    @RequestMapping("/dologin")
    public String getLoginById(int id, String password,Model model, HttpSession httpSession){
        if( loginService.queryLoginById(id)== null){
            model.addAttribute("msg","用户名或密码错误，请重新登录！");
            return "redirect:/";
        }
        String s = loginService.queryLoginById(id).getPassword();
        System.out.println(s);
        if(s.equals(password)) {
            System.out.println("login success");
            httpSession.setAttribute("user_id",id);
            if(loginService.queryLoginById(id).getAdmin() ==1)
                return "redirect:/student/admin";
            else
                return "redirect:/student/updateface";
        }

        model.addAttribute("msg","用户名或密码错误，请重新登录！");
        return "redirect:/";
    }

}
