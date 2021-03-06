package com.qfedu.ssm.service;

import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.pojo.Student;

public interface StudentService {
    public Student findStudentById(int id);
    PageInfo<Student>  findStudentByPage(int pageNo,int pageSize);
}
