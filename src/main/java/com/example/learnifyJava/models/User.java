package com.example.learnifyJava.models;

import com.example.learnifyJava.helpers.TypeUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUser;

    @Column(name = "nombre", length = 100, nullable = false)
    private String name;

    @Column(name = "correo", unique = true, length = 150, nullable = false)
    private String email;

    @Column(name = "contraseña", length = 255, nullable = false)
    private String password;

    @Column(name = "telefono", length = 20, nullable = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TypeUser userType;

    @OneToOne(mappedBy = "user")
    @JsonBackReference(value = "docente-usuario")
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    @JsonBackReference(value = "estudiante-usuario")
    private Student student;

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
