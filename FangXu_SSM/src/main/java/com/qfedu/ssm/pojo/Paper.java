package com.qfedu.ssm.pojo;

import java.util.Set;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public class Paper {
    private  Integer id;
    private Set<Student> students;
    private Set<Question> questions;

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", students=" + students +
                ", questions=" + questions +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Paper setId(Integer id) {
        this.id = id;
        return this;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Paper setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Paper setQuestions(Set<Question> questions) {
        this.questions = questions;
        return this;
    }
}
