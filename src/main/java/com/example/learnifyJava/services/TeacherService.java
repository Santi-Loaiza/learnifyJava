package com.example.learnifyJava.services;

import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    //Metodo para guardar
    public Teacher saveTeacher(Teacher teacherData )throws Exception{
        try{
            return this.repository.save(teacherData);
        } catch(Exception e){
            throw new Exception();
        }
    }
    //Metodo para buscarTodos
    public List<Teacher> listTeachers()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception();
        }
    }

    //Metodo para buscarUnoPorId

    //Metodo para modificar

    //Metodo para eliminar
}
