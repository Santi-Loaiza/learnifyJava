package com.example.learnifyJava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "calificaciones")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Integer idGrade;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_materia", referencedColumnName = "id_materia")
    @JsonBackReference
    private Subject subject;

    @Column(name = "nota", columnDefinition = "DECIMAL(5,2)", nullable = false)
    private Float score;

    @Column(name = "fecha_evaluacion", nullable = false)
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
