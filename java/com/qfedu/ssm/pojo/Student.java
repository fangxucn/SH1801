package com.qfedu.ssm.pojo;

import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    private List<Score> scores;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", scores=" + scores +
                '}';
    }

    public List<Score> getScores() {
        return scores;
    }

    public Student setScores(List<Score> scores) {
        this.scores = scores;
        return this;
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

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }
}
