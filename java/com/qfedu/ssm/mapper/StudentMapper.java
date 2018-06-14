package com.qfedu.ssm.mapper;

import com.qfedu.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Student selectStudent(@Param("id") int id);
    List<Student> findStudentPage(@Param("start") int start,@Param("size") int size);
    Long findStudentCount();
}

