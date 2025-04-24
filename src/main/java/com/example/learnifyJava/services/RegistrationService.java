package com.example.learnifyJava.services;

import com.example.learnifyJava.models.Registration;
import com.example.learnifyJava.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository repository;

    //Metodo para guardar
    public Registration saveRegistration(Registration registrationData) throws Exception{
        try {
            return this.repository.save(registrationData);
        } catch(Exception e){
            throw new Exception();
        }
    }
}
