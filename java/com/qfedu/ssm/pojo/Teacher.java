package com.qfedu.ssm.pojo;

import java.util.List;

public class Teacher {
    private Integer id;
    private String name;

    private List<Course> courses;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Teacher setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Teacher setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }
}
