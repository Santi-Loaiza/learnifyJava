package com.example.learnifyJava.models;

import com.example.learnifyJava.helpers.TypeStatusAttendance;

import java.util.Date;

public class Attendance {
    private Integer idAttendance;
    private Date date;
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
