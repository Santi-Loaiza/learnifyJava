package com.example.learnifyJava.services;

import com.example.learnifyJava.models.Course;
import com.example.learnifyJava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    //Metodo para guardar
    public Course saveCourse(Course courseData) throws Exception{
        try{
            return this.repository.save(courseData);
        } catch(Exception e){
            throw new Exception();
        }
    }
}
