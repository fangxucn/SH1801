package com.qfedu.ssm.pojo;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public class Student {
    private Integer id;
    private String name;
    private String password;
    private String gender;

    private Integer pid;
    private Paper paper;

    private Teacher teacher;
//    private Date date;
    private int score;

    public Teacher getTeacher() {
        return teacher;
    }

    public Student setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public Student setDate(Date date) {
//        this.date = date;
//        return this;
//    }

    public int getScore() {
        return score;
    }

    public Student setScore(int score) {
        this.score = score;
        return this;
    }

    public Student() {
    }

    public Student(String name, String password, String gender) {
        this.name = name;
        this.password = password;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Student setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Integer getPid() {
        return pid;
    }

    public Student setPid(Integer pid) {
        this.pid = pid;
        return this;
    }

    public Paper getPaper() {
        return paper;
    }

    public Student setPaper(Paper paper) {
        this.paper = paper;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", pid=" + pid +
                ", paper=" + paper +
                ", teacher=" + teacher +
//                ", date=" + date +
                ", score=" + score +
                '}';
    }
}
