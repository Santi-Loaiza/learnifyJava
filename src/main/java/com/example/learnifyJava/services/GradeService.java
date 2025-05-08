package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Grade;
import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    GradeRepository repository;

    //Metodo para guardar
    public Grade saveGrade(Grade gradeData) throws Exception{
        try{
            return this.repository.save(gradeData);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarTodos
    public List<Grade> listGrades()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarUnoPorId
    public Grade searchGradeById(Integer idGrade)throws Exception{
        try{
            Optional<Grade> gradeOnSearching=this.repository.findById(idGrade);
            if(gradeOnSearching.isPresent()){
                return gradeOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_GRADE_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    //Metodo para modificar
    public Grade modifyGrader(Integer idGrade, Grade newGradeData)throws Exception{
        try{
            Optional<Grade> gradeOnSearchingForModifying=this.repository.findById(idGrade);
            if(gradeOnSearchingForModifying.isPresent()){
                //Modifico el docente
                gradeOnSearchingForModifying.get().setScore(newGradeData.getScore());
                //Guardo las modificaciones en BD
                return this.repository.save(gradeOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_GRADE_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteGrade(Integer idGrade)throws Exception{
        try{
            Optional<Grade> gradeOnSearching=this.repository.findById(idGrade);
            if(gradeOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idGrade);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_GRADE_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
