package com.qfedu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    static{
        try {
            InputStream in=Resources.getResourceAsStream("mybatisConfig.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
            //去这个包下，找到所有的mapper，要求mapper和xml文件的文件名一样，后缀名分别是.java和.xml
            sqlSessionFactory.getConfiguration().addMappers("com.qfedu.mybatis.mapper");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static SqlSession session(){
        return sqlSessionFactory.openSession();
    }


}
