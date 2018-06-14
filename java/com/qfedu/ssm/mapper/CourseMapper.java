package com.qfedu.ssm.mapper;

import com.qfedu.ssm.pojo.Course;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    Course selectCourse(@Param("id") int id);
    Course selectCourse2(@Param("id") int id);
}
