package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Attendance;
import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo para buscarTodos
    public List<Attendance> listAttendances()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception();
        }
    }

    //Metodo para buscarUnoPorId
    public Attendance searchAttendanceById(Integer idAttendance)throws Exception{
        try{
            Optional<Attendance> attendanceOnSearching=this.repository.findById(idAttendance);
            if(attendanceOnSearching.isPresent()){
                return attendanceOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_ATTENDANCE_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para modificar
    public Attendance modifyAttendance(Integer idAttendance, Attendance newAttendanceData)throws Exception{
        try{
            Optional<Attendance> attendanceOnSearchingForModifying=this.repository.findById(idAttendance);
            if(attendanceOnSearchingForModifying.isPresent()){
                //Modifico el docente
                attendanceOnSearchingForModifying.get().setStatus(newAttendanceData.getStatus());
                //Guardo las modificaciones en BD
                return this.repository.save(attendanceOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_ATTENDANCE_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteAttendance(Integer idAttendance)throws Exception{
        try{
            Optional<Attendance> attendanceOnSearching=this.repository.findById(idAttendance);
            if(attendanceOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idAttendance);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_ATTENDANCE_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
