package com.example.learnifyJava.services;

import com.example.learnifyJava.helpers.APIMessages;
import com.example.learnifyJava.models.Teacher;
import com.example.learnifyJava.models.User;
import com.example.learnifyJava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    //Metodo para guardar
    public User saveUser(User userData )throws Exception{
        try{
            return this.repository.save(userData);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarTodos
    public List<User> listUser()throws Exception{
        try{
            return this.repository.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para buscarUnoPorId
    public User searchUserById(Integer idUser)throws Exception{
        try{
            Optional<User> userOnSearching=this.repository.findById(idUser);
            if(userOnSearching.isPresent()){
                return userOnSearching.get();
            } else{
                throw new Exception(APIMessages.ERROR_USER_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para modificar
    public User modifyUser(Integer idUser, User newUserData)throws Exception{
        try{
            Optional<User> userOnSearchingForModifying=this.repository.findById(idUser);
            if(userOnSearchingForModifying.isPresent()){
                //Modifico el docente
                userOnSearchingForModifying.get().setUserType(newUserData.getUserType());
                //Guardo las modificaciones en BD
                return this.repository.save(userOnSearchingForModifying.get());
            }else{
                throw new Exception(APIMessages.ERROR_USER_NOT_FOUND.getMessage());
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Metodo para eliminar
    public boolean deleteUser(Integer idUser)throws Exception{
        try{
            Optional<User> userOnSearching=this.repository.findById(idUser);
            if(userOnSearching.isPresent()){
                //Lo elimino
                this.repository.deleteById(idUser);
                return true;
            } else{
                throw new Exception(APIMessages.ERROR_USER_NOT_FOUND.getMessage());
            }
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
