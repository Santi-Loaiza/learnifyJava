package com.example.learnifyJava.models;

public class Teacher {
    private Integer idTeacher;
    private String especiality;

    public Teacher(){
    }

    public Teacher(Integer idTeacher, String especiality) {
        this.idTeacher = idTeacher;
        this.especiality = especiality;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }
}
