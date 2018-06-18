package com.qfedu.ssm.controller;

import com.qfedu.ssm.pojo.Teacher;
import com.qfedu.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import static com.qfedu.ssm.utils.PatternUtils.pPattern;
import static com.qfedu.ssm.utils.PatternUtils.uPattern;

/**
 * Author:方旭
 * Date:2018/6/17 0017
 */

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/questionmanage")
    public String questionmanage() {
        return "questionmanage";
    }

    @RequestMapping("/showQuestionPage")
    public void showStudentPage(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize,
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().print(teacherService.findTeacherByNameAndPassword(pageNo,pageSize));
    }
    @RequestMapping("/homepage")
    public String homepage() {
        return "homepage";
    }


    @RequestMapping("/tregister")
    public String tregister() {
        return "tregister";
    }


    @RequestMapping(value = "/dotreg", method = RequestMethod.POST)
    public String doreg(
            @RequestParam("name")
                    String name,
            @RequestParam("password")
                    String password,
            Map<String,Object> map,
            HttpServletRequest request
    ) {
        String msg="";
        //后端校验
        if(!Pattern.matches(uPattern, name)){
            msg="用户名格式非法";
            map.put("msg",msg);
            return "error";
        }
        if(!Pattern.matches(pPattern, password)){
            msg="密码格式非法";
            map.put("msg",msg);
            return "error";
        }


        Teacher teacher = new Teacher(name, password);

            teacherService.addTeacher(teacher);

        return "tlogin";
    }


    //前端还要请求username是否已经存在
    @RequestMapping("/findname")
    public void findUsername(HttpServletRequest request,
                             HttpServletResponse response, @RequestParam("name") String name) throws IOException {
        boolean bool = teacherService.findName(name);
        response.getWriter().write(bool+"");
    }




    @RequestMapping("/tlogin")
    public String tlogin(){
        return "tlogin";
    }

    @RequestMapping("/dotlogin")
    public void dotlogin(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam("tname")
                                String name,
                        @RequestParam("password")
                                String password
    ) throws IOException {
        Teacher teacher = teacherService.findTeacherByNameAndPassword(name, password);
        if(teacher!=null){
            request.getSession().setAttribute("user",teacher);
            response.getWriter().write("success");
        }else{
            request.getSession().setAttribute("user",null);
            response.getWriter().write("error");
        }
    }





}
