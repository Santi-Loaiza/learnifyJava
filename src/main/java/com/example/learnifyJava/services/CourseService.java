package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Course;
import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    //Metodo para guardar
    public Course saveCourse(Course courseData) throws Exception{
        try{
            return this.repository.save(courseData);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarTodos
    public List<Course> listCourses()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarUnoPorId
    public Course searchCourseById(Integer idCourse)throws Exception{
        try{
            Optional<Course> courseOnSearching=this.repository.findById(idCourse);
            if(courseOnSearching.isPresent()){
                return courseOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_COURSE_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para modificar
    public Course modifyCourse(Integer idCourse, Course newCourseData)throws Exception{
        try{
            Optional<Course> courseOnSearchingForModifying=this.repository.findById(idCourse);
            if(courseOnSearchingForModifying.isPresent()){
                //Modifico el docente
                courseOnSearchingForModifying.get().setName(newCourseData.getName());
                //Guardo las modificaciones en BD
                return this.repository.save(courseOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_COURSE_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteCourse(Integer idCourse)throws Exception{
        try{
            Optional<Course> courseOnSearching=this.repository.findById(idCourse);
            if(courseOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idCourse);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_COURSE_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
