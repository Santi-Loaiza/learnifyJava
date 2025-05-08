package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Student;
import com.example.learnifyJava.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    //Metodo para guardar
    public Student saveStudent(Student studentData) throws Exception{
        try {
            return this.repository.save(studentData);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarTodos
    public List<Student> listStudents()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarUnoPorId
    public Student searchStudentById(Integer idStudent)throws Exception{
        try{
            Optional<Student> studentOnSearching=this.repository.findById(idStudent);
            if(studentOnSearching.isPresent()){
                return studentOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_STUDENT_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para modificar
    public Student modifyStudent(Integer idStudent, Student newStudentData)throws Exception{
        try{
            Optional<Student> studentOnSearchingForModifying=this.repository.findById(idStudent);
            if(studentOnSearchingForModifying.isPresent()){
                //Modifico el docente
                studentOnSearchingForModifying.get().setAddress(newStudentData.getAddress());
                //Guardo las modificaciones en BD
                return this.repository.save(studentOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_STUDENT_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteStudent(Integer idStudent)throws Exception{
        try{
            Optional<Student> studentOnSearching=this.repository.findById(idStudent);
            if(studentOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idStudent);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_STUDENT_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
