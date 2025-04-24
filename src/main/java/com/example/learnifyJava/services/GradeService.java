package com.example.learnifyJava.services;

import com.example.learnifyJava.models.Grade;
import com.example.learnifyJava.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    GradeRepository repository;

    //Metodo para guardar
    public Grade saveGrade(Grade gradeData) throws Exception{
        try{
            return this.repository.save(gradeData);
        } catch(Exception e){
            throw new Exception();
        }
    }
}
