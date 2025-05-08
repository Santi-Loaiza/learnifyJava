package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Subject;
import com.example.learnifyJava.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository repository;

    //Metodo para guardar
    public Subject saveSubject(Subject subjectData )throws Exception{
        try{
            return this.repository.save(subjectData);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarTodos
    public List<Subject> listSubjects()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarUnoPorId
    public Subject searchSubjectById(Integer idSubject)throws Exception{
        try{
            Optional<Subject> subjectOnSearching=this.repository.findById(idSubject);
            if(subjectOnSearching.isPresent()){
                return subjectOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_SUBJECT_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para modificar
    public Subject modifySubject(Integer idSubject, Subject newSubjectData)throws Exception{
        try{
            Optional<Subject> subjectOnSearchingForModifying=this.repository.findById(idSubject);
            if(subjectOnSearchingForModifying.isPresent()){
                //Modifico el docente
                subjectOnSearchingForModifying.get().setName(newSubjectData.getName());
                //Guardo las modificaciones en BD
                return this.repository.save(subjectOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_SUBJECT_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteSubject(Integer idSubject)throws Exception{
        try{
            Optional<Subject> subjectOnSearching=this.repository.findById(idSubject);
            if(subjectOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idSubject);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_SUBJECT_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
