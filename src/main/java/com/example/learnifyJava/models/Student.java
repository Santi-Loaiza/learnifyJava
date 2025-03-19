package com.example.learnifyJava.models;

import java.util.Date;

public class Student {
    private Integer idStudent;
    private Integer grade;
    private Date BirthDate;
    private String address;

    public Student() {
    }

    public Student(Integer idStudent, Integer grade, Date birthDate, String address) {
        this.idStudent = idStudent;
        this.grade = grade;
        BirthDate = birthDate;
        this.address = address;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
