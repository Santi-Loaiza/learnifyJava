package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    //Metodo para guardar
    public Teacher saveTeacher(Teacher teacherData )throws Exception{
        try{
            return this.repository.save(teacherData);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarTodos
    public List<Teacher> listTeachers()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarUnoPorId
    public Teacher searchTeacherById(Integer idTeacher)throws Exception{
        try{
            Optional<Teacher> teacherOnSearching=this.repository.findById(idTeacher);
            if(teacherOnSearching.isPresent()){
              return teacherOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_TEACHER_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para modificar
    public Teacher modifyTeacher(Integer idTeacher, Teacher newTeacherData)throws Exception{
        try{
            Optional<Teacher> teacherOnSearchingForModifying=this.repository.findById(idTeacher);
            if(teacherOnSearchingForModifying.isPresent()){
                //Modifico el docente
                teacherOnSearchingForModifying.get().setSpeciality(newTeacherData.getSpeciality());
                //Guardo las modificaciones en BD
                return this.repository.save(teacherOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_TEACHER_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteTeacher(Integer idTeacher)throws Exception{
        try{
            Optional<Teacher> teacherOnSearching=this.repository.findById(idTeacher);
            if(teacherOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idTeacher);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_TEACHER_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
