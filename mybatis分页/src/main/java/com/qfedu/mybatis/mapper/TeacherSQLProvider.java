package com.qfedu.mybatis.mapper;

import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TeacherSQLProvider {
    /* 表名 */
    public static final String TABLE_NAME="teacher";
    public String getSql(Map<String,Object> parameters){
        Integer id=(Integer)parameters.get("id");
        //表示开始拼接sql语句
        BEGIN();
        SELECT("id,name");
        FROM(TABLE_NAME);
        if(id!=null){
            WHERE("id=#{id,javaType=Integer,jdbcType=INTEGER}");
        }
        return SQL();
    }

    public String getAllSql(){
        BEGIN();
        SELECT("id,name");
        FROM(TABLE_NAME);
        return SQL();
    }

    public String getByNameSql(Map<String,Object> parameters){
        String name=(String)parameters.get("name");
        BEGIN();
        SELECT("id,name");
        FROM(TABLE_NAME);
        if(name!=null){
            WHERE("name like #{name}");
        }
        return SQL();
    }



    public String insertSql(){
        BEGIN();
        INSERT_INTO(TABLE_NAME);
        //VALUES("id","#{teacher.id}");
        VALUES("name","#{teacher.name}");
        return SQL();
    }

    public String updateSql(){
        BEGIN();
        UPDATE(TABLE_NAME);
        SET("name=#{teacher.name}");
        WHERE("id=#{teacher.id}");
        return SQL();
    }

    public String deleteSql(){
        BEGIN();
        DELETE_FROM(TABLE_NAME);
        WHERE("id=#{id}");
        return SQL();
    }
}
