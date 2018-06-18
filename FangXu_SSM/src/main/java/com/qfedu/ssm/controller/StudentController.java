package com.qfedu.ssm.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qfedu.ssm.bean.PageInfo;
import com.qfedu.ssm.pojo.Paper;
import com.qfedu.ssm.pojo.Question;
import com.qfedu.ssm.pojo.Student;
import com.qfedu.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static com.qfedu.ssm.utils.PatternUtils.pPattern;
import static com.qfedu.ssm.utils.PatternUtils.uPattern;
/**
 * Author:方旭
 * Date:2018/6/15 0015
 */

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
//    @Autowired
//    private PaperService paperService;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/doreg", method = RequestMethod.POST)
    public String doreg(
            @RequestParam("name")
                    String name,
            @RequestParam("password")
                    String password,
            @RequestParam("gender")
                    String gender,
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
        if(!("男".equals(gender)||"女".equals(gender))){
            msg="性别不对";
            map.put("msg",msg);
            return "error";
        }


        Student student = new Student(name, password, gender);

        studentService.addStudent(student);

//        User user = new User(username, password, gender, email, telephone);
//        userService.addUser(user);

        return "login";
    }


    //前端还要请求username是否已经存在
    @RequestMapping("/findname")
    public void findUsername(HttpServletRequest request,
                             HttpServletResponse response, @RequestParam("name") String name) throws IOException {
        boolean bool = studentService.findName(name);
        response.getWriter().write(bool+"");
    }




    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/dologin")
    public void dologin(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam("stuname")
                                String name,
                        @RequestParam("password")
                                String password
    ) throws IOException {
        Student student = studentService.findStudentByNameAndPassword(name, password);
        if(student!=null){
            request.getSession().setAttribute("student",student);
            response.getWriter().write("success");
        }else{
            request.getSession().setAttribute("student",null);
            response.getWriter().write("error");
        }
    }

    @RequestMapping("/preserve")

    public void preserve(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam("json")
                                String json,
                        @RequestParam("stuid")
                                int stuid
    ) throws IOException {

        Set<Question> questions = new Gson().fromJson(json, new TypeToken<Set<Question>>() {
        }.getType());
        System.out.println(questions);
        Student student = studentService.findStudentById(stuid);
        System.out.println("学生："+student);
        Paper paper = new Paper();
//        paperService.addPaper(paper);
        student.setPaper(paper);
//        studentService.editStudent(student);
        paper.setQuestions(questions);

        if(questions!=null){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("error");
        }
    }
    @RequestMapping("/studentmanage")
    public String questionmanage(){
        return "studentmanage";
    }



    @RequestMapping("/showStudentPage")
    public void showStudentPage(
            @RequestParam("pageno") int pageNo,
            @RequestParam("pagesize") int pageSize,
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        PageInfo<Student> pageInfo = studentService.findStudentByPage(pageNo, pageSize);
        Gson gson = new Gson();
        String toJson = gson.toJson(pageInfo);
        response.getWriter().write(toJson);
    }


    @RequestMapping("/deleleone")
    public void deleleone(@RequestParam("id") Integer id,
                          HttpServletResponse response)throws IOException{

        int i = studentService.removeStudent(id);
        if (i>0) {
            response.getWriter().write("{\"state\":\"success\"}");
        }
    }

}
