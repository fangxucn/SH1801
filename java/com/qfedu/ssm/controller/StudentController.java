package com.qfedu.ssm.controller;

import com.qfedu.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/showStudent")
    public void showStudent(
            @RequestParam("id") int id,
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(studentService.findStudentById(id));
    }

    @RequestMapping("/showStudentPage")
    public void showStudentPage(
            @RequestParam("pageNo") int pageNo,
            @RequestParam("pageSize") int pageSize,
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(studentService.findStudentByPage(pageNo,pageSize));
    }




}
