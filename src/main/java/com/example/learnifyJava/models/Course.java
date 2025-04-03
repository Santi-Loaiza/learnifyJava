package com.example.learnifyJava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCourse;

    @Column(name = "nombre", length = 100, unique = false, nullable = false)
    private String name;

    // Creando la relacion  ( Muchos a uno)

    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id_docente")
    @JsonBackReference
    private Teacher teacher;

    //Creando la relacion (Uno a muchos)
    @OneToMany( mappedBy ="course")
    @JsonManagedReference
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Subject> subjects;

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
