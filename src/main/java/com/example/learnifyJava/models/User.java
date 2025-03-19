package com.example.learnifyJava.models;

import com.example.learnifyJava.helpers.TypeUser;

public class User {
    private Integer idUser;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private TypeUser userType;

    public User() {
    }

    public User(Integer idUser, String name, String password, String email, String phoneNumber, TypeUser userType) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TypeUser getUserType() {
        return userType;
    }

    public void setUserType(TypeUser userType) {
        this.userType = userType;
    }
}
