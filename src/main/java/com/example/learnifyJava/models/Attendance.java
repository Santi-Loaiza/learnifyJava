package com.example.learnifyJava.models;

import com.example.learnifyJava.helpers.TypeStatusAttendance;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "asistencias")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAttendance;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    private Course course;

    @Column(name = "fecha", nullable = false)
    private Date date;

    @Column(name = "estado", nullable = false)
    private TypeStatusAttendance status;

    public Attendance() {
    }

    public Attendance(Integer idAttendance, Date date, TypeStatusAttendance status) {
        this.idAttendance = idAttendance;
        this.date = date;
        this.status = status;
    }

    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeStatusAttendance getStatus() {
        return status;
    }

    public void setStatus(TypeStatusAttendance status) {
        this.status = status;
    }
}
