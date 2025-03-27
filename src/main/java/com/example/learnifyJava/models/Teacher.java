package com.example.learnifyJava.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "docentes")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer idTeacher;

    @Column(name = "especialidad", length = 100, unique = false, nullable = false)
    private String speciality;

    //Creando la relacion (Uno a muchos)
    @OneToMany( mappedBy ="teacher")
    @JsonManagedReference
    private List<Course> courses;

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
