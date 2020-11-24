package com.jiang.service;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/19.
 */

import com.jiang.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {    //增
    int addStudent(Student student);
    //删
    int deleteStudentById(@Param("studentId") int id);
    //改
    int updateStudent(Student student);
    //查一个学生
    Student queryStudentById(@Param("studentId") int id);
    //查全部学生
    List<Student> queryAllStudent();
    //搜索功能
    List<Student> searchStudent(@Param("info") String info);
}
