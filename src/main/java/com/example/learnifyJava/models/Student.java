package com.example.learnifyJava.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idStudent;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonManagedReference(value = "estudiante-usuario")
    private User user;

    @Column(name = "grado", nullable = false)
    private Integer grade;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date birthDate;

    @Column(name = "direccion", length = 255, nullable = false)
    private String address;


    //Creando la relacion (Uno a muchos)
    @OneToMany( mappedBy ="student")
    @JsonManagedReference
    private List<Attendance> attendances;

    @OneToMany( mappedBy ="student")
    @JsonManagedReference
    private List<Grade> grades;

    public Student() {
    }

    public Student(Integer idStudent, Integer grade, Date birthDate, String address) {
        this.idStudent = idStudent;
        this.grade = grade;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
