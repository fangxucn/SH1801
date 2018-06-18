package com.qfedu.ssm.mapper;

import com.qfedu.ssm.pojo.Paper;

/**
 * Author:方旭
 * Date:2018/6/18 0018
 */


public interface PaperMapper {
    int insertIntoPaper(Paper paper);
    int updatePaper(Paper paper);
}
