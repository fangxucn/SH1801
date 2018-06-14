package com.qfedu.ssm.service.impl;

import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.mapper.StudentMapper;
import com.qfedu.ssm.pojo.Student;
import com.qfedu.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentById(int id) {
        return studentMapper.selectStudent(id);
    }

    @Override
    public PageInfo<Student> findStudentByPage(int pageNo, int pageSize) {
        PageInfo<Student> pageInfo=new PageInfo<>();

        int start=(pageNo-1)*pageSize;
        List<Student> items=studentMapper.findStudentPage(start,pageSize);
        long count=studentMapper.findStudentCount();
        int pageCount= (int) ((count/pageSize)+(count%pageSize==0?0:1));
        pageInfo.setItems(items);
        pageInfo.setPageCount(pageCount);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);

        return pageInfo;
    }
}
