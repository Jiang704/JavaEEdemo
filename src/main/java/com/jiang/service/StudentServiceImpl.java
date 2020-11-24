package com.jiang.service;/*
 * @Description:
 * @Author: 57246
 * @Date: 2020/10/19.
 */

import com.jiang.dao.StudentMapper;
import com.jiang.pojo.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    //service调dao层；组合dao
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent( student);
    }

    @Override
    public Student queryStudentById(int id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }

    @Override
    public List<Student> searchStudent(String info) {
        return studentMapper.searchStudent(info);
    }
}
