package com.qfedu.ssm.service.impl;

import com.qfedu.ssm.mapper.TeacherMapper;
import com.qfedu.ssm.pojo.Teacher;
import com.qfedu.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:方旭
 * Date:2018/6/17 0017
 */

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.insertIntoTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByNameAndPassword(String name, String password) {
        return teacherMapper.selectTeacherByNameAndPassword(name,password);
    }

    @Override
    public boolean findName(String name) {
        Teacher teacher = teacherMapper.selectName(name);
        if (teacher!=null){
            return  true;
        }
        return false;
    }
}
