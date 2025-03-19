package com.example.learnifyJava.models;

import java.sql.Timestamp;

public class Registration {
    private Integer idRegistration;
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
