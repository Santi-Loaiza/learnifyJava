package com.example.learnifyJava.services;

import com.example.learnifyJava.models.Attendance;
import com.example.learnifyJava.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository repository;

    //Metodo para guardar
    public Attendance saveAttendance(Attendance attendanceData) throws Exception{
        try{
            return this.repository.save(attendanceData);
        } catch(Exception e){
            throw new Exception();
        }
    }
}
