package com.qfedu.ssm.mapper;

import com.qfedu.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public interface StudentMapper {
    int insertIntoStudent(Student student);
    int deleteStudent(int id);

    Student selectStudentByNameAndPassword(@Param("name") String name, @Param("password") String password);

    Student selectName(String name);

    Student selectById(int id);

    int updateStudent(Student student);


    List<Student> findStudentPage(@Param("start") int start, @Param("size") int size);

    Long findStudentCount();
}
