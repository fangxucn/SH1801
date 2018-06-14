package com.qfedu.ssm.pojo;

public class Score {
    private Integer sid;
    private Integer cid;
    private Integer score;

    private Student student;
    private Course course;

    @Override
    public String toString() {
        return "Score{" +
                "sid=" + sid +
                ", cid=" + cid +
                ", score=" + score +
                ", student=" + student +
                ", course=" + course +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public Score setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Score setCourse(Course course) {
        this.course = course;
        return this;
    }

    public Integer getSid() {
        return sid;
    }

    public Score setSid(Integer sid) {
        this.sid = sid;
        return this;
    }

    public Integer getCid() {
        return cid;
    }

    public Score setCid(Integer cid) {
        this.cid = cid;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Score setScore(Integer score) {
        this.score = score;
        return this;
    }
}
