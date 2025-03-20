package com.example.learnifyJava.models;

public class Course {
    private Integer idCourse;
    private String name;

    public Course() {
    }

    public Course(Integer idCourse, String name) {
        this.idCourse = idCourse;
        this.name = name;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
