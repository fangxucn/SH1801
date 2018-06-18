package com.qfedu.ssm.service.impl;

import com.qfedu.ssm.mapper.PaperMapper;
import com.qfedu.ssm.pojo.Paper;
import com.qfedu.ssm.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:方旭
 * Date:2018/6/18 0018
 */

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;
    @Override
    public int addPaper(Paper paper) {
        return paperMapper.insertIntoPaper(paper);
    }
}
