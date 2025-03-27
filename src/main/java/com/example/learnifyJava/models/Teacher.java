package com.example.learnifyJava.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Teacher {
    private Integer idTeacher;
    private String speciality;

    //Creando la relacion (Uno a muchos)
    @OneToMany( mappedBy ="teacher")
    @JsonManagedReference
    private List<Course> course;

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
