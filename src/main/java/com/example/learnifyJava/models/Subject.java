package com.example.learnifyJava.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "materias")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Integer idSubject;


    @Column(name = "nombre", length = 100, nullable = false)
    private String name;

    //Creando la relacion (Uno a muchos)
    @OneToMany( mappedBy ="subject")
    @JsonManagedReference
    private List<Grade> grades;


    public Subject() {
    }

    public Subject(Integer idSubject, String name) {
        this.idSubject = idSubject;
        this.name = name;
    }

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
