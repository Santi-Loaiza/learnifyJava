package com.example.learnifyJava.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "inscripciones")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idRegistration;


    @CreationTimestamp
    @Column(name = "fecha_inscripcion", updatable = false)
    private Timestamp dateRegistration;

    public Registration() {
    }

    public Registration(Integer idRegistration, Timestamp dateRegistration) {
        this.idRegistration = idRegistration;
        this.dateRegistration = dateRegistration;
    }

    public Integer getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Integer idRegistration) {
        this.idRegistration = idRegistration;
    }

    public Timestamp getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Timestamp dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
