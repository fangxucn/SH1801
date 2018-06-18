package com.qfedu.ssm.service;

import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.pojo.Student;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public interface StudentService {
    int addStudent(Student student);
int removeStudent(int id);
    Student findStudentByNameAndPassword(String name, String password);

    boolean findName(String name);

    Student findStudentById(int id);

    int editStudent(Student student);

    PageInfo<Student> findStudentByPage(int pageNo, int pageSize);
}
