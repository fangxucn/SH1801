package com.qfedu.ssm.service;

import com.qfedu.ssm.pojo.Teacher;

/**
 * Author:方旭
 * Date:2018/6/17 0017
 */


public interface TeacherService {
    int addTeacher(Teacher teacher);
    Teacher  findTeacherByNameAndPassword(String name ,String password);
    boolean findName(String name );
}
