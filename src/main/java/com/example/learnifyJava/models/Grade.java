package com.example.learnifyJava.models;

import java.util.Date;

public class Grade {
    private Integer idGrade;
    private Float score;
    private Date testDate;

    public Grade() {
    }

    public Grade(Integer idGrade, Float score, Date testDate) {
        this.idGrade = idGrade;
        this.score = score;
        this.testDate = testDate;
    }

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
