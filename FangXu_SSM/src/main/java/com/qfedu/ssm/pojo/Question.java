package com.qfedu.ssm.pojo;

import java.util.Set;

/**
 * Author:方旭
 * Date:2018/6/15 0015
 */


public class Question {
    private Integer id;
    private String subject;
    private String answer;

    private Set<Paper> papers;

    public Integer getId() {
        return id;
    }

    public Question setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Question setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Question setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public Question setPapers(Set<Paper> papers) {
        this.papers = papers;
        return this;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", answer='" + answer + '\'' +
                ", papers=" + papers +
                '}';
    }
}
