package com.qfedu.ssm.service.impl;

import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.mapper.StudentMapper;
import com.qfedu.ssm.pojo.Student;
import com.qfedu.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertIntoStudent(student);
    }

    @Override
    public int removeStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Student findStudentByNameAndPassword(String name, String password) {
        Student student = studentMapper.selectStudentByNameAndPassword(name, password);
        return student;
    }

    @Override
    public boolean findName(String name) {
        Student student = studentMapper.selectName(name);
        if (student != null) {
            return true;
        }
        return false;
    }

    @Override
    public Student findStudentById(int id) {
        return studentMapper.selectById(id);
    }

    @Override
    public int editStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public PageInfo<Student> findStudentByPage(int pageNo, int pageSize) {

        PageInfo<Student> pageInfo = new PageInfo<>();
        int start = (pageNo - 1) * pageSize;

        List<Student> items = studentMapper.findStudentPage(start, pageSize);

        Long count = studentMapper.findStudentCount();


        int pageCount = (int) ((count / pageSize) + (count % pageSize == 0 ? 0 : 1));
        pageInfo.setItems(items);
        pageInfo.setPageCount(pageCount);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);


        return pageInfo;
    }


}
