package com.qfedu.ssm.service.impl;

import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.mapper.QuestionMapper;
import com.qfedu.ssm.pojo.Question;
import com.qfedu.ssm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int addQuestion(Question question) {
        return questionMapper.insertIntoQuestion(question);
    }

    @Override
    public int removeQuestion(int id) {
        return questionMapper.deleteQuestion(id);
    }

    @Override
    public int editQuestion(Question question) {
        return questionMapper.updateQuestion(question);
    }

    @Override
    public List<Question> findQuestionByPageCount10() {
        return questionMapper.findQuestionPageCount10();
    }

    @Override
    public PageInfo<Question> findQuestionByPage(int pageNo, int pageSize) {
        PageInfo<Question> pageInfo = new PageInfo<>();
        int start=(pageNo-1)*pageSize;
        List<Question> items = questionMapper.findQuestionPage(start, pageSize);
        Long count = questionMapper.findQuestionCount();
        int pageCount= (int) ((count/pageSize)+(count%pageSize==0?0:1));
        pageInfo.setItems(items);
        pageInfo.setPageCount(pageCount);
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);

        return pageInfo;
    }


}
