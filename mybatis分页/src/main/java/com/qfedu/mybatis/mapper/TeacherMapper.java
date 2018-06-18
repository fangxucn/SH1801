package com.qfedu.mybatis.mapper;

import com.qfedu.mybatis.pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

//最大值为512，你可以有512个对象的引用。
@CacheNamespace(size = 512)
public interface TeacherMapper {

    //SelectProvider叫查询语句提供者
    //需要指定类、类的方法，要求类的方法返回String类型，代表了sql语句。
    @SelectProvider(type=TeacherSQLProvider.class,method="getSql")
    //Results指对于结果的映射，需要指定结果集的列名和类的成员名的对应关系。
    @Results(value = {
            @Result(id = true, property = "id", column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    Teacher get(@Param("id") int id);


    @SelectProvider(type=TeacherSQLProvider.class,method="getAllSql")
    @Results(value={
            @Result(id = true, property = "id", column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<Teacher> getAll();

    @SelectProvider(type=TeacherSQLProvider.class,method="getByNameSql")
    @ResultMap(value="getByName")
    List<Teacher> getByName(@Param("name") String name);


    @InsertProvider(type=TeacherSQLProvider.class,method="insertSql")
    void insert(@Param("teacher") Teacher teacher);

    @UpdateProvider(type=TeacherSQLProvider.class,method="updateSql")
    void update(@Param("teacher") Teacher teacher);

    @DeleteProvider(type=TeacherSQLProvider.class,method="deleteSql")
    void delete(@Param("id")Integer id);
}
