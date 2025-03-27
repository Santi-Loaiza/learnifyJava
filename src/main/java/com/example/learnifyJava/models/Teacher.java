package com.example.learnifyJava.models;

import jakarta.persistence.Entity;

@Entity
public class Teacher {
    private Integer idTeacher;
    private String speciality;

    public Teacher(){
    }

    public Teacher(Integer idTeacher, String especiality) {
        this.idTeacher = idTeacher;
        this.speciality = especiality;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
