package com.jiang.controller;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/19.
 */

import com.jiang.pojo.Student;
import com.jiang.service.StudentService;
import com.jiang.utils.FaceGetList;
import com.jiang.utils.FaceSearch;
import com.jiang.utils.FaceUpdate;
import com.jiang.utils.User_list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import org.apache.commons.codec.binary.Base64;

@Controller
@RequestMapping("/student")
public class StudentController {
    //controller 调 service 层
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    //查询全部的学生，并返回到一个学生展示界面
    @RequestMapping("/allStudent")
    public String getAllList(Model model){
        List<Student> list = studentService.queryAllStudent();
        model.addAttribute("list",list);
        return "allStudent";
    }

    //启动搜索功能
    @RequestMapping("/searchStudent")
    public String SearchList(HttpServletRequest request){
        String info = request.getParameter("information") ;
        System.out.println(info);
        List<Student> list = studentService.searchStudent(info);
        request.removeAttribute("list");    //删除之前的缓存
        request.setAttribute("list",list);

        //提前编译出结果
        Map<Integer,String> faceList = new HashMap<Integer, String>();
        Iterator it = list.iterator();
        while (it.hasNext() ) {
            Student s = (Student) it.next();
            faceList.put(s.getId(), FaceGetList.faceGetList(s.getId()));
            System.out.println(s.getId()+ FaceGetList.faceGetList(s.getId()));
            try //延时0.3秒，防止百度云调用过载
            {
                Thread.sleep(1000);//单位：毫秒
            } catch (Exception e) {
            }
        }
        request.removeAttribute("faceList");    //删除之前的缓存
        request.setAttribute("faceList",faceList);

        return "searchStudent";
    }

    @RequestMapping("/adminStudent")
    public String AdminSearchList(HttpServletRequest request, Model model){

        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("user_id") == null){
            model.addAttribute("msg","你没有登录，无法获得相关页面");
            return "redirect:/";
        }

        String info = request.getParameter("information") ;
        //System.out.println(info);
        List<Student> list = studentService.searchStudent(info);
        request.removeAttribute("list");    //删除之前的缓存
        request.setAttribute("list",list);
        return "adminStudent";
    }

    @RequestMapping("/ToUpdata")
    public String AdminUpdataList(int id , Model model,HttpSession httpSession){
        if(httpSession.getAttribute("user_id") == null){
            model.addAttribute("msg","你没有登录，无法获得相关页面");
            return "redirect:/";
        }
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "updatastudent";
    }

    @RequestMapping("/Updata")
    public String AdminUpdataStudent(Student student){
       // System.out.println(student);
        studentService.updateStudent(student);
        //studentService.updateStudent(new Student(201892001,"王军腾","18698936266",555666888,"123456789@qq.com"));
        return "redirect:/student/adminStudent?information="+student.getId();
    }

    @RequestMapping("/ToDelete")
    public String AdminDeleteStudent(int id,Model model,HttpSession httpSession){
        if(httpSession.getAttribute("user_id") == null){
            model.addAttribute("msg","你没有登录，无法获得相关页面");
            return "redirect:/";
        }
        int flag=studentService.deleteStudentById(id);
        if(flag ==1)
            model.addAttribute("text","删除成功");
        else
            model.addAttribute("text","删除失败");
        return "deleteStudent";
    }

    @RequestMapping("/admin")
    public String Admin(Model model,HttpSession httpSession){
        if(httpSession.getAttribute("user_id") == null){
            model.addAttribute("msg","你没有登录，无法获得相关页面");
            return "redirect:/";
        }
        return "admin";
    }

    @RequestMapping("/addStudent")
    public String AdminaddStudent(Student student, Model model){
        int flag= studentService.addStudent(student);
        if(flag ==1)
            model.addAttribute("text","添加成功");
        else if(flag ==0)
            model.addAttribute("text","添加失败");
        return "redirect:/student/admin";
    }

    @RequestMapping("/updateface")
    public String UpdateFace(Model model,HttpSession httpSession){
        if(httpSession.getAttribute("user_id") == null){
            model.addAttribute("msg","你没有登录，无法获得相关页面");
            return "redirect:/";
        }
        return "updateFace";
    }

    @RequestMapping("/doUpdateFace")
    public String doUpdateFace(@RequestParam(value="face",required=false)MultipartFile file, Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user_id") == null){
            model.addAttribute("msg","你没有登录，无法获得相关页面");
            return "redirect:/";
        }
        int id = (Integer) httpSession.getAttribute("user_id");
        System.out.println(id);
        System.out.println(file.toString());
        if (!file.isEmpty()) {
            try {
                Base64 encoder = new Base64();
                // 通过base64来转化图片
                String data = encoder.encodeBase64String(file.getBytes());
                System.out.println(data);
                String  s = FaceUpdate.faceUpdate(id,data);
                System.out.println(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("msg","人脸添加成功");
        }
        else
            model.addAttribute("msg","人脸添加失败");

        return "redirect:/";
    }

    @RequestMapping("/doSearchFace")
    public String doSearchFace(@RequestParam(value="face",required=false)MultipartFile file, Model model,HttpServletRequest request){


        if (!file.isEmpty()) {
            try {
                Base64 encoder = new Base64();
                // 通过base64来转化图片
                String data = encoder.encodeBase64String(file.getBytes());
                System.out.println(data);
                List<User_list> list_face = FaceSearch.faceSearch(data);
                List<Student> list = null;
                if(list_face!=null) {
                    Iterator<User_list> its = list_face.iterator();
                     list = new ArrayList<Student>();
                    while (its.hasNext()) {
                        User_list user = its.next();
                        int id = Integer.parseInt(user.getUser_id());
                        double score = Double.parseDouble(user.getScore());
                        if (score > 80) {
                            list.add(studentService.queryStudentById(id));
                        }
                    }
                }



                request.removeAttribute("list");    //删除之前的缓存
                request.setAttribute("list",list);

                //提前编译出结果
                Map<Integer,String> faceList = new HashMap<Integer, String>();
                Iterator<Student> it = list.iterator();
                while (it.hasNext() ) {
                    Student s = (Student) it.next();
                    faceList.put(s.getId(), FaceGetList.faceGetList(s.getId()));
                    System.out.println(s.getId()+ FaceGetList.faceGetList(s.getId()));
                    try //延时0.3秒，防止百度云调用过载
                    {
                        Thread.sleep(1000);//单位：毫秒
                    } catch (Exception e) {
                    }
                }
                request.removeAttribute("faceList");    //删除之前的缓存
                request.setAttribute("faceList",faceList);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //model.addAttribute("msg","人脸添加成功");

        return "searchFaceStudent";
    }
}
