package com.example.learnifyJava.services;

import com.example.learnifyJava.models.Student;
import com.example.learnifyJava.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    //Metodo para guardar
    public Student saveStudent(Student studentData) throws Exception{
        try {
            return this.repository.save(studentData);
        } catch(Exception e){
            throw new Exception();
        }
    }
}
