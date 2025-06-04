package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Registration;
import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository repository;

    //Metodo para guardar
    public Registration saveRegistration(Registration registrationData) throws Exception{
        try {
            return this.repository.save(registrationData);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarTodos
    public List<Registration> listRegistrations()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarUnoPorId
    public Registration searchRegistrationById(Integer idRegistration)throws Exception{
        try{
            Optional<Registration> registrationOnSearching=this.repository.findById(idRegistration);
            if(registrationOnSearching.isPresent()){
                return registrationOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_REGISTRATION_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para modificar
    public Registration modifyRegistration(Integer idRegistration, Teacher newRegistrationData)throws Exception{
        try{
            Optional<Registration> registrationOnSearchingForModifying=this.repository.findById(idRegistration);
            if(registrationOnSearchingForModifying.isPresent()){
                //Modifico el docente
                registrationOnSearchingForModifying.get().setDateRegistration(newRegistrationData.getDateRegistration());
                //Guardo las modificaciones en BD
                return this.repository.save(registrationOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_REGISTRATION_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteRegistration(Integer idRegistration)throws Exception{
        try{
            Optional<Registration> registrationOnSearching=this.repository.findById(idRegistration);
            if(registrationOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idRegistration);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_REGISTRATION_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
