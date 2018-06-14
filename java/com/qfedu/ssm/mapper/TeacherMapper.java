package com.qfedu.ssm.mapper;

import com.qfedu.ssm.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int insert(Teacher teacher);
    Teacher selectTeacher(@Param("id") int id);
}
