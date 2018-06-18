package com.qfedu.ssm.mapper;

import com.qfedu.ssm.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public interface QuestionMapper {
    int insertIntoQuestion(Question question);
    int updateQuestion(Question question);
    int deleteQuestion(int id);

    List<Question> findQuestionPageCount10();


    List<Question> findQuestionPage(@Param("start") int start, @Param("size") int size);
    Long findQuestionCount();
}
