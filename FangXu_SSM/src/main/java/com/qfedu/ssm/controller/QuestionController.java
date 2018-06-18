package com.qfedu.ssm.controller;

import com.google.gson.Gson;
import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.pojo.Question;
import com.qfedu.ssm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/showquestion")
    public String showproduct(){
        return "showquestion";
    }

    @RequestMapping("/handover")
    public String handover(){
        return "handover";
    }



    @RequestMapping("/page")
    public void showQuestionPage(
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        List<Question> questionList = questionService.findQuestionByPageCount10();
        Gson gson = new Gson();
        String toJson = gson.toJson(questionList);
        response.getWriter().print(toJson);
    }

    @RequestMapping("/questionmanage")
    public String questionmanage(){
        return "questionmanage";
    }


    @RequestMapping("/showQuestionPage")
    public void showStudentPage(
            @RequestParam("pageno") int pageNo,
            @RequestParam("pagesize") int pageSize,
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        PageInfo<Question> pageInfo = questionService.findQuestionByPage(pageNo, pageSize);
        Gson gson = new Gson();
        String toJson = gson.toJson(pageInfo);
        response.getWriter().write(toJson);
    }
    @RequestMapping("/showedit")
    public String showedit(@RequestParam("id") Integer id,
//                           @RequestParam("subject") String subject,
//                           @RequestParam("answer") String answer,
                           Map<String,Object> map){
        map.put("id",id);
//        map.put("subject",subject);
//        map.put("answer",answer);

        return "showedit";
    }
    @RequestMapping("/edit")
    public void edit(
            @RequestParam("id")
                    Integer id,
            @RequestParam("name")
                    String name,
            @RequestParam("pnum")
                    String pnum,
            HttpServletResponse response

    ) throws IOException {

        Question question = new Question();
        question.setId(id);
        question.setSubject(name.replace(" ","+"));
        question.setAnswer(pnum);



   questionService.editQuestion(question);

        response.getWriter().write("{\"state\":\"success\"}");
    }


@RequestMapping("/showadd")
public String showadd(){
    return "showadd";
}

    @RequestMapping("/addquestion")
    public void addquestion(
            @RequestParam("name")
                    String name,
            @RequestParam("pnum")
                    String pnum,
            HttpServletResponse response

    ) throws IOException {

        Question question = new Question();
        question.setSubject(name.replace(" ","+"));
        question.setAnswer(pnum);


        questionService.addQuestion(question);

        response.getWriter().write("{\"state\":\"success\"}");
    }

    @RequestMapping("/deleleone")
    public void deleleone(@RequestParam("id") Integer id,
                          HttpServletResponse response)throws IOException{


        int i = questionService.removeQuestion(id);
        if (i>0) {
            response.getWriter().write("{\"state\":\"success\"}");
        }
    }

}
