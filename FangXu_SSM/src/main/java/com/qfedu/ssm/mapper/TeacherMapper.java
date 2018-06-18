package com.qfedu.ssm.mapper;

import com.qfedu.ssm.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * Author:方旭
 * Date:2018/6/17 0017
 */


public interface TeacherMapper {
    int insertIntoTeacher(Teacher teacher);

    Teacher selectTeacherByNameAndPassword(@Param("name") String name, @Param("password") String password);


    Teacher selectName(@Param("name") String name);
}
