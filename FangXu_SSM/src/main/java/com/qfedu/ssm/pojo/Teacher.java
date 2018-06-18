package com.qfedu.ssm.pojo;

import java.util.List;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public class Teacher {
    private Integer id;
    private String name;
    private String password;
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public Teacher setPassword(String password) {
        this.password = password;
        return this;
    }
}
