package com.qfedu.ssm.pojo;

public class Course {
    private Integer id;
    private String name;
    private Integer tid;


    private Teacher teacher;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                ", teacher=" + teacher +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Course setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getTid() {
        return tid;
    }

    public Course setTid(Integer tid) {
        this.tid = tid;
        return this;
    }
}
