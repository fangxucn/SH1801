package com.qfedu.ssm.service;

import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.pojo.Question;

import java.util.List;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public interface QuestionService {
    int addQuestion(Question question);
    int removeQuestion(int id);
    int editQuestion(Question question);

    List<Question> findQuestionByPageCount10();
    PageInfo<Question> findQuestionByPage(int pageNo, int pageSize);
}
